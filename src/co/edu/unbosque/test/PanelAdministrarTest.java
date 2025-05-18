package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelAdministrar;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelAdministrar.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelAdministrarTest {
    /**
     * Instancia del panel a probar.
     */
    private PanelAdministrar panel;
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
        prop.setProperty("archivospropiedad.fondo.administrar", "src/co/edu/unbosque/view/administrar.png");
        panel = new PanelAdministrar(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getBtnUsuario());
        assertNotNull(panel.getBtnEquipo());
        assertNotNull(panel.getBtnTorneo());
        assertNotNull(panel.getBtnPartido());
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

        JButton btnUsuario = new JButton();
        panel.setBtnUsuario(btnUsuario);
        assertEquals(btnUsuario, panel.getBtnUsuario());

        JButton btnEquipo = new JButton();
        panel.setBtnEquipo(btnEquipo);
        assertEquals(btnEquipo, panel.getBtnEquipo());

        JButton btnTorneo = new JButton();
        panel.setBtnTorneo(btnTorneo);
        assertEquals(btnTorneo, panel.getBtnTorneo());

        JButton btnPartido = new JButton();
        panel.setBtnPartido(btnPartido);
        assertEquals(btnPartido, panel.getBtnPartido());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}