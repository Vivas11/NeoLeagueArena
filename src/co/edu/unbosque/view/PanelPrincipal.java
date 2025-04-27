package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	private JLabel imagen1;
	private JButton btnVerT;
	private JButton btnIniciarS;
	private JButton btnVerE;
	private JButton btnHistoriaP;
	private JButton btnJugadoresD;
	private JButton btnMejoresE;

	public PanelPrincipal() {
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		ImageIcon icono = new ImageIcon("images/image.png");
		Image imagen = icono.getImage().getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		imagen1 = new JLabel(new ImageIcon(imagen));
		imagen1.setBounds(0, 0, 1290, 750);
		add(imagen1);

		btnIniciarS = new JButton();
		btnIniciarS.setBounds(1080, 45, 125, 60);
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

		add(imagen1);
	}

	public JLabel getImagen1() {
		return imagen1;
	}

	public void setImagen1(JLabel imagen1) {
		this.imagen1 = imagen1;
	}

	public JButton getBtnVerT() {
		return btnVerT;
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

	

}
