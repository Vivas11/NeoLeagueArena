package co.edu.unbosque.test;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link JugadorDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de jugadores.
 */
public class JugadorDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private JugadorDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new JugadorDAO();
    }

    /**
     * Prueba agregar y buscar un jugador.
     */
    @Test
    public void testAddAndFindJugador() {
        JugadorDTO dto = new JugadorDTO("jugador1", "pass", "correo@correo.com");
        assertTrue(dao.add(dto));
        Jugador found = dao.find(new Jugador("jugador1", "pass", "correo@correo.com"));
        assertNotNull(found);
        assertEquals("jugador1", found.getNombre());
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba que no se puedan agregar jugadores duplicados.
     */
    @Test
    public void testAddDuplicateJugador() {
        JugadorDTO dto = new JugadorDTO("jugador2", "pass", "correo2@correo.com");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar usuario de prueba
    }

    /**
     * Prueba eliminar un jugador existente.
     */
    @Test
    public void testDeleteJugador() {
        JugadorDTO dto = new JugadorDTO("jugador3", "pass", "correo3@correo.com");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new Jugador("jugador3", "pass", "correo3@correo.com")));
    }

    /**
     * Prueba eliminar un jugador que no existe.
     */
    @Test
    public void testDeleteNonExistentJugador() {
        JugadorDTO dto = new JugadorDTO("jugador4", "pass", "correo4@correo.com");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un jugador existente.
     */
    @Test
    public void testUpdateJugador() {
        JugadorDTO dtoOld = new JugadorDTO("jugador5", "pass", "correo5@correo.com");
        JugadorDTO dtoNew = new JugadorDTO("jugador5", "newpass", "correo5@correo.com");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        Jugador found = dao.find(new Jugador("jugador5", "newpass", "correo5@correo.com"));
        assertNotNull(found);
        assertEquals("newpass", found.getContrasena());
        dao.delete(dtoNew); // Eliminar usuario de prueba
    }

    /**
     * Prueba actualizar un jugador que no existe.
     */
    @Test
    public void testUpdateNonExistentJugador() {
        JugadorDTO dtoOld = new JugadorDTO("jugador6", "pass", "correo6@correo.com");
        JugadorDTO dtoNew = new JugadorDTO("jugador6", "newpass", "correo6@correo.com");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los jugadores cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaJugadores(new ArrayList<Jugador>());
        String showAll = dao.showAll();
        assertEquals("No hay jugadores en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de jugadores.
     */
    @Test
    public void testGetListaJugadoresAndSetListaJugadores() {
        ArrayList<Jugador> lista = new ArrayList<>();
        lista.add(new Jugador("jugador8", "pass", "correo8@correo.com"));
        dao.setListaJugadores(lista);
        assertEquals(1, dao.getListaJugadores().size());
        assertEquals("jugador8", dao.getListaJugadores().get(0).getNombre());
        dao.setListaJugadores(new ArrayList<Jugador>()); // Limpiar después del test
    }
}