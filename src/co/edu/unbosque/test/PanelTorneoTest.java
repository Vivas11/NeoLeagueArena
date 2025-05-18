package co.edu.unbosque.test;

import co.edu.unbosque.view.PanelTorneo;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase PanelTorneo.
 * Usa los mismos properties que el panel base para los fondos.
 */
public class PanelTorneoTest {

    /**
     * Instancia del panel a probar.
     */
    private PanelTorneo panel;

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
        prop.setProperty("archivospropiedad.fondo.torneos", "src/co/edu/unbosque/view/torneos.png");
        prop.setProperty("archivospropiedad.fondo.tarjetatorneo", "src/co/edu/unbosque/view/tarjetatorneo.png");
        panel = new PanelTorneo(prop);
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
        assertNotNull(panel.getBtnsVerTabla());
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

        java.util.ArrayList<JButton> btnsVerTabla = new java.util.ArrayList<>();
        panel.setBtnsVerTabla(btnsVerTabla);
        assertEquals(btnsVerTabla, panel.getBtnsVerTabla());

        Properties newProp = new Properties();
        panel.setProp(newProp);
        assertEquals(newProp, panel.getProp());
    }
}