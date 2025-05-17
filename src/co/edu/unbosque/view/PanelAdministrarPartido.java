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

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;

/**
 * Panel para la administración de partidos en la aplicación NeoLeagueArena.
 * Permite visualizar, actualizar y eliminar partidos existentes.
 * Incluye un área de scroll para mostrar los partidos y botones de acción para cada uno.
 * 
 */
public class PanelAdministrarPartido extends JPanel {
    /** Scroll que es usado para navegar en la lista de partidos. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los partidos mostrados. */
    private JPanel panelContenido;
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    /** Lista de botones para eliminar partidos. */
    private ArrayList<JButton> btnsEliminar;
    /** Lista de botones para actualizar partidos. */
    private ArrayList<JButton> btnsActualizar;

    /**
     * Constructor del panel de administración de partidos.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrarPartido(Properties prop) throws IOException {
        this.prop = prop;

        btnsEliminar = new ArrayList<>();
        btnsActualizar = new ArrayList<>();

        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarpartidos")));
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

        agregarPartido(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 200, 660, 360);

        add(scrollPane);
        add(btnVolver);
        add(fondo);
    }

    /**
     * Agrega partidos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de partidos a agregar.
     * @param listaDatos Lista con la información de cada partido.
     */
    public void agregarPartido(int cantidad, ArrayList<Partida> listaDatos) {
        btnsActualizar.clear();
        btnsEliminar.clear();
        panelContenido.removeAll();
        if (cantidad == -1) {
            return;
        }

        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetapartidaadmin");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop, true);
            btnsActualizar.add(tarjeta.getActualizar());
            btnsEliminar.add(tarjeta.getEliminar());
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    /**
     * Actualiza la información mostrada en el panel.
     * Refresca la visualización de los partidos.
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
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarpartidos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Obtiene el scroll de la lista de partidos.
     * @return JScrollPane de la lista de partidos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de partidos.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene la lista de partidos.
     * @return JPanel de contenido.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene la lista de partidos.
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
     * Obtiene la lista de botones para eliminar partidos.
     * @return Lista de JButton para eliminar.
     */
    public ArrayList<JButton> getBtnsEliminar() {
        return btnsEliminar;
    }

    /**
     * Establece la lista de botones para eliminar partidos.
     * @param btnsEliminar Lista de JButton a establecer.
     */
    public void setBtnsEliminar(ArrayList<JButton> btnsEliminar) {
        this.btnsEliminar = btnsEliminar;
    }

    /**
     * Obtiene la lista de botones para actualizar partidos.
     * @return Lista de JButton para actualizar.
     */
    public ArrayList<JButton> getBtnsActualizar() {
        return btnsActualizar;
    }

    /**
     * Establece la lista de botones para actualizar partidos.
     * @param btnsActualizar Lista de JButton a establecer.
     */
    public void setBtnsActualizar(ArrayList<JButton> btnsActualizar) {
        this.btnsActualizar = btnsActualizar;
    }

}
