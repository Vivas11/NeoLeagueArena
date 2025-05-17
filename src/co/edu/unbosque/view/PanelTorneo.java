package co.edu.unbosque.view;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Torneo;

/**
 * Panel para la visualización y gestión de torneos en la aplicación NeoLeagueArena.
 * Permite mostrar la lista de torneos, ver la tabla de cada torneo y navegar entre pantallas.
 * Incluye un área de scroll para mostrar los torneos y botones de acción para cada uno.
 */
public class PanelTorneo extends JPanel{
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
    /** Lista de botones para ver la tabla de cada torneo. */
    private ArrayList<JButton> btnsVerTabla;

    /**
     * Constructor del panel de torneos.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelTorneo(Properties prop) throws IOException {
        this.prop = prop;

        btnsVerTabla = new ArrayList<>();

        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.torneos")));
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

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        agregarTorneo(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 200, 660, 360);

        add(scrollPane);
        add(btnVolver);
        add(fondo);
    }

    /**
     * Agrega torneos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de torneos a agregar.
     * @param listaDatos Lista con la información de cada torneo.
     */
    public void agregarTorneo(int cantidad, ArrayList<Torneo> listaDatos) {
        btnsVerTabla.clear();
        panelContenido.removeAll();
        if (cantidad == -1) {
            return;
        }

        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetatorneo");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop);
            btnsVerTabla.add(tarjeta.getVerTabla());
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    /**
     * Actualiza la información mostrada en el panel.
     * Refresca la visualización de los torneos.
     */
    public void actualizarInfo() {
        panelContenido.revalidate();
        panelContenido.repaint();
        revalidate();
        repaint();
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * Recarga la imagen de fondo.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.torneos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
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
     * Obtiene la lista de botones para ver la tabla de cada torneo.
     * @return Lista de JButton para ver tabla.
     */
    public ArrayList<JButton> getBtnsVerTabla() {
        return btnsVerTabla;
    }

    /**
     * Establece la lista de botones para ver la tabla de cada torneo.
     * @param btnsVerTabla Lista de JButton a establecer.
     */
    public void setBtnsVerTabla(ArrayList<JButton> btnsVerTabla) {
        this.btnsVerTabla = btnsVerTabla;
    }
}