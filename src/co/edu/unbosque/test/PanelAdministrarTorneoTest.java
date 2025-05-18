package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelAdministrarTorneo;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelAdministrarTorneo.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelAdministrarTorneoTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelAdministrarTorneo panel;

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
        prop.setProperty("archivospropiedad.fondo.administrartorneos", "src/co/edu/unbosque/view/administrartorneos.png");
        prop.setProperty("archivospropiedad.fondo.tarjetatorneoadmin", "src/co/edu/unbosque/view/tarjetatorneoadmin.png");
        panel = new PanelAdministrarTorneo(prop);
    }

    /**
     * Verifica que los componentes principales no sean nulos.
     */
    @Test
    public void testComponentesNoNulos() {
        assertNotNull(panel.getFondo());
        assertNotNull(panel.getBtnVolver());
        assertNotNull(panel.getBtnCrear());
        assertNotNull(panel.getScrollPane());
        assertNotNull(panel.getPanelContenido());
        assertNotNull(panel.getBtnsEliminar());
        assertNotNull(panel.getNombreTorneo());
        assertNotNull(panel.getNombreJuego());
        assertNotNull(panel.getCbxTipoTorneo());
        assertNotNull(panel.getNumeroEquipo());
        assertNotNull(panel.getProp());
    }
}