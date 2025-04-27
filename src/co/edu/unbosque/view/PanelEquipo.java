package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelEquipo extends JPanel {
	
	private JLabel fondo;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JLabel imagen1;
	
	public PanelEquipo() {
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		ImageIcon icono = new ImageIcon("images/imageee.png");
		Image imagen = icono.getImage().getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		imagen1 = new JLabel(new ImageIcon(imagen));
		imagen1.setBounds(0, 0, 1290, 750);
		add(imagen1);
		
		
		
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(0, 0, 0,0));
		btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false); 
        btnVolver.setBorder(null);
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnVolver);
		
		
	}
	
	
	
	
	

}
