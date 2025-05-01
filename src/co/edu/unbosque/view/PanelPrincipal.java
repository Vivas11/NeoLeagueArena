package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	private JLabel fondo;
	private JButton btnVerT;
	private JButton btnIniciarS;
	private JButton btnVerE;
	private JButton btnHistoriaP;
	private JButton btnJugadoresD;
	private JButton btnMejoresE;
	private JButton btnRegistrarse;
	private Properties prop;

	public PanelPrincipal(Properties prop) throws IOException {
		this.prop = prop;
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.menu")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1300, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnIniciarS = new JButton();
		btnIniciarS.setBounds(1020, 45, 125, 60);
		btnIniciarS.setFocusable(false);
		btnIniciarS.setOpaque(false);
		btnIniciarS.setContentAreaFilled(false);
		btnIniciarS.setBorderPainted(false);
		btnIniciarS.setBorder(null);
		add(btnIniciarS);

		btnVerE = new JButton();
		btnVerE.setBounds(40, 45, 170, 50);
		btnVerE.setFocusable(false);
		btnVerE.setOpaque(false);
		btnVerE.setContentAreaFilled(false);
		btnVerE.setBorderPainted(false);
		btnVerE.setBorder(null);

		add(btnVerE);

		btnVerT = new JButton();
		btnVerT.setBounds(555, 617, 180, 60);
		btnVerT.setFocusable(false);
		btnVerT.setContentAreaFilled(false);
		btnVerT.setOpaque(false);
		btnVerT.setBorderPainted(false);
		btnVerT.setBorder(null);

		add(btnVerT);

		btnHistoriaP = new JButton();
		btnHistoriaP.setBounds(250, 45, 170, 60);
		btnHistoriaP.setFocusable(false);
		btnHistoriaP.setContentAreaFilled(false);
		btnHistoriaP.setOpaque(false);
		btnHistoriaP.setBorderPainted(false);
		btnHistoriaP.setBorder(null);
		add(btnHistoriaP);

		btnJugadoresD = new JButton();
		btnJugadoresD.setBounds(450, 45, 170, 60);
		btnJugadoresD.setFocusable(false);
		btnJugadoresD.setContentAreaFilled(false);
		btnJugadoresD.setOpaque(false);
		btnJugadoresD.setBorderPainted(false);
		btnJugadoresD.setBorder(null);

		add(btnJugadoresD);

		btnMejoresE = new JButton();
		btnMejoresE.setBounds(650, 45, 160, 60);
		btnMejoresE.setFocusable(false);
		btnMejoresE.setContentAreaFilled(false);
		btnMejoresE.setOpaque(false);
		btnMejoresE.setBorderPainted(false);
		btnMejoresE.setBorder(null);

		add(btnMejoresE);

		btnRegistrarse = new JButton();
		btnRegistrarse.setBounds(1150, 45, 120, 60);

		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setForeground(Color.black);
		btnRegistrarse.setBackground(new Color(0, 0, 0, 0));
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnRegistrarse);

		add(fondo);
	}

	public JLabel getImagen1() {
		return fondo;
	}

	public void setImagen1(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVerT() {
		return btnVerT;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setBtnVerT(JButton btnVerT) {
		this.btnVerT = btnVerT;
	}

	public JButton getBtnIniciarS() {
		return btnIniciarS;
	}

	public void setBtnIniciarS(JButton btnIniciarS) {
		this.btnIniciarS = btnIniciarS;
	}

	public JButton getBtnVerE() {
		return btnVerE;
	}

	public void setBtnVerE(JButton btnVerE) {
		this.btnVerE = btnVerE;
	}

	public JButton getBtnHistoriaP() {
		return btnHistoriaP;
	}

	public void setBtnHistoriaP(JButton btnHistoriaP) {
		this.btnHistoriaP = btnHistoriaP;
	}

	public JButton getBtnJugadoresD() {
		return btnJugadoresD;
	}

	public void setBtnJugadoresD(JButton btnJugadoresD) {
		this.btnJugadoresD = btnJugadoresD;
	}

	public JButton getBtnMejoresE() {
		return btnMejoresE;
	}

	public void setBtnMejoresE(JButton btnMejoresE) {
		this.btnMejoresE = btnMejoresE;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

}
