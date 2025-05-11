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

public class PanelAdministrarU extends JPanel{
	private JLabel fondo;
	private JButton btnVolver;
	private JButton btnJugadores;
	private JButton btnEntrenadores;
	private JButton btnAdministradores;
	private Properties prop;

	public PanelAdministrarU(Properties prop) throws IOException {
		this.prop = prop;
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administraru")));
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
		add(btnVolver);
		
		btnJugadores = new JButton();
		btnJugadores.setBounds(190, 480, 150, 60);
		btnJugadores.setFocusable(false);
		btnJugadores.setOpaque(false);
		btnJugadores.setBorderPainted(false);
		btnJugadores.setContentAreaFilled(false);
		btnJugadores.setBorder(null);
		add(btnJugadores);
		
		btnEntrenadores = new JButton();
		btnEntrenadores.setBounds(540, 480, 150, 60);
		btnEntrenadores.setFocusable(false);
		btnEntrenadores.setOpaque(false);
		btnEntrenadores.setBorderPainted(false);
		btnEntrenadores.setContentAreaFilled(false);
		btnEntrenadores.setBorder(null);
		add(btnEntrenadores);
		
		btnAdministradores = new JButton();
		btnAdministradores.setBounds(900, 480, 170, 60);
		btnAdministradores.setFocusable(false);
		btnAdministradores.setOpaque(false);
		btnAdministradores.setBorderPainted(false);
		btnAdministradores.setContentAreaFilled(false);
		btnAdministradores.setBorder(null);
		add(btnAdministradores);
		
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

	public JButton getBtnJugadores() {
		return btnJugadores;
	}

	public void setBtnJugadores(JButton btnJugadores) {
		this.btnJugadores = btnJugadores;
	}

	public JButton getBtnEntrenadores() {
		return btnEntrenadores;
	}

	public void setBtnEntrenadores(JButton btnEntrenadores) {
		this.btnEntrenadores = btnEntrenadores;
	}

	public JButton getBtnAdministradores() {
		return btnAdministradores;
	}

	public void setBtnAdministradores(JButton btnAdministradores) {
		this.btnAdministradores = btnAdministradores;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
}
