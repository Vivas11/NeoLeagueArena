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

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Jugador;

public class PanelEquipo extends JPanel {

	private ArrayList<JButton> btnsIngresar;
	private ArrayList<JButton> btnsSalir;
	
	private JLabel fondo;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private Properties prop;

	public PanelEquipo(Properties prop) throws IOException {
		
		btnsIngresar = new ArrayList<>();
		btnsSalir = new ArrayList<>();
		
		this.prop = prop;
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.equipos")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1280, 720);

		btnVolver = new JButton();

		btnVolver.setBounds(1070, 45, 150, 60);
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(0, 0, 0, 0));
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorder(null);
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));

		panelContenido = new JPanel();
		panelContenido.setBackground(new Color(198, 195, 195));
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

		agregarEquipos(-1, new ArrayList<>());

		scrollPane = new JScrollPane(panelContenido);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 200, 660, 360);

		add(scrollPane);
		add(btnVolver);
		add(fondo);

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

	
	/**
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
	 * @param listaDatos Lista con la información de cada Jugador.
	 */
	public void agregarEquipos(int cantidad, ArrayList<Equipo> listaDatos) {
		btnsIngresar.clear();
		btnsSalir.clear();
		
		panelContenido.removeAll();
		
		if (cantidad == -1) {
			return;
		}

		String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjetaequipo");

		for (int i = 0; i < cantidad; i++) {
			PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop);
			btnsIngresar.add(tarjeta.getIngresar());
			btnsSalir.add(tarjeta.getSalir());
			panelContenido.add(tarjeta);
		}

		panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

		panelContenido.revalidate();
		panelContenido.repaint();
	}
	
	/**
	 * Actualiza los componentes del panel con base en las propiedades.
	 * 
	 * @throws IOException Si ocurre un error al cargar las imágenes.
	 */
	public void actualizarComp() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.equipos")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}

	public JPanel getPanelContenido() {
		return panelContenido;
	}

	public void setPanelContenido(JPanel panelContenido) {
		this.panelContenido = panelContenido;
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

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public ArrayList<JButton> getBtnsIngresar() {
		return btnsIngresar;
	}

	public void setBtnsIngresar(ArrayList<JButton> btnsIngresar) {
		this.btnsIngresar = btnsIngresar;
	}

	public ArrayList<JButton> getBtnsSalir() {
		return btnsSalir;
	}

	public void setBtnsSalir(ArrayList<JButton> btnsSalir) {
		this.btnsSalir = btnsSalir;
	}
	
}
