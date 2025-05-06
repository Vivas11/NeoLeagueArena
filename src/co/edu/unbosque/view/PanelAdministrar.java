package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
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

		btnUsuario = new JButton();
		btnUsuario.setBounds(900, 485, 150, 50);
		btnUsuario.setFocusable(false);
		btnUsuario.setOpaque(false);
		btnUsuario.setBorderPainted(false);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorder(null);
		btnUsuario.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnUsuario);

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
		add(btnVolver);
		
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administrar")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1280, 720);

		add(fondo);
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
