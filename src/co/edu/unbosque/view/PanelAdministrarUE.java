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
public class PanelAdministrarUE extends JPanel {
	/** Scroll que es usado para navegar en los productos del carrito. */
	private JScrollPane scrollPane;
	/** Panel en el que se guardan todos los productos del carrito. */
	private JPanel panelContenido;

	private ArrayList<JButton> btnsEliminar;
	private ArrayList<JButton> btnsActualizar;
	
	private JLabel fondo;
	private JButton btnVolverJugador;
	private Properties prop;

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
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
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
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
	 * @param listaDatos Lista con la información de cada producto.
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
	 * 
	 * @param listaDatos Lista con la nueva información de los productos.
	 */
	public void actualizarInfo() {
		panelContenido.revalidate();
		panelContenido.repaint();
		revalidate();
		repaint();
	}

	/**
	 * Actualiza los componentes del panel con base en las propiedades.
	 * 
	 * @throws IOException Si ocurre un error al cargar las imágenes.
	 */
	public void actualizarComp() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarue")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
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

	public JButton getBtnVolverJugador() {
		return btnVolverJugador;
	}

	public void setBtnVolverJugador(JButton btnVolverJugador) {
		this.btnVolverJugador = btnVolverJugador;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public ArrayList<JButton> getBtnsEliminar() {
		return btnsEliminar;
	}

	public void setBtnsEliminar(ArrayList<JButton> btnsEliminar) {
		this.btnsEliminar = btnsEliminar;
	}

	public ArrayList<JButton> getBtnsActualizar() {
		return btnsActualizar;
	}

	public void setBtnsActualizar(ArrayList<JButton> btnsActualizar) {
		this.btnsActualizar = btnsActualizar;
	}
	
}