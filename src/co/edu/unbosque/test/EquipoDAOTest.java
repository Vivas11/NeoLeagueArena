package co.edu.unbosque.test;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link EquipoDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de equipos.
 */
public class EquipoDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private EquipoDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new EquipoDAO();
    }

    /**
     * Prueba agregar y buscar un equipo.
     */
    @Test
    public void testAddAndFindEquipo() {
        EquipoDTO dto = new EquipoDTO("equipo1", "Colombia", "img1.png");
        assertTrue(dao.add(dto));
        Equipo found = dao.find(new Equipo("equipo1", "Colombia", "img1.png"));
        assertNotNull(found);
        assertEquals("equipo1", found.getNombre());
        dao.delete(dto); // Eliminar equipo de prueba
    }

    /**
     * Prueba que no se puedan agregar equipos duplicados.
     */
    @Test
    public void testAddDuplicateEquipo() {
        EquipoDTO dto = new EquipoDTO("equipo2", "Colombia", "img2.png");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar equipo de prueba
    }

    /**
     * Prueba eliminar un equipo existente.
     */
    @Test
    public void testDeleteEquipo() {
        EquipoDTO dto = new EquipoDTO("equipo3", "Colombia", "img3.png");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new Equipo("equipo3", "Colombia", "img3.png")));
    }

    /**
     * Prueba eliminar un equipo que no existe.
     */
    @Test
    public void testDeleteNonExistentEquipo() {
        EquipoDTO dto = new EquipoDTO("equipo4", "Colombia", "img4.png");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un equipo existente.
     */
    @Test
    public void testUpdateEquipo() {
        EquipoDTO dtoOld = new EquipoDTO("equipo5", "Colombia", "img5.png");
        EquipoDTO dtoNew = new EquipoDTO("equipo5", "Colombia", "img5nuevo.png");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        Equipo found = dao.find(new Equipo("equipo5", "Colombia", "img5nuevo.png"));
        assertNotNull(found);
        assertEquals("img5nuevo.png", found.getImagen());
        dao.delete(dtoNew); // Eliminar equipo de prueba
    }

    /**
     * Prueba actualizar un equipo que no existe.
     */
    @Test
    public void testUpdateNonExistentEquipo() {
        EquipoDTO dtoOld = new EquipoDTO("equipo6", "Colombia", "img6.png");
        EquipoDTO dtoNew = new EquipoDTO("equipo6", "Colombia", "img6nuevo.png");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los equipos cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaEquipos(new ArrayList<Equipo>());
        String showAll = dao.showAll();
        assertEquals("No hay equipos en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de equipos.
     */
    @Test
    public void testGetListaEquiposAndSetListaEquipos() {
        ArrayList<Equipo> lista = new ArrayList<>();
        lista.add(new Equipo("equipo8", "Colombia", "img8.png"));
        dao.setListaEquipos(lista);
        assertEquals(1, dao.getListaEquipos().size());
        assertEquals("equipo8", dao.getListaEquipos().get(0).getNombre());
        dao.setListaEquipos(new ArrayList<Equipo>()); // Limpiar después del test
    }
}