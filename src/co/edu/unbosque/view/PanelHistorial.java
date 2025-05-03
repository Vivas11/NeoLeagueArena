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

public class PanelHistorial extends JPanel  {
	private JLabel fondo;
	private JButton btnVolverHistorial;
	private JScrollPane scrollPane;
	private JPanel panelContenido;
	private Properties prop;
	
	public PanelHistorial(Properties prop) throws IOException {
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
		
		
		

		JScrollPane scrollPrincipal = new JScrollPane(panelContenido);
		scrollPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPrincipal.setBounds(25, 150, 700, 450);
		
		add(btnVolverHistorial);
	
		
		add(fondo);
		
		
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
	
	
	
	

}
