package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelHistorial;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelHistorial.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelHistorialTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelHistorial panel;

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
        prop.setProperty("archivospropiedad.fondo.historialpartidos", "src/co/edu/unbosque/view/historial.png");
        prop.setProperty("archivospropiedad.fondo.tarjetapartida", "src/co/edu/unbosque/view/tarjetapartida.png");
        panel = new PanelHistorial(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolverHistorial());
        assertNotNull(panel.getScrollPane());
        assertNotNull(panel.getPanelContenido());
        assertNotNull(panel.getBtnsConfirmar());
        assertNotNull(panel.getSpinnersA());
        assertNotNull(panel.getSpinnersB());
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
        panel.setBtnVolverHistorial(btnVolver);
        assertEquals(btnVolver, panel.getBtnVolverHistorial());

        JScrollPane scroll = new JScrollPane();
        panel.setScrollPane(scroll);
        assertEquals(scroll, panel.getScrollPane());

        JPanel contenido = new JPanel();
        panel.setPanelContenido(contenido);
        assertEquals(contenido, panel.getPanelContenido());

        java.util.ArrayList<JButton> btnsConfirmar = new java.util.ArrayList<>();
        panel.setBtnsConfirmar(btnsConfirmar);
        assertEquals(btnsConfirmar, panel.getBtnsConfirmar());

        java.util.ArrayList<JSpinner> spinnersA = new java.util.ArrayList<>();
        panel.setSpinnersA(spinnersA);
        assertEquals(spinnersA, panel.getSpinnersA());

        java.util.ArrayList<JSpinner> spinnersB = new java.util.ArrayList<>();
        panel.setSpinnersB(spinnersB);
        assertEquals(spinnersB, panel.getSpinnersB());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}