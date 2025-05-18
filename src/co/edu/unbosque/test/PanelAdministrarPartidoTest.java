package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelAdministrarPartido;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelAdministrarPartido.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelAdministrarPartidoTest {
    /**
     * Instancia del panel a probar.
     */
    private PanelAdministrarPartido panel;
     /**
     * Properties para simular la configuración de fondos.
     */
    private Properties prop;

    /**
     * Inicializa el panel y los properties antes de cada prueba.
     */
    @Before
    public void setUp() throws IOException {
        prop = new Properties();
        prop.setProperty("archivospropiedad.fondo.administrarpartidos", "src/co/edu/unbosque/view/administrarpartidos.png");
        prop.setProperty("archivospropiedad.fondo.tarjetapartidaadmin", "src/co/edu/unbosque/view/tarjetapartidaadmin.png");
        panel = new PanelAdministrarPartido(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getScrollPane());
        assertNotNull(panel.getPanelContenido());
        assertNotNull(panel.getBtnsEliminar());
        assertNotNull(panel.getBtnsActualizar());
        assertNotNull(panel.getProp());
    }

    /**
     * Verifica los métodos setters y getters de los componentes.
     */
    @Test
    public void testSettersAndGetters() {
        JLabel fondo = new JLabel();
        panel.setFondo(fondo);
        assertEquals(fondo, panel.getFondo());

        JButton btnVolver = new JButton();
        panel.setBtnVolver(btnVolver);
        assertEquals(btnVolver, panel.getBtnVolver());

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