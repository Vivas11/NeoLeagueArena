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

/**
 * Panel para la administración de usuarios específicos (jugadores, entrenadores, administradores)
 * en la aplicación NeoLeagueArena. Permite visualizar, actualizar y eliminar usuarios.
 * Incluye un área de scroll para mostrar los usuarios y botones de acción para cada uno.
 * 
 */
public class PanelAdministrarUE extends JPanel {
    /** Scroll que es usado para navegar en la lista de usuarios. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los usuarios mostrados. */
    private JPanel panelContenido;
    /** Lista de botones para eliminar usuarios. */
    private ArrayList<JButton> btnsEliminar;
    /** Lista de botones para actualizar usuarios. */
    private ArrayList<JButton> btnsActualizar;
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolverJugador;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;

    /**
     * Constructor del panel de administración de usuarios específicos.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrarUE(Properties prop) throws IOException {
        this.prop = prop;
        
        btnsEliminar = new ArrayList<>();
        btnsActualizar = new ArrayList<>();
        
        setBounds(0, 0, 1280, 720);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarue")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);

        btnVolverJugador = new JButton();
        btnVolverJugador.setBounds(1070, 45, 150, 60);
        btnVolverJugador.setFocusable(false);
        btnVolverJugador.setOpaque(false);
        btnVolverJugador.setBorderPainted(false);
        btnVolverJugador.setContentAreaFilled(false);
        btnVolverJugador.setBorder(null);

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        agregarJugador(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 200, 660, 360);

        add(scrollPane);
        add(btnVolverJugador);
        add(fondo);
    }

    /**
     * Agrega jugadores con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de jugadores a agregar.
     * @param listaDatos Lista con la información de cada Jugador.
     */
    public void agregarJugador(int cantidad, ArrayList<Jugador> listaDatos) {
        btnsActualizar.clear();
        btnsEliminar.clear();
        
        panelContenido.removeAll();
        
        if (cantidad == -1) {
            return;
        }

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetaadmin");

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
     * Agrega entrenadores con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de entrenadores a agregar.
     * @param listaDatos Lista con la información de cada Entrenador.
     */
    public void agregarEntrenador(int cantidad, ArrayList<Entrenador> listaDatos) {
        btnsActualizar.clear();
        btnsEliminar.clear();
        panelContenido.removeAll();
        if (cantidad == -1) {
            return;
        }

        panelContenido.removeAll();
        
        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetaadmin");

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
     * Agrega administradores con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de administradores a agregar.
     * @param listaDatos Lista con la información de cada Administrador.
     */
    public void agregarAdministrador(int cantidad, ArrayList<Administrador> listaDatos) {
        btnsActualizar.clear();
        btnsEliminar.clear();
        panelContenido.removeAll();
        if (cantidad == -1) {
            return;
        }

        panelContenido.removeAll();

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetaadmin");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop);
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
     * Refresca la visualización de los usuarios.
     * 
     * 
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
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarue")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Obtiene el scroll de la lista de usuarios.
     * @return JScrollPane de la lista de usuarios.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de usuarios.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene la lista de usuarios.
     * @return JPanel de contenido.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene la lista de usuarios.
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
     * Obtiene el botón para volver a la pantalla anterior.
     * @return JButton de volver.
     */
    public JButton getBtnVolverJugador() {
        return btnVolverJugador;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * @param btnVolverJugador JButton a establecer.
     */
    public void setBtnVolverJugador(JButton btnVolverJugador) {
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

    /**
     * Obtiene la lista de botones para eliminar usuarios.
     * @return Lista de JButton para eliminar.
     */
    public ArrayList<JButton> getBtnsEliminar() {
        return btnsEliminar;
    }

    /**
     * Establece la lista de botones para eliminar usuarios.
     * @param btnsEliminar Lista de JButton a establecer.
     */
    public void setBtnsEliminar(ArrayList<JButton> btnsEliminar) {
        this.btnsEliminar = btnsEliminar;
    }

    /**
     * Obtiene la lista de botones para actualizar usuarios.
     * @return Lista de JButton para actualizar.
     */
    public ArrayList<JButton> getBtnsActualizar() {
        return btnsActualizar;
    }

    /**
     * Establece la lista de botones para actualizar usuarios.
     * @param btnsActualizar Lista de JButton a establecer.
     */
    public void setBtnsActualizar(ArrayList<JButton> btnsActualizar) {
        this.btnsActualizar = btnsActualizar;
    }
    
}