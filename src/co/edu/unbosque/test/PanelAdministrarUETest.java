package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelAdministrarUE;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelAdministrarUE.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelAdministrarUETest {

    /**
     * Instancia del panel a probar.
     */
    private PanelAdministrarUE panel;

    /**
     * Properties para simular la configuración de fondos.
     */
    private Properties prop;

    /**
     * Inicializa el panel y los properties antes de cada prueba.
     * @throws IOException si ocurre un error al cargar propiedades.
     */
    @Before
    public void setUp() throws IOException {
        prop = new Properties();
        prop.setProperty("archivospropiedad.fondo.administrarue", "src/co/edu/unbosque/view/administrarusuariosespecificos.png");
        prop.setProperty("archivospropiedad.fondo.tarjetaadmin", "src/co/edu/unbosque/view/tarjetaadmin.png");
        panel = new PanelAdministrarUE(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolverJugador());
        assertNotNull(panel.getScrollPane());
        assertNotNull(panel.getPanelContenido());
        assertNotNull(panel.getBtnsEliminar());
        assertNotNull(panel.getBtnsActualizar());
        assertNotNull(panel.getProp());
    }

    /**
     * Verifica los métodos setters y getters de los componentes del panel.
     */
    @Test
    public void testSettersAndGetters() {
        JLabel fondo = new JLabel();
        panel.setFondo(fondo);
        assertEquals(fondo, panel.getFondo());

        JButton btnVolver = new JButton();
        panel.setBtnVolverJugador(btnVolver);
        assertEquals(btnVolver, panel.getBtnVolverJugador());

        JScrollPane scroll = new JScrollPane();
        panel.setScrollPane(scroll);
        assertEquals(scroll, panel.getScrollPane());

        JPanel contenido = new JPanel();
        panel.setPanelContenido(contenido);
        assertEquals(contenido, panel.getPanelContenido());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());

        java.util.ArrayList<JButton> eliminar = new java.util.ArrayList<>();
        panel.setBtnsEliminar(eliminar);
        assertEquals(eliminar, panel.getBtnsEliminar());

        java.util.ArrayList<JButton> actualizar = new java.util.ArrayList<>();
        panel.setBtnsActualizar(actualizar);
        assertEquals(actualizar, panel.getBtnsActualizar());
    }
}