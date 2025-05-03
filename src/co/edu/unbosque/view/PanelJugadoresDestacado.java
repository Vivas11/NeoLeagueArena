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

public class PanelJugadoresDestacado extends JPanel {
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	private JLabel fondo;
	private JButton btnVolverJugadoresDestacado;
	private Properties prop;

	public PanelJugadoresDestacado(Properties prop) throws IOException {
		this.prop = prop;
		
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.jugadores")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1280, 720);

		btnVolverJugadoresDestacado = new JButton();

		btnVolverJugadoresDestacado.setBounds(1070, 45, 150, 60);
		btnVolverJugadoresDestacado.setFocusable(false);
		btnVolverJugadoresDestacado.setForeground(Color.black);
		btnVolverJugadoresDestacado.setBackground(new Color(0, 0, 0, 0));
		btnVolverJugadoresDestacado.setOpaque(false);
		btnVolverJugadoresDestacado.setBorderPainted(false);
		btnVolverJugadoresDestacado.setContentAreaFilled(false);
		btnVolverJugadoresDestacado.setBorder(null);
		btnVolverJugadoresDestacado.setFont(new Font("Baloo", Font.BOLD, 26));

		add(btnVolverJugadoresDestacado);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolverJugadoresDestacado() {
		return btnVolverJugadoresDestacado;
	}

	public void setBtnVolverJugadoresDestacado(JButton btnVolverJugadoresDestacado) {
		this.btnVolverJugadoresDestacado = btnVolverJugadoresDestacado;
	}

}
