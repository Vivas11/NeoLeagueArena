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
	private JButton btnCrearC;

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
		btnIniciarS.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 150))); 

		add(btnIniciarS);


		add(btnIniciarS);

		btnCrearC = new JButton();
		btnCrearC.setBounds(500, 350, 250, 100);
		btnCrearC.setFocusable(false);
		btnCrearC.setBackground(Color.WHITE);
		btnCrearC.setBackground(new Color(153, 0, 0));
		btnCrearC.setContentAreaFilled(false);

		add(btnCrearC);

		btnVerT = new JButton();
		btnVerT.setBounds(555, 617, 180, 60);
		btnVerT.setFocusable(false);
		btnVerT.setBackground(Color.WHITE);
		btnVerT.setBackground(new Color(153, 0, 0));
		btnVerT.setContentAreaFilled(false);
		add(btnVerT);

		add(imagen1);
	}

	public JLabel getImagen() {
		return imagen1;
	}

	public void setImagen(JLabel imagen) {
		this.imagen1 = imagen;
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

	public JButton getBtnCrearC() {
		return btnCrearC;
	}

	public void setBtnCrearC(JButton btnCrearC) {
		this.btnCrearC = btnCrearC;
	}

}
