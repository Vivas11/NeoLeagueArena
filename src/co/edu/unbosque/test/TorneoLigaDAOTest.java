package co.edu.unbosque.test;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.TorneoLigaDTO;
import co.edu.unbosque.model.persistence.TorneoLigaDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link TorneoLigaDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de torneos de liga.
 */
public class TorneoLigaDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private TorneoLigaDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new TorneoLigaDAO();
    }

    /**
     * Prueba agregar y buscar un torneo de liga.
     */
    @Test
    public void testAddAndFindTorneoLiga() {
        TorneoLigaDTO dto = new TorneoLigaDTO("Liga1", "LOL");
        assertTrue(dao.add(dto));
        TorneoLiga found = dao.find(new TorneoLiga("Liga1", "LOL"));
        assertNotNull(found);
        assertEquals("Liga1", found.getNombre());
        dao.delete(dto); // Eliminar torneo de prueba
    }

    /**
     * Prueba que no se puedan agregar torneos de liga duplicados.
     */
    @Test
    public void testAddDuplicateTorneoLiga() {
        TorneoLigaDTO dto = new TorneoLigaDTO("Liga2", "LOL");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar torneo de prueba
    }

    /**
     * Prueba eliminar un torneo de liga existente.
     */
    @Test
    public void testDeleteTorneoLiga() {
        TorneoLigaDTO dto = new TorneoLigaDTO("Liga3", "LOL");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new TorneoLiga("Liga3", "LOL")));
    }

    /**
     * Prueba eliminar un torneo de liga que no existe.
     */
    @Test
    public void testDeleteNonExistentTorneoLiga() {
        TorneoLigaDTO dto = new TorneoLigaDTO("Liga4", "LOL");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un torneo de liga existente.
     */
    @Test
    public void testUpdateTorneoLiga() {
        TorneoLigaDTO dtoOld = new TorneoLigaDTO("Liga5", "LOL");
        TorneoLigaDTO dtoNew = new TorneoLigaDTO("Liga5", "Valorant");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        TorneoLiga found = dao.find(new TorneoLiga("Liga5", "Valorant"));
        assertNotNull(found);
        assertEquals("Valorant", found.getJuego());
        dao.delete(dtoNew); // Eliminar torneo de prueba
    }

    /**
     * Prueba actualizar un torneo de liga que no existe.
     */
    @Test
    public void testUpdateNonExistentTorneoLiga() {
        TorneoLigaDTO dtoOld = new TorneoLigaDTO("Liga6", "LOL");
        TorneoLigaDTO dtoNew = new TorneoLigaDTO("Liga6", "Valorant");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los torneos de liga cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaTorneos(new ArrayList<TorneoLiga>());
        String showAll = dao.showAll();
        assertEquals("No hay torneos de liga en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de torneos de liga.
     */
    @Test
    public void testGetListaTorneosAndSetListaTorneos() {
        ArrayList<TorneoLiga> lista = new ArrayList<>();
        lista.add(new TorneoLiga("Liga8", "LOL"));
        dao.setListaTorneos(lista);
        assertEquals(1, dao.getListaTorneos().size());
        assertEquals("Liga8", dao.getListaTorneos().get(0).getNombre());
        dao.setListaTorneos(new ArrayList<TorneoLiga>()); // Limpiar después del test
    }
}