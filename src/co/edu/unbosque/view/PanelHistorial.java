package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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
	
	public PanelHistorial() {
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		
		ImageIcon icono = new ImageIcon("images/Historial.png");
		Image imagen = icono.getImage().getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo = new JLabel(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 1290, 750);
		
		
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
