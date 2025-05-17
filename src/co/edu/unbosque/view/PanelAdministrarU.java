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
 * Panel para la administración de usuarios en la aplicación NeoLeagueArena.
 * Permite acceder a la gestión de jugadores, entrenadores y administradores.
 * Incluye botones para cada tipo de usuario y un fondo personalizado.
 * 
 */
public class PanelAdministrarU extends JPanel{
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    /** Botón para acceder a la administración de jugadores. */
    private JButton btnJugadores;
    /** Botón para acceder a la administración de entrenadores. */
    private JButton btnEntrenadores;
    /** Botón para acceder a la administración de administradores. */
    private JButton btnAdministradores;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;

    /**
     * Constructor del panel de administración de usuarios.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrarU(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administraru")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        btnVolver = new JButton();
        btnVolver.setBounds(1070, 45, 150, 60);
        btnVolver.setFocusable(false);
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorder(null);
        add(btnVolver);

        btnJugadores = new JButton();
        btnJugadores.setBounds(190, 480, 150, 60);
        btnJugadores.setFocusable(false);
        btnJugadores.setOpaque(false);
        btnJugadores.setBorderPainted(false);
        btnJugadores.setContentAreaFilled(false);
        btnJugadores.setBorder(null);
        add(btnJugadores);

        btnEntrenadores = new JButton();
        btnEntrenadores.setBounds(540, 480, 150, 60);
        btnEntrenadores.setFocusable(false);
        btnEntrenadores.setOpaque(false);
        btnEntrenadores.setBorderPainted(false);
        btnEntrenadores.setContentAreaFilled(false);
        btnEntrenadores.setBorder(null);
        add(btnEntrenadores);

        btnAdministradores = new JButton();
        btnAdministradores.setBounds(900, 480, 170, 60);
        btnAdministradores.setFocusable(false);
        btnAdministradores.setOpaque(false);
        btnAdministradores.setBorderPainted(false);
        btnAdministradores.setContentAreaFilled(false);
        btnAdministradores.setBorder(null);
        add(btnAdministradores);

        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * Recarga la imagen de fondo.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administraru")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Obtiene la etiqueta de fondo del panel.
     * @return JLabel de fondo.
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * Establece la etiqueta de fondo del panel.
     * @param fondo JLabel a establecer.
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
     * @param btnVolver JButton a establecer.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene el botón para acceder a la administración de jugadores.
     * @return JButton de jugadores.
     */
    public JButton getBtnJugadores() {
        return btnJugadores;
    }

    /**
     * Establece el botón para acceder a la administración de jugadores.
     * @param btnJugadores JButton a establecer.
     */
    public void setBtnJugadores(JButton btnJugadores) {
        this.btnJugadores = btnJugadores;
    }

    /**
     * Obtiene el botón para acceder a la administración de entrenadores.
     * @return JButton de entrenadores.
     */
    public JButton getBtnEntrenadores() {
        return btnEntrenadores;
    }

    /**
     * Establece el botón para acceder a la administración de entrenadores.
     * @param btnEntrenadores JButton a establecer.
     */
    public void setBtnEntrenadores(JButton btnEntrenadores) {
        this.btnEntrenadores = btnEntrenadores;
    }

    /**
     * Obtiene el botón para acceder a la administración de administradores.
     * @return JButton de administradores.
     */
    public JButton getBtnAdministradores() {
        return btnAdministradores;
    }

    /**
     * Establece el botón para acceder a la administración de administradores.
     * @param btnAdministradores JButton a establecer.
     */
    public void setBtnAdministradores(JButton btnAdministradores) {
        this.btnAdministradores = btnAdministradores;
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
     * @param prop Properties a establecer.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
