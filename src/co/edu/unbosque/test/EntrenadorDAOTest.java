package co.edu.unbosque.test;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link EntrenadorDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de entrenadores.
 */
public class EntrenadorDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private EntrenadorDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new EntrenadorDAO();
    }

    /**
     * Prueba agregar y buscar un entrenador.
     */
    @Test
    public void testAddAndFindEntrenador() {
        EntrenadorDTO dto = new EntrenadorDTO("entrenador1", "pass", "correo@correo.com", "Colombia", "Bogota");
        assertTrue(dao.add(dto));
        Entrenador found = dao.find(new Entrenador("entrenador1", "pass", "correo@correo.com", "Colombia", "Bogota"));
        assertNotNull(found);
        assertEquals("entrenador1", found.getNombre());
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba que no se puedan agregar entrenadores duplicados.
     */
    @Test
    public void testAddDuplicateEntrenador() {
        EntrenadorDTO dto = new EntrenadorDTO("entrenador2", "pass", "correo2@correo.com", "Colombia", "Medellin");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba eliminar un entrenador existente.
     */
    @Test
    public void testDeleteEntrenador() {
        EntrenadorDTO dto = new EntrenadorDTO("entrenador3", "pass", "correo3@correo.com", "Colombia", "Cali");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new Entrenador("entrenador3", "pass", "correo3@correo.com", "Colombia", "Cali")));
    }

    /**
     * Prueba eliminar un entrenador que no existe.
     */
    @Test
    public void testDeleteNonExistentEntrenador() {
        EntrenadorDTO dto = new EntrenadorDTO("entrenador4", "pass", "correo4@correo.com", "Colombia", "Cali");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un entrenador existente.
     */
    @Test
    public void testUpdateEntrenador() {
        EntrenadorDTO dtoOld = new EntrenadorDTO("entrenador5", "pass", "correo5@correo.com", "Colombia", "Cali");
        EntrenadorDTO dtoNew = new EntrenadorDTO("entrenador5", "newpass", "correo5@correo.com", "Colombia", "Cali");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        Entrenador found = dao.find(new Entrenador("entrenador5", "newpass", "correo5@correo.com", "Colombia", "Cali"));
        assertNotNull(found);
        assertEquals("newpass", found.getContrasena());
        dao.delete(dtoNew); // Eliminar usuario de prueba
    }

    /**
     * Prueba actualizar un entrenador que no existe.
     */
    @Test
    public void testUpdateNonExistentEntrenador() {
        EntrenadorDTO dtoOld = new EntrenadorDTO("entrenador6", "pass", "correo6@correo.com", "Colombia", "Cali");
        EntrenadorDTO dtoNew = new EntrenadorDTO("entrenador6", "newpass", "correo6@correo.com", "Colombia", "Cali");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los entrenadores cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaEntrenadores(new ArrayList<Entrenador>());
        String showAll = dao.showAll();
        assertEquals("No hay entrenadores en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de entrenadores.
     */
    @Test
    public void testGetListaEntrenadoresAndSetListaEntrenadores() {
        ArrayList<Entrenador> lista = new ArrayList<>();
        lista.add(new Entrenador("entrenador8", "pass", "correo8@correo.com", "Colombia", "Cali"));
        dao.setListaEntrenadores(lista);
        assertEquals(1, dao.getListaEntrenadores().size());
        assertEquals("entrenador8", dao.getListaEntrenadores().get(0).getNombre());
        dao.setListaEntrenadores(new ArrayList<Entrenador>()); // Limpiar después del test
    }
}