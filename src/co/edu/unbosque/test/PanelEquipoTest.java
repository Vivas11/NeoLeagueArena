package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelEquipo;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelEquipo.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelEquipoTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelEquipo panel;

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
        prop.setProperty("archivospropiedad.fondo.equipos", "src/co/edu/unbosque/view/equipos.png");
        prop.setProperty("archivospropiedad.fondo.tarjetaequipo", "src/co/edu/unbosque/view/tarjetaequipo.png");
        panel = new PanelEquipo(prop);
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
        assertNotNull(panel.getBtnsIngresar());
        assertNotNull(panel.getBtnsSalir());
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
        panel.setBtnVolver(btnVolver);
        assertEquals(btnVolver, panel.getBtnVolver());

        JScrollPane scroll = new JScrollPane();
        panel.setScrollPane(scroll);
        assertEquals(scroll, panel.getScrollPane());

        JPanel contenido = new JPanel();
        panel.setPanelContenido(contenido);
        assertEquals(contenido, panel.getPanelContenido());

        java.util.ArrayList<JButton> btnsIngresar = new java.util.ArrayList<>();
        panel.setBtnsIngresar(btnsIngresar);
        assertEquals(btnsIngresar, panel.getBtnsIngresar());

        java.util.ArrayList<JButton> btnsSalir = new java.util.ArrayList<>();
        panel.setBtnsSalir(btnsSalir);
        assertEquals(btnsSalir, panel.getBtnsSalir());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}