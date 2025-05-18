package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelRegistro;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelRegistro.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelRegistroTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelRegistro panel;

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
        prop.setProperty("archivospropiedad.fondo.registro", "src/co/edu/unbosque/view/registro.png");
        panel = new PanelRegistro(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getBtnRegistrar());
        assertNotNull(panel.getNombreUsuario());
        assertNotNull(panel.getTxtCiudad());
        assertNotNull(panel.getTxtPais());
        assertNotNull(panel.getTxtCorreo());
        assertNotNull(panel.getCbxTipoUsuario());
        assertNotNull(panel.getContrasena1F());
        assertNotNull(panel.getContrasena2F());
        assertNotNull(panel.getMostrarContrasena());
        assertNotNull(panel.getMostrarContrasena2());
        assertNotNull(panel.getProp());
    }
}