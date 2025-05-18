package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelPrincipal;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelPrincipal.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelPrincipalTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelPrincipal panel;

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
        prop.setProperty("archivospropiedad.fondo.menu", "src/co/edu/unbosque/view/menu.png");
        panel = new PanelPrincipal(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVerT());
        assertNotNull(panel.getBtnIniciarS());
        assertNotNull(panel.getBtnVerE());
        assertNotNull(panel.getBtnHistoriaP());
        assertNotNull(panel.getBtnJugadoresD());
        assertNotNull(panel.getBtnInformes());
        assertNotNull(panel.getBtnRegistrarse());
        assertNotNull(panel.getBtnAdministrar());
        assertNotNull(panel.getBtnCerrarSesion());
        assertNotNull(panel.getBtnCambioIdioma());
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

        JButton btnVerT = new JButton();
        panel.setBtnVerT(btnVerT);
        assertEquals(btnVerT, panel.getBtnVerT());

        JButton btnIniciarS = new JButton();
        panel.setBtnIniciarS(btnIniciarS);
        assertEquals(btnIniciarS, panel.getBtnIniciarS());

        JButton btnVerE = new JButton();
        panel.setBtnVerE(btnVerE);
        assertEquals(btnVerE, panel.getBtnVerE());

        JButton btnHistoriaP = new JButton();
        panel.setBtnHistoriaP(btnHistoriaP);
        assertEquals(btnHistoriaP, panel.getBtnHistoriaP());

        JButton btnJugadoresD = new JButton();
        panel.setBtnJugadoresD(btnJugadoresD);
        assertEquals(btnJugadoresD, panel.getBtnJugadoresD());

        JButton btnInformes = new JButton();
        panel.setBtnInformes(btnInformes);
        assertEquals(btnInformes, panel.getBtnInformes());

        JButton btnRegistrarse = new JButton();
        panel.setBtnRegistrarse(btnRegistrarse);
        assertEquals(btnRegistrarse, panel.getBtnRegistrarse());

        JButton btnAdministrar = new JButton();
        panel.setBtnAdministrar(btnAdministrar);
        assertEquals(btnAdministrar, panel.getBtnAdministrar());

        JButton btnCerrarSesion = new JButton();
        panel.setBtnCerrarSesion(btnCerrarSesion);
        assertEquals(btnCerrarSesion, panel.getBtnCerrarSesion());

        JButton btnCambioIdioma = new JButton();
        panel.setBtnCambioIdioma(btnCambioIdioma);
        assertEquals(btnCambioIdioma, panel.getBtnCambioIdioma());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}