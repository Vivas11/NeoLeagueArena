package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdministrar extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnUsuario;
	private JButton btnEquipo;
	private JButton btnTorneo;
	private JButton btnPartido;
	private Properties prop;

	public PanelAdministrar(Properties prop) throws IOException {
		this.prop = prop;
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		btnVolver = new JButton();
		btnVolver.setBounds(1070, 45, 150, 60);
		btnVolver.setFocusable(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorder(null);
		add(btnVolver);
		
		btnUsuario = new JButton();
		btnUsuario.setBounds(715, 225, 150, 50);
		btnUsuario.setFocusable(false);
		btnUsuario.setOpaque(false);
		btnUsuario.setBorderPainted(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorder(null);
		add(btnUsuario);
		
		btnEquipo = new JButton();
		btnEquipo.setBounds(415, 225, 150, 50);
		btnEquipo.setFocusable(false);
		btnEquipo.setOpaque(false);
		btnEquipo.setBorderPainted(false);
		btnEquipo.setContentAreaFilled(false);
		btnEquipo.setBorder(null);
		add(btnEquipo);
		
		btnTorneo = new JButton();
		btnTorneo.setBounds(715, 615, 150, 50);
		btnTorneo.setFocusable(false);
		btnTorneo.setOpaque(false);
		btnTorneo.setBorderPainted(false);
		btnTorneo.setContentAreaFilled(false);
		btnTorneo.setBorder(null);
		add(btnTorneo);

		btnPartido = new JButton();
		btnPartido.setBounds(415, 615, 150, 50);
		btnPartido.setFocusable(false);
		btnPartido.setOpaque(false);
		btnPartido.setBorderPainted(false);
		btnPartido.setContentAreaFilled(false);
		btnPartido.setBorder(null);
		add(btnPartido);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrar")));
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
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrar")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
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

	public JButton getBtnUsuario() {
		return btnUsuario;
	}

	public void setBtnUsuario(JButton btnUsuario) {
		this.btnUsuario = btnUsuario;
	}

	public JButton getBtnEquipo() {
		return btnEquipo;
	}

	public void setBtnEquipo(JButton btnEquipo) {
		this.btnEquipo = btnEquipo;
	}

	public JButton getBtnTorneo() {
		return btnTorneo;
	}

	public void setBtnTorneo(JButton btnTorneo) {
		this.btnTorneo = btnTorneo;
	}

	public JButton getBtnPartido() {
		return btnPartido;
	}

	public void setBtnPartido(JButton btnPartido) {
		this.btnPartido = btnPartido;
	}
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
