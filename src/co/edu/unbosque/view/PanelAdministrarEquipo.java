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
import javax.swing.JTextField;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Partida;

/**
 * Panel para la administración de equipos en la aplicación NeoLeagueArena.
 * Permite crear, actualizar y eliminar equipos, así como visualizar la lista de equipos existentes.
 * Incluye campos para ingresar el nombre y país del equipo, botones de acción y un área de scroll para mostrar los equipos.
 * 
 */
public class PanelAdministrarEquipo extends JPanel {

    /** Scroll para navegar en la lista de equipos. */
    private JScrollPane scrollPane;
    /** Panel que contiene la lista de equipos. */
    private JPanel panelContenido;
    /** Etiqueta para la imagen de fondo del panel. */
    private JLabel fondo;
    /** Propiedades de configuración utilizadas para cargar recursos. */
    private Properties prop;
    /** Botón para volver a la pantalla anterior. */
    private JButton btnVolver;
    /** Botón para crear un nuevo equipo. */
    private JButton btnCrearEquipo;
    /** Campo de texto para el nombre del equipo. */
    private JTextField txtNombreEquipo1;
    /** Campo de texto para el país del equipo. */
    private JTextField txtPais;
    /** Lista de botones para eliminar equipos. */
    private ArrayList<JButton> btnsEliminar;
    /** Lista de botones para actualizar equipos. */
    private ArrayList<JButton> btnsActualizar;
    
    /**
     * Constructor del panel de administración de equipos.
     * Inicializa los componentes gráficos y configura el panel.
     * 
     * @param prop Propiedades de configuración para cargar imágenes y recursos.
     * @throws IOException Si ocurre un error al cargar la imagen de fondo.
     */
    public PanelAdministrarEquipo(Properties prop) throws IOException {
        btnsEliminar = new ArrayList<>();
        btnsActualizar = new ArrayList<>();
        
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);

        txtNombreEquipo1 = new JTextField();
        txtNombreEquipo1.setBounds(100, 140, 300, 30);
        txtNombreEquipo1.setFont(new Font("Baloo", Font.BOLD, 20));
        add(txtNombreEquipo1);

        txtPais = new JTextField();
        txtPais.setBounds(100, 230, 300, 30);
        txtPais.setFont(new Font("Baloo", Font.BOLD, 20));
        add(txtPais);

        btnCrearEquipo = new JButton();
        btnCrearEquipo.setBounds(60, 335, 180, 50);
        btnCrearEquipo.setFocusable(false);
        btnCrearEquipo.setOpaque(false);
        btnCrearEquipo.setBorderPainted(false);
        btnCrearEquipo.setContentAreaFilled(false);
        btnCrearEquipo.setBorder(null);
        add(btnCrearEquipo);

        btnVolver = new JButton();
        btnVolver.setBounds(1070, 45, 150, 60);
        btnVolver.setFocusable(false);
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorder(null);
        add(btnVolver);
        
        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

        agregarEquipos(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(300, 300, 660, 360);

        add(scrollPane);
        
        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarequipos")));
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
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarequipos")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Actualiza la información mostrada en el panel.
     * Refresca la visualización de los equipos.
     */
    public void actualizarInfo() {
        panelContenido.revalidate();
        panelContenido.repaint();
        revalidate();
        repaint();
    }

    /**
     * Agrega equipos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de equipos a agregar.
     * @param listaDatos Lista con la información de cada equipo.
     */
    public void agregarEquipos(int cantidad, ArrayList<Equipo> listaDatos) {
        btnsEliminar.clear();
        btnsActualizar.clear();
        
        panelContenido.removeAll();
        
        if (cantidad == -1) {
            return;
        }

        String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetaequipoadmin");

        for (int i = 0; i < cantidad; i++) {
            PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop, true);
            btnsEliminar.add(tarjeta.getEliminar());
            btnsActualizar.add(tarjeta.getActualizar());
            panelContenido.add(tarjeta);
        }

        panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    /**
     * Obtiene el botón para volver a la pantalla anterior.
     * @return JButton de volver.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Obtiene el botón para crear un nuevo equipo.
     * @return JButton de crear equipo.
     */
    public JButton getBtnCrearEquipo() {
        return btnCrearEquipo;
    }

    /**
     * Obtiene el campo de texto para el nombre del equipo.
     * @return JTextField del nombre del equipo.
     */
    public JTextField getTxtNombreEquipo1() {
        return txtNombreEquipo1;
    }

    /**
     * Obtiene el campo de texto para el país del equipo.
     * @return JTextField del país.
     */
    public JTextField getTxtPais() {
        return txtPais;
    }

    /**
     * Obtiene el scroll de la lista de equipos.
     * @return JScrollPane de la lista de equipos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de equipos.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene la lista de equipos.
     * @return JPanel de contenido.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene la lista de equipos.
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
     * Establece el botón para volver a la pantalla anterior.
     * @param btnVolver JButton a establecer.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Establece el botón para crear un nuevo equipo.
     * @param btnCrearEquipo JButton a establecer.
     */
    public void setBtnCrearEquipo(JButton btnCrearEquipo) {
        this.btnCrearEquipo = btnCrearEquipo;
    }

    /**
     * Establece el campo de texto para el nombre del equipo.
     * @param txtNombreEquipo1 JTextField a establecer.
     */
    public void setTxtNombreEquipo1(JTextField txtNombreEquipo1) {
        this.txtNombreEquipo1 = txtNombreEquipo1;
    }

    /**
     * Establece el campo de texto para el país del equipo.
     * @param txtPais JTextField a establecer.
     */
    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    /**
     * Obtiene la lista de botones para eliminar equipos.
     * @return Lista de JButton para eliminar.
     */
    public ArrayList<JButton> getBtnsEliminar() {
        return btnsEliminar;
    }

    /**
     * Establece la lista de botones para eliminar equipos.
     * @param btnsEliminar Lista de JButton a establecer.
     */
    public void setBtnsEliminar(ArrayList<JButton> btnsEliminar) {
        this.btnsEliminar = btnsEliminar;
    }

    /**
     * Obtiene la lista de botones para actualizar equipos.
     * @return Lista de JButton para actualizar.
     */
    public ArrayList<JButton> getBtnsActualizar() {
        return btnsActualizar;
    }

    /**
     * Establece la lista de botones para actualizar equipos.
     * @param btnsActualizar Lista de JButton a establecer.
     */
    public void setBtnsActualizar(ArrayList<JButton> btnsActualizar) {
        this.btnsActualizar = btnsActualizar;
    }
}
