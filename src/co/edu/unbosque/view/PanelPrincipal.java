package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel principal de la aplicación NeoLeagueArena.
 * Permite acceder a las diferentes secciones como torneos, equipos, historial, informes, administración, etc.
 * Incluye botones para cada sección y un fondo personalizado.
 */
public class PanelPrincipal extends JPanel {

    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para ver torneos. */
    private JButton btnVerT;
    /** Botón para iniciar sesión. */
    private JButton btnIniciarS;
    /** Botón para ver equipos. */
    private JButton btnVerE;
    /** Botón para ver el historial de partidas. */
    private JButton btnHistoriaP;
    /** Botón para ver jugadores destacados. */
    private JButton btnJugadoresD;
    /** Botón para acceder a los informes. */
    private JButton btnInformes;
    /** Botón para registrarse. */
    private JButton btnRegistrarse;
    /** Botón para acceder a la administración. */
    private JButton btnAdministrar;
    /** Botón para cerrar sesión. */
    private JButton btnCerrarSesion;
    /** Botón para cambiar el idioma de la aplicación. */
    private JButton btnCambioIdioma;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;

    /**
     * Constructor del panel principal.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelPrincipal(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.menu")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        btnIniciarS = new JButton();
        btnIniciarS.setBounds(1020, 45, 125, 60);
        btnIniciarS.setFocusable(false);
        btnIniciarS.setOpaque(false);
        btnIniciarS.setContentAreaFilled(false);
        btnIniciarS.setBorderPainted(false);
        btnIniciarS.setBorder(null);
        add(btnIniciarS);

        btnVerE = new JButton();
        btnVerE.setBounds(40, 45, 170, 50);
        btnVerE.setFocusable(false);
        btnVerE.setOpaque(false);
        btnVerE.setContentAreaFilled(false);
        btnVerE.setBorderPainted(false);
        btnVerE.setBorder(null);
        add(btnVerE);

        btnVerT = new JButton();
        btnVerT.setBounds(550, 590, 180, 60);
        btnVerT.setFocusable(false);
        btnVerT.setContentAreaFilled(false);
        btnVerT.setOpaque(false);
        btnVerT.setBorderPainted(false);
        btnVerT.setBorder(null);
        add(btnVerT);

        btnHistoriaP = new JButton();
        btnHistoriaP.setBounds(250, 45, 170, 60);
        btnHistoriaP.setFocusable(false);
        btnHistoriaP.setContentAreaFilled(false);
        btnHistoriaP.setOpaque(false);
        btnHistoriaP.setBorderPainted(false);
        btnHistoriaP.setBorder(null);
        add(btnHistoriaP);

        btnJugadoresD = new JButton();
        btnJugadoresD.setBounds(450, 45, 110, 60);
        btnJugadoresD.setFocusable(false);
        btnJugadoresD.setContentAreaFilled(false);
        btnJugadoresD.setOpaque(false);
        btnJugadoresD.setBorderPainted(false);
        btnJugadoresD.setBorder(null);
        add(btnJugadoresD);

        btnInformes = new JButton();
        btnInformes.setBounds(650, 45, 100, 60);
        btnInformes.setFocusable(false);
        btnInformes.setContentAreaFilled(false);
        btnInformes.setOpaque(false);
        btnInformes.setBorderPainted(false);
        btnInformes.setBorder(null);
        add(btnInformes);

        btnRegistrarse = new JButton();
        btnRegistrarse.setBounds(1150, 45, 120, 60);
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setForeground(Color.black);
        btnRegistrarse.setBackground(new Color(0, 0, 0, 0));
        btnRegistrarse.setOpaque(false);
        btnRegistrarse.setBorderPainted(false);
        btnRegistrarse.setContentAreaFilled(false);
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setFont(new Font("Baloo", Font.BOLD, 26));
        add(btnRegistrarse);

        btnAdministrar = new JButton();
        btnAdministrar.setBounds(1165, 575, 100, 100);
        btnAdministrar.setFocusable(false);
        btnAdministrar.setForeground(Color.black);
        btnAdministrar.setBackground(new Color(0, 0, 0, 0));
        btnAdministrar.setOpaque(false);
        btnAdministrar.setBorderPainted(false);
        btnAdministrar.setContentAreaFilled(false);
        btnAdministrar.setBorder(null);
        add(btnAdministrar);

        btnCerrarSesion = new JButton();
        btnCerrarSesion.setBounds(1065, 600, 75, 75);
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.setForeground(Color.black);
        btnCerrarSesion.setBackground(new Color(0, 0, 0, 0));
        btnCerrarSesion.setOpaque(false);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setBorder(null);
        add(btnCerrarSesion);
        
        btnCambioIdioma = new JButton();
        btnCambioIdioma.setBounds(967, 615, 60, 60);
        btnCambioIdioma.setFocusable(false);
        btnCambioIdioma.setOpaque(false);
        btnCambioIdioma.setBorderPainted(false);
        btnCambioIdioma.setContentAreaFilled(false);
        btnCambioIdioma.setBorder(null);
        add(btnCambioIdioma);
        
        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.menu")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Obtiene el botón para cerrar sesión.
     * @return JButton de cerrar sesión.
     */
    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    /**
     * Establece el botón para cerrar sesión.
     * @param btnCerrarSesion JButton a establecer.
     */
    public void setBtnCerrarSesion(JButton btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }

    /**
     * Obtiene la etiqueta de fondo del panel.
     * @return JLabel de fondo.
     */
    public JLabel getImagen1() {
        return fondo;
    }

    /**
     * Establece la etiqueta de fondo del panel.
     * @param fondo JLabel a establecer.
     */
    public void setImagen1(JLabel fondo) {
        this.fondo = fondo;
    }

    /**
     * Obtiene el botón para ver torneos.
     * @return JButton de ver torneos.
     */
    public JButton getBtnVerT() {
        return btnVerT;
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

    /**
     * Establece el botón para ver torneos.
     * @param btnVerT JButton a establecer.
     */
    public void setBtnVerT(JButton btnVerT) {
        this.btnVerT = btnVerT;
    }

    /**
     * Obtiene el botón para iniciar sesión.
     * @return JButton de iniciar sesión.
     */
    public JButton getBtnIniciarS() {
        return btnIniciarS;
    }

    /**
     * Establece el botón para iniciar sesión.
     * @param btnIniciarS JButton a establecer.
     */
    public void setBtnIniciarS(JButton btnIniciarS) {
        this.btnIniciarS = btnIniciarS;
    }

    /**
     * Obtiene el botón para acceder a la administración.
     * @return JButton de administración.
     */
    public JButton getBtnAdministrar() {
        return btnAdministrar;
    }

    /**
     * Establece el botón para acceder a la administración.
     * @param btnAdministrar JButton a establecer.
     */
    public void setBtnAdministrar(JButton btnAdministrar) {
        this.btnAdministrar = btnAdministrar;
    }

    /**
     * Obtiene el botón para ver equipos.
     * @return JButton de ver equipos.
     */
    public JButton getBtnVerE() {
        return btnVerE;
    }

    /**
     * Establece el botón para ver equipos.
     * @param btnVerE JButton a establecer.
     */
    public void setBtnVerE(JButton btnVerE) {
        this.btnVerE = btnVerE;
    }

    /**
     * Obtiene el botón para ver el historial de partidas.
     * @return JButton de historial de partidas.
     */
    public JButton getBtnHistoriaP() {
        return btnHistoriaP;
    }

    /**
     * Establece el botón para ver el historial de partidas.
     * @param btnHistoriaP JButton a establecer.
     */
    public void setBtnHistoriaP(JButton btnHistoriaP) {
        this.btnHistoriaP = btnHistoriaP;
    }

    /**
     * Obtiene el botón para ver jugadores destacados.
     * @return JButton de jugadores destacados.
     */
    public JButton getBtnJugadoresD() {
        return btnJugadoresD;
    }

    /**
     * Establece el botón para ver jugadores destacados.
     * @param btnJugadoresD JButton a establecer.
     */
    public void setBtnJugadoresD(JButton btnJugadoresD) {
        this.btnJugadoresD = btnJugadoresD;
    }

    /**
     * Obtiene el botón para registrarse.
     * @return JButton de registrarse.
     */
    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    /**
     * Establece el botón para registrarse.
     * @param btnRegistrarse JButton a establecer.
     */
    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;
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
     * Obtiene el botón para acceder a los informes.
     * @return JButton de informes.
     */
    public JButton getBtnInformes() {
        return btnInformes;
    }

    /**
     * Establece el botón para acceder a los informes.
     * @param btnInformes JButton a establecer.
     */
    public void setBtnInformes(JButton btnInformes) {
        this.btnInformes = btnInformes;
    }

    /**
     * Obtiene el botón para cambiar el idioma de la aplicación.
     * @return JButton de cambio de idioma.
     */
    public JButton getBtnCambioIdioma() {
        return btnCambioIdioma;
    }

    /**
     * Establece el botón para cambiar el idioma de la aplicación.
     * @param btnCambioIdioma JButton a establecer.
     */
    public void setBtnCambioIdioma(JButton btnCambioIdioma) {
        this.btnCambioIdioma = btnCambioIdioma;
    }

}
