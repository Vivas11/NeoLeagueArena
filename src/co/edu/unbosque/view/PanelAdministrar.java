package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel principal de administración de la aplicación NeoLeagueArena.
 * Permite acceder a la administración de usuarios, equipos, torneos y partidos.
 * Incluye botones para cada sección y un fondo personalizado.
 * 
 */
public class PanelAdministrar extends JPanel {

    /** Etiqueta que contiene la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    /** Botón para acceder a la administración de usuarios. */
    private JButton btnUsuario;
    /** Botón para acceder a la administración de equipos. */
    private JButton btnEquipo;
    /** Botón para acceder a la administración de torneos. */
    private JButton btnTorneo;
    /** Botón para acceder a la administración de partidos. */
    private JButton btnPartido;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;

    /**
     * Constructor del panel de administración.
     * Inicializa los botones y el fondo utilizando las propiedades proporcionadas.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrar(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);
        
        btnVolver = new JButton();
        btnVolver.setBounds(1070, 45, 150, 60);
        btnVolver.setFocusable(false);
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorder(null);
        add(btnVolver);
        
        btnUsuario = new JButton();
        btnUsuario.setBounds(715, 225, 150, 50);
        btnUsuario.setFocusable(false);
        btnUsuario.setOpaque(false);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.setBorder(null);
        add(btnUsuario);
        
        btnEquipo = new JButton();
        btnEquipo.setBounds(415, 225, 150, 50);
        btnEquipo.setFocusable(false);
        btnEquipo.setOpaque(false);
        btnEquipo.setBorderPainted(false);
        btnEquipo.setContentAreaFilled(false);
        btnEquipo.setBorder(null);
        add(btnEquipo);
        
        btnTorneo = new JButton();
        btnTorneo.setBounds(715, 615, 150, 50);
        btnTorneo.setFocusable(false);
        btnTorneo.setOpaque(false);
        btnTorneo.setBorderPainted(false);
        btnTorneo.setContentAreaFilled(false);
        btnTorneo.setBorder(null);
        add(btnTorneo);

        btnPartido = new JButton();
        btnPartido.setBounds(415, 615, 150, 50);
        btnPartido.setFocusable(false);
        btnPartido.setOpaque(false);
        btnPartido.setBorderPainted(false);
        btnPartido.setContentAreaFilled(false);
        btnPartido.setBorder(null);
        add(btnPartido);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrar")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * Recarga la imagen de fondo.
     * 
     * @throws IOException Si ocurre un error al cargar la imagen.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrar")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Obtiene la etiqueta de fondo del panel.
     * @return JLabel con la imagen de fondo.
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * Establece la etiqueta de fondo del panel.
     * @param fondo JLabel con la imagen de fondo.
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    /**
     * Obtiene el botón para volver a la pantalla anterior.
     * @return JButton de volver.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * @param btnVolver JButton de volver.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene el botón para administrar usuarios.
     * @return JButton de usuario.
     */
    public JButton getBtnUsuario() {
        return btnUsuario;
    }

    /**
     * Establece el botón para administrar usuarios.
     * @param btnUsuario JButton de usuario.
     */
    public void setBtnUsuario(JButton btnUsuario) {
        this.btnUsuario = btnUsuario;
    }

    /**
     * Obtiene el botón para administrar equipos.
     * @return JButton de equipo.
     */
    public JButton getBtnEquipo() {
        return btnEquipo;
    }

    /**
     * Establece el botón para administrar equipos.
     * @param btnEquipo JButton de equipo.
     */
    public void setBtnEquipo(JButton btnEquipo) {
        this.btnEquipo = btnEquipo;
    }

    /**
     * Obtiene el botón para administrar torneos.
     * @return JButton de torneo.
     */
    public JButton getBtnTorneo() {
        return btnTorneo;
    }

    /**
     * Establece el botón para administrar torneos.
     * @param btnTorneo JButton de torneo.
     */
    public void setBtnTorneo(JButton btnTorneo) {
        this.btnTorneo = btnTorneo;
    }

    /**
     * Obtiene el botón para administrar partidos.
     * @return JButton de partido.
     */
    public JButton getBtnPartido() {
        return btnPartido;
    }

    /**
     * Establece el botón para administrar partidos.
     * @param btnPartido JButton de partido.
     */
    public void setBtnPartido(JButton btnPartido) {
        this.btnPartido = btnPartido;
    }
    
    /**
     * Obtiene las propiedades de configuración.
     * @return Properties utilizadas por el panel.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades de configuración.
     * @param prop Properties a utilizar.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

}
