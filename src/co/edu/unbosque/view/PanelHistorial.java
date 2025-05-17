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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Torneo;

/**
 * Panel para la visualización y gestión del historial de partidas en la aplicación NeoLeagueArena.
 * Permite mostrar la lista de partidas, confirmar resultados y navegar entre pantallas.
 * Incluye un área de scroll para mostrar las partidas y controles para cada una.
 * 
 */
public class PanelHistorial extends JPanel {
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolverHistorial;
    /** Scroll que es usado para navegar en la lista de partidas. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todas las partidas mostradas. */
    private JPanel panelContenido;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;
    /** Lista de botones para confirmar resultados de partidas. */
    private ArrayList<JButton> btnsConfirmar;
    /** Lista de spinners para el equipo A en cada partida. */
    private ArrayList<JSpinner> spinnersA;
    /** Lista de spinners para el equipo B en cada partida. */
    private ArrayList<JSpinner> spinnersB;

    /**
     * Constructor del panel de historial.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelHistorial(Properties prop) throws IOException {
         btnsConfirmar = new ArrayList<>();
         spinnersA = new ArrayList<>();
         spinnersB = new ArrayList<>();
        
        setBounds(0, 0, 1280, 720);
        setLayout(null);
        this.prop = prop;

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.historialpartidos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        btnVolverHistorial = new JButton();
        btnVolverHistorial.setBounds(1070, 45, 150, 60);
        btnVolverHistorial.setFocusable(false);
        btnVolverHistorial.setForeground(Color.black);
        btnVolverHistorial.setBackground(new Color(0, 0, 0, 0));
        btnVolverHistorial.setOpaque(false);
        btnVolverHistorial.setBorderPainted(false);
        btnVolverHistorial.setContentAreaFilled(false);
        btnVolverHistorial.setBorder(null);
        btnVolverHistorial.setFont(new Font("Baloo", Font.BOLD, 26));
        
        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        
        agregarPartida(-1, new ArrayList<>());
        
        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 200, 660, 360);

        add(scrollPane);
        add(btnVolverHistorial);
        add(fondo);

    }

    /**
     * Agrega partidas con sus botones y spinners correspondientes al panel.
     * 
     * @param cantidad   Cantidad de partidas a agregar.
     * @param listaDatos Lista con la información de cada partida.
     */
    public void agregarPartida(int cantidad, ArrayList<Partida> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        btnsConfirmar.clear();
        spinnersA.clear();
        spinnersB.clear();        
        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetapartida");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo);
            btnsConfirmar.add(tarjeta.getConfirmar());
            spinnersA.add(tarjeta.getE1());
            spinnersB.add(tarjeta.getE2());
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    /**
     * Actualiza la información mostrada en el panel con una nueva lista de partidas.
     * 
     * @param listaDatos Lista con la nueva información de las partidas.
     */
    public void actualizarInfo(ArrayList<Partida> listaDatos) {
        panelContenido.removeAll();
        agregarPartida(listaDatos.size(), listaDatos);
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
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.historialpartidos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Actualiza la información mostrada en el panel.
     * Refresca la visualización de las partidas.
     */
    public void actualizarInfo() {
        panelContenido.revalidate();
        panelContenido.repaint();
        revalidate();
        repaint();
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
    public JButton getBtnVolverHistorial() {
        return btnVolverHistorial;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * @param btnVolverHistorial JButton a establecer.
     */
    public void setBtnVolverHistorial(JButton btnVolverHistorial) {
        this.btnVolverHistorial = btnVolverHistorial;
    }

    /**
     * Obtiene el scroll de la lista de partidas.
     * @return JScrollPane de la lista de partidas.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de partidas.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene la lista de partidas.
     * @return JPanel de contenido.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene la lista de partidas.
     * @param panelContenido JPanel a establecer.
     */
    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }

    /**
     * Obtiene la lista de botones para confirmar resultados de partidas.
     * @return Lista de JButton para confirmar.
     */
    public ArrayList<JButton> getBtnsConfirmar() {
        return btnsConfirmar;
    }

    /**
     * Establece la lista de botones para confirmar resultados de partidas.
     * @param btnsConfirmar Lista de JButton a establecer.
     */
    public void setBtnsConfirmar(ArrayList<JButton> btnsConfirmar) {
        this.btnsConfirmar = btnsConfirmar;
    }

    /**
     * Obtiene la lista de spinners para el equipo A en cada partida.
     * @return Lista de JSpinner para equipo A.
     */
    public ArrayList<JSpinner> getSpinnersA() {
        return spinnersA;
    }

    /**
     * Establece la lista de spinners para el equipo A en cada partida.
     * @param spinnersA Lista de JSpinner a establecer.
     */
    public void setSpinnersA(ArrayList<JSpinner> spinnersA) {
        this.spinnersA = spinnersA;
    }

    /**
     * Obtiene la lista de spinners para el equipo B en cada partida.
     * @return Lista de JSpinner para equipo B.
     */
    public ArrayList<JSpinner> getSpinnersB() {
        return spinnersB;
    }

    /**
     * Establece la lista de spinners para el equipo B en cada partida.
     * @param spinnersB Lista de JSpinner a establecer.
     */
    public void setSpinnersB(ArrayList<JSpinner> spinnersB) {
        this.spinnersB = spinnersB;
    }
    
}
