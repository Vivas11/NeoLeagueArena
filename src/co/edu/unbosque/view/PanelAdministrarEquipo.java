package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import co.edu.unbosque.model.Partida;

public class PanelAdministrarEquipo extends JPanel {

    private JScrollPane scrollPane;
    private JPanel panelContenido;
    private JLabel fondo;
    private Properties prop;
    private JButton btnVolver, btnCrearEquipo;
    private JTextField txtNombreEquipo1, txtPais;

    public PanelAdministrarEquipo(Properties prop) throws IOException {
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
     * Agrega productos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Partida> listaDatos) {

    }

    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los productos.
     */
    public void actualizarInfo(ArrayList<Partida> listaDatos) {
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }
    
    public JButton getBtnVolver() {
		return btnVolver;
	}


	public JButton getBtnCrearEquipo() {
		return btnCrearEquipo;
	}


	public JTextField getTxtNombreEquipo1() {
		return txtNombreEquipo1;
	}


	public JTextField getTxtPais() {
		return txtPais;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JPanel getPanelContenido() {
		return panelContenido;
	}


	public void setPanelContenido(JPanel panelContenido) {
		this.panelContenido = panelContenido;
	}


	public JLabel getFondo() {
		return fondo;
	}


	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}


	public Properties getProp() {
		return prop;
	}


	public void setProp(Properties prop) {
		this.prop = prop;
	}


	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public void setBtnCrearEquipo(JButton btnCrearEquipo) {
		this.btnCrearEquipo = btnCrearEquipo;
	}


	public void setTxtNombreEquipo1(JTextField txtNombreEquipo1) {
		this.txtNombreEquipo1 = txtNombreEquipo1;
	}


	public void setTxtPais(JTextField txtPais) {
		this.txtPais = txtPais;
	}
}
