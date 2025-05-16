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

public class PanelHistorial extends JPanel {
	private JLabel fondo;
	private JButton btnVolverHistorial;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private Properties prop;
	private ArrayList<JButton> btnsConfirmar;
	private ArrayList<JSpinner> spinnersA;
	private ArrayList<JSpinner> spinnersB;

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
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
	 * @param listaDatos Lista con la información de cada producto.
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
	 * Actualiza la información mostrada en el panel.
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
	 * 
	 * @param listaDatos Lista con la nueva información de los equipos.
	 */
	public void actualizarInfo() {
		panelContenido.revalidate();
		panelContenido.repaint();
		revalidate();
		repaint();
	}
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolverHistorial() {
		return btnVolverHistorial;
	}

	public void setBtnVolverHistorial(JButton btnVolverHistorial) {
		this.btnVolverHistorial = btnVolverHistorial;
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

	public ArrayList<JButton> getBtnsConfirmar() {
		return btnsConfirmar;
	}

	public void setBtnsConfirmar(ArrayList<JButton> btnsConfirmar) {
		this.btnsConfirmar = btnsConfirmar;
	}

	public ArrayList<JSpinner> getSpinnersA() {
		return spinnersA;
	}

	public void setSpinnersA(ArrayList<JSpinner> spinnersA) {
		this.spinnersA = spinnersA;
	}

	public ArrayList<JSpinner> getSpinnersB() {
		return spinnersB;
	}

	public void setSpinnersB(ArrayList<JSpinner> spinnersB) {
		this.spinnersB = spinnersB;
	}
	
}
