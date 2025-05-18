package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelAdministrarU;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelAdministrarU.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelAdministrarUTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelAdministrarU panel;

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
        prop.setProperty("archivospropiedad.fondo.administraru", "src/co/edu/unbosque/view/administrarusuarios.png");
        panel = new PanelAdministrarU(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getBtnJugadores());
        assertNotNull(panel.getBtnEntrenadores());
        assertNotNull(panel.getBtnAdministradores());
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

        JButton btnJugadores = new JButton();
        panel.setBtnJugadores(btnJugadores);
        assertEquals(btnJugadores, panel.getBtnJugadores());

        JButton btnEntrenadores = new JButton();
        panel.setBtnEntrenadores(btnEntrenadores);
        assertEquals(btnEntrenadores, panel.getBtnEntrenadores());

        JButton btnAdministradores = new JButton();
        panel.setBtnAdministradores(btnAdministradores);
        assertEquals(btnAdministradores, panel.getBtnAdministradores());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}