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

public class PanelAdministrarPartido extends JPanel {
	/** Scroll que es usado para navegar en los productos del carrito. */
	private JScrollPane scrollPane;
	/** Panel en el que se guardan todos los productos del carrito. */
	private JPanel panelContenido;
	private JLabel fondo;
	private Properties prop;
	private JButton btnVolver;

	private ArrayList<JButton> btnsEliminar;
	private ArrayList<JButton> btnsActualizar;

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
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
	 * @param listaDatos Lista con la información de cada producto.
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
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrarpartidos")));
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
