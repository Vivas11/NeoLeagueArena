package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelIniciarSesion;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelIniciarSesion.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelIniciarSesionTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelIniciarSesion panel;

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
        prop.setProperty("archivospropiedad.fondo.iniciarsesion", "src/co/edu/unbosque/view/sesion.png");
        panel = new PanelIniciarSesion(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getBtnIngresar());
        assertNotNull(panel.getNombreUsuario());
        assertNotNull(panel.getContrasenaF());
        assertNotNull(panel.getMostrarContrasena());
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

        JButton btnIngresar = new JButton();
        panel.setBtnIngresar(btnIngresar);
        assertEquals(btnIngresar, panel.getBtnIngresar());

        JTextField nombreUsuario = new JTextField();
        panel.setNombreUsuario(nombreUsuario);
        assertEquals(nombreUsuario, panel.getNombreUsuario());

        JCheckBox mostrarContrasena = new JCheckBox();
        panel.setMostrarContrasena(mostrarContrasena);
        assertEquals(mostrarContrasena, panel.getMostrarContrasena());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}