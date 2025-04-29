package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelJugadoresDestacado   extends JPanel {
	private JLabel fondo;
	private JButton btnVolverJugadoresDestacado;
	
	 public PanelJugadoresDestacado() {
		 setBounds(0, 0, 1290, 750);
			setLayout(null);
			
			ImageIcon icono = new ImageIcon("images/jugadores.png");
			Image imagen = icono.getImage().getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
			fondo = new JLabel(new ImageIcon(imagen));
			fondo.setBounds(0, 0, 1290, 750);
	  
	  
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
