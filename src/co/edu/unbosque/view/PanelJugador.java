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
import javax.swing.JScrollPane;

public class PanelJugador extends JPanel {
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	private JLabel fondo;
	private JButton btnVolverJugador;
	private Properties prop;

	public PanelJugador(Properties prop) throws IOException {
		this.prop = prop;
		
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.jugadores")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1280, 720);

		btnVolverJugador = new JButton();

		btnVolverJugador.setBounds(1070, 45, 150, 60);
		btnVolverJugador.setFocusable(false);
		btnVolverJugador.setForeground(Color.black);
		btnVolverJugador.setBackground(new Color(0, 0, 0, 0));
		btnVolverJugador.setOpaque(false);
		btnVolverJugador.setBorderPainted(false);
		btnVolverJugador.setContentAreaFilled(false);
		btnVolverJugador.setBorder(null);
		btnVolverJugador.setFont(new Font("Baloo", Font.BOLD, 26));

		add(btnVolverJugador);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolverJugadore() {
		return btnVolverJugador;
	}

	public void setBtnVolverJugadore(JButton btnVolverJugador) {
		this.btnVolverJugador = btnVolverJugador;
	}

}
