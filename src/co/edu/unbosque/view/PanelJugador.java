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

import co.edu.unbosque.model.Jugador;

/**
 * Panel para la visualización de jugadores en la aplicación NeoLeagueArena.
 * Permite mostrar la lista de jugadores y navegar entre pantallas.
 * Incluye un área de scroll para mostrar los jugadores.
 */
public class PanelJugador extends JPanel {
    /** Scroll que es usado para navegar en los productos del carrito. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del carrito. */
    private JPanel panelContenido;
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolverJugador;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;

    /**
     * Constructor del panel de jugadores.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelJugador(Properties prop) throws IOException {
        this.prop = prop;

        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.jugadores")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        btnVolverJugador = new JButton();
        btnVolverJugador.setBounds(1070, 45, 150, 60);
        btnVolverJugador.setFocusable(false);
        btnVolverJugador.setForeground(Color.black);
        btnVolverJugador.setBackground(new Color(0, 0, 0, 0));
        btnVolverJugador.setOpaque(false);
        btnVolverJugador.setBorderPainted(false);
        btnVolverJugador.setContentAreaFilled(false);
        btnVolverJugador.setBorder(null);
        btnVolverJugador.setFont(new Font("Baloo", Font.BOLD, 26));

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        agregarProducto(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 200, 660, 360);

        add(scrollPane);
        add(btnVolverJugador);
        add(fondo);
    }

    /**
     * Agrega jugadores con sus componentes correspondientes al panel.
     * 
     * @param cantidad   Cantidad de jugadores a agregar.
     * @param listaDatos Lista con la información de cada jugador.
     */
    public void agregarProducto(int cantidad, ArrayList<Jugador> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjeta");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop);
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    /**
     * Actualiza la información mostrada en el panel con una nueva lista de jugadores.
     * 
     * @param listaDatos Lista con la nueva información de los jugadores.
     */
    public void actualizarInfo(ArrayList<Jugador> listaDatos) {
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
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
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.jugadores")));
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
    public JButton getBtnVolverJugadore() {
        return btnVolverJugador;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * @param btnVolverJugador JButton a establecer.
     */
    public void setBtnVolverJugadore(JButton btnVolverJugador) {
        this.btnVolverJugador = btnVolverJugador;
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
