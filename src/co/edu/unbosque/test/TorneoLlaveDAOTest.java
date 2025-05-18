package co.edu.unbosque.test;

import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;
import co.edu.unbosque.model.persistence.TorneoLlaveDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase {@link TorneoLlaveDAO}.
 * Verifica las operaciones CRUD y el manejo de la lista de torneos de llave.
 */
public class TorneoLlaveDAOTest {
    /**
     * Instancia del DAO a probar.
     */
    private TorneoLlaveDAO dao;

    /**
     * Inicializa el DAO antes de cada prueba.
     */
    @Before
    public void setUp() {
        dao = new TorneoLlaveDAO();
    }

    /**
     * Prueba agregar y buscar un torneo de llave.
     */
    @Test
    public void testAddAndFindTorneoLlave() {
        TorneoLlaveDTO dto = new TorneoLlaveDTO("Llave1", "LOL");
        assertTrue(dao.add(dto));
        TorneoLlave found = dao.find(new TorneoLlave("Llave1", "LOL"));
        assertNotNull(found);
        assertEquals("Llave1", found.getNombre());
        dao.delete(dto); // Eliminar torneo de prueba
    }

    /**
     * Prueba que no se puedan agregar torneos de llave duplicados.
     */
    @Test
    public void testAddDuplicateTorneoLlave() {
        TorneoLlaveDTO dto = new TorneoLlaveDTO("Llave2", "LOL");
        assertTrue(dao.add(dto));
        assertFalse(dao.add(dto));
        dao.delete(dto); // Eliminar torneo de prueba
    }

    /**
     * Prueba eliminar un torneo de llave existente.
     */
    @Test
    public void testDeleteTorneoLlave() {
        TorneoLlaveDTO dto = new TorneoLlaveDTO("Llave3", "LOL");
        dao.add(dto);
        assertTrue(dao.delete(dto));
        assertNull(dao.find(new TorneoLlave("Llave3", "LOL")));
    }

    /**
     * Prueba eliminar un torneo de llave que no existe.
     */
    @Test
    public void testDeleteNonExistentTorneoLlave() {
        TorneoLlaveDTO dto = new TorneoLlaveDTO("Llave4", "LOL");
        assertFalse(dao.delete(dto));
    }

    /**
     * Prueba actualizar un torneo de llave existente.
     */
    @Test
    public void testUpdateTorneoLlave() {
        TorneoLlaveDTO dtoOld = new TorneoLlaveDTO("Llave5", "LOL");
        TorneoLlaveDTO dtoNew = new TorneoLlaveDTO("Llave5", "Valorant");
        dao.add(dtoOld);
        assertTrue(dao.update(dtoOld, dtoNew));
        TorneoLlave found = dao.find(new TorneoLlave("Llave5", "Valorant"));
        assertNotNull(found);
        assertEquals("Valorant", found.getJuego());
        dao.delete(dtoNew); // Eliminar torneo de prueba
    }

    /**
     * Prueba actualizar un torneo de llave que no existe.
     */
    @Test
    public void testUpdateNonExistentTorneoLlave() {
        TorneoLlaveDTO dtoOld = new TorneoLlaveDTO("Llave6", "LOL");
        TorneoLlaveDTO dtoNew = new TorneoLlaveDTO("Llave6", "Valorant");
        assertFalse(dao.update(dtoOld, dtoNew));
    }

    /**
     * Prueba mostrar todos los torneos de llave cuando la lista está vacía.
     */
    @Test
    public void testShowAllEmpty() {
        dao.setListaTorneos(new ArrayList<TorneoLlave>());
        String showAll = dao.showAll();
        assertEquals("No hay torneos de llave en la lista", showAll);
    }

    /**
     * Prueba los métodos getter y setter de la lista de torneos de llave.
     */
    @Test
    public void testGetListaTorneosAndSetListaTorneos() {
        ArrayList<TorneoLlave> lista = new ArrayList<>();
        lista.add(new TorneoLlave("Llave8", "LOL"));
        dao.setListaTorneos(lista);
        assertEquals(1, dao.getListaTorneos().size());
        assertEquals("Llave8", dao.getListaTorneos().get(0).getNombre());
        dao.setListaTorneos(new ArrayList<TorneoLlave>()); // Limpiar después del test
    }
}