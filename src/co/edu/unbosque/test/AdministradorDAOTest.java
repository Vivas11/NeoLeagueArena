package co.edu.unbosque.test;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.persistence.AdministradorDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link AdministradorDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de administradores.
 */
public class AdministradorDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private AdministradorDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new AdministradorDAO();
    }

    /**
     * Prueba agregar y buscar un administrador.
     */
    @Test
    public void testAddAndFindAdministrador() {
        AdministradorDTO dto = new AdministradorDTO("admin1", "pass", "correo@correo.com");
        assertTrue(dao.add(dto));
        Administrador found = dao.find(new Administrador("admin1", "pass", "correo@correo.com"));
        assertNotNull(found);
        assertEquals("admin1", found.getNombre());
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba que no se puedan agregar administradores duplicados.
     */
    @Test
    public void testAddDuplicateAdministrador() {
        AdministradorDTO dto = new AdministradorDTO("admin2", "pass", "correo2@correo.com");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba eliminar un administrador existente.
     */
    @Test
    public void testDeleteAdministrador() {
        AdministradorDTO dto = new AdministradorDTO("admin3", "pass", "correo3@correo.com");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new Administrador("admin3", "pass", "correo3@correo.com")));
    }

    /**
     * Prueba eliminar un administrador que no existe.
     */
    @Test
    public void testDeleteNonExistentAdministrador() {
        AdministradorDTO dto = new AdministradorDTO("admin4", "pass", "correo4@correo.com");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un administrador existente.
     */
    @Test
    public void testUpdateAdministrador() {
        AdministradorDTO dtoOld = new AdministradorDTO("admin5", "pass", "correo5@correo.com");
        AdministradorDTO dtoNew = new AdministradorDTO("admin5", "newpass", "correo5@correo.com");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        Administrador found = dao.find(new Administrador("admin5", "newpass", "correo5@correo.com"));
        assertNotNull(found);
        assertEquals("newpass", found.getContrasena());
        dao.delete(dtoNew); // Eliminar usuario de prueba
    }

    /**
     * Prueba actualizar un administrador que no existe.
     */
    @Test
    public void testUpdateNonExistentAdministrador() {
        AdministradorDTO dtoOld = new AdministradorDTO("admin6", "pass", "correo6@correo.com");
        AdministradorDTO dtoNew = new AdministradorDTO("admin6", "newpass", "correo6@correo.com");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los administradores cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaAdministrador(new ArrayList<Administrador>());
        String showAll = dao.showAll();
        assertEquals("No hay mascotas en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de administradores.
     */
    @Test
    public void testGetListaAdministradorAndSetListaAdministrador() {
        ArrayList<Administrador> lista = new ArrayList<>();
        lista.add(new Administrador("admin8", "pass", "correo8@correo.com"));
        dao.setListaAdministrador(lista);
        assertEquals(1, dao.getListaAdministrador().size());
        assertEquals("admin8", dao.getListaAdministrador().get(0).getNombre());
        dao.setListaAdministrador(new ArrayList<Administrador>()); // Limpiar después del test
    }
}