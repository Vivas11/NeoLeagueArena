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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

import co.edu.unbosque.model.Torneo;

public class PanelAdministrarTorneo extends JPanel{
	/** Scroll que es usado para navegar en los productos del carrito. */
	private JScrollPane scrollPane;
	/** Panel en el que se guardan todos los productos del carrito. */
	private JPanel panelContenido;
	private JLabel fondo;
	private Properties prop;
	private JButton btnVolver, btnCrear;
	/** Campo de texto para el nombre de usuario. */
	private JTextField nombreTorneo;
	private JTextField nombreJuego;
	
	private JComboBox<String> cbxTipoTorneo;
	
	private JSpinner numeroEquipo;
	
	public PanelAdministrarTorneo(Properties prop) throws IOException {
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
     * Agrega productos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Torneo> listaDatos) {
       
    }


    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los productos.
     */
    public void actualizarInfo(ArrayList<Torneo> listaDatos) {
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
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
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	public JButton getBtnCrear() {
		return btnCrear;
	}
	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}
	public JTextField getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(JTextField nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public JTextField getNombreJuego() {
		return nombreJuego;
	}
	public void setNombreJuego(JTextField nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
	public JComboBox<String> getCbxTipoTorneo() {
		return cbxTipoTorneo;
	}
	public void setCbxTipoTorneo(JComboBox<String> cbxTipoTorneo) {
		this.cbxTipoTorneo = cbxTipoTorneo;
	}
	public JSpinner getNumeroEquipo() {
		return numeroEquipo;
	}
	public void setNumeroEquipo(JSpinner numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}
    
    
}
