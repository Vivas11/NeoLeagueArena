package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Torneo;

/**
 * Panel para la administración de torneos en la aplicación NeoLeagueArena.
 * Permite crear, visualizar y eliminar torneos, así como configurar sus propiedades.
 * Incluye campos para el nombre, tipo y cantidad de equipos, y un área de scroll para mostrar los torneos existentes.
 * 
 */
public class PanelAdministrarTorneo extends JPanel{
    /** Scroll que es usado para navegar en la lista de torneos. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los torneos mostrados. */
    private JPanel panelContenido;
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    /** Botón para crear un nuevo torneo. */
    private JButton btnCrear;
    /** Lista de botones para eliminar torneos. */
    private ArrayList<JButton> btnsEliminar;
    /** Campo de texto para el nombre del torneo. */
    private JTextField nombreTorneo;
    /** Campo de texto para el nombre del juego. */
    private JTextField nombreJuego;
    /** ComboBox para seleccionar el tipo de torneo. */
    private JComboBox<String> cbxTipoTorneo;
    /** Spinner para seleccionar el número de equipos. */
    private JSpinner numeroEquipo;

    /**
     * Constructor del panel de administración de torneos.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrarTorneo(Properties prop) throws IOException {
        btnsEliminar = new ArrayList<>();
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);
        //Parte derecha 

        btnVolver = new JButton();
        btnVolver.setBounds(1070, 45, 150, 60);
        btnVolver.setFocusable(false);
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorder(null);
        add(btnVolver);

        btnCrear = new JButton();
        btnCrear.setBounds(1040, 630, 170, 40);
        btnCrear.setFocusable(false);
        btnCrear.setOpaque(false);
        btnCrear.setBorderPainted(false);
        btnCrear.setContentAreaFilled(false);
        btnCrear.setBorder(null);
        add(btnCrear);

        nombreTorneo = new JTextField();
        nombreTorneo.setBounds(900, 140, 300, 30);
        nombreTorneo.setFont(new Font("Baloo", Font.BOLD, 20));
        add(nombreTorneo);

        nombreJuego = new JTextField();
        nombreJuego.setBounds(900, 225, 300, 30);
        nombreJuego.setFont(new Font("Baloo", Font.BOLD, 20));
        add(nombreJuego);

        cbxTipoTorneo = new JComboBox<>(new String[] { "Tipo de torneo", "Liga", "Eliminacion directa"});
        cbxTipoTorneo.setFont(new Font("Baloo", Font.BOLD, 20));
        cbxTipoTorneo.setBounds(900, 325, 300, 30);
        add(cbxTipoTorneo);

        numeroEquipo = new JSpinner(new SpinnerNumberModel(8, 8, Integer.MAX_VALUE, 1));
        numeroEquipo.setFont(new Font("Baloo", Font.BOLD, 20));
        numeroEquipo.setBounds(900, 425, 300, 30);
        add(numeroEquipo);

        //Parte izquierda

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        agregarTorneo(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 200, 660, 360);

        add(scrollPane);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrartorneos")));
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
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrartorneos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Agrega torneos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de torneos a agregar.
     * @param listaDatos Lista con la información de cada torneo.
     */
    public void agregarTorneo(int cantidad, ArrayList<Torneo> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        btnsEliminar.clear();	
        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetatorneoadmin");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop, true);
            btnsEliminar.add(tarjeta.getEliminar());
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los torneos.
     */
    public void actualizarInfo(ArrayList<Torneo> listaDatos) {
        panelContenido.removeAll();
        agregarTorneo(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }

    /**
     * Obtiene el scroll de la lista de torneos.
     * @return JScrollPane de la lista de torneos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de torneos.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene la lista de torneos.
     * @return JPanel de contenido.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene la lista de torneos.
     * @param panelContenido JPanel a establecer.
     */
    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
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
     * Obtiene el botón para crear un nuevo torneo.
     * @return JButton de crear torneo.
     */
    public JButton getBtnCrear() {
        return btnCrear;
    }

    /**
     * Establece el botón para crear un nuevo torneo.
     * @param btnCrear JButton a establecer.
     */
    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    /**
     * Obtiene el campo de texto para el nombre del torneo.
     * @return JTextField del nombre del torneo.
     */
    public JTextField getNombreTorneo() {
        return nombreTorneo;
    }

    /**
     * Establece el campo de texto para el nombre del torneo.
     * @param nombreTorneo JTextField a establecer.
     */
    public void setNombreTorneo(JTextField nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * Obtiene el campo de texto para el nombre del juego.
     * @return JTextField del nombre del juego.
     */
    public JTextField getNombreJuego() {
        return nombreJuego;
    }

    /**
     * Establece el campo de texto para el nombre del juego.
     * @param nombreJuego JTextField a establecer.
     */
    public void setNombreJuego(JTextField nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    /**
     * Obtiene el ComboBox para seleccionar el tipo de torneo.
     * @return JComboBox de tipo de torneo.
     */
    public JComboBox<String> getCbxTipoTorneo() {
        return cbxTipoTorneo;
    }

    /**
     * Establece el ComboBox para seleccionar el tipo de torneo.
     * @param cbxTipoTorneo JComboBox a establecer.
     */
    public void setCbxTipoTorneo(JComboBox<String> cbxTipoTorneo) {
        this.cbxTipoTorneo = cbxTipoTorneo;
    }

    /**
     * Obtiene el Spinner para seleccionar el número de equipos.
     * @return JSpinner del número de equipos.
     */
    public JSpinner getNumeroEquipo() {
        return numeroEquipo;
    }

    /**
     * Establece el Spinner para seleccionar el número de equipos.
     * @param numeroEquipo JSpinner a establecer.
     */
    public void setNumeroEquipo(JSpinner numeroEquipo) {
        this.numeroEquipo = numeroEquipo;
    }

    /**
     * Obtiene la lista de botones para eliminar torneos.
     * @return Lista de JButton para eliminar.
     */
    public ArrayList<JButton> getBtnsEliminar() {
        return btnsEliminar;
    }

    /**
     * Establece la lista de botones para eliminar torneos.
     * @param btnsEliminar Lista de JButton a establecer.
     */
    public void setBtnsEliminar(ArrayList<JButton> btnsEliminar) {
        this.btnsEliminar = btnsEliminar;
    }
}
