package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

  public class PanelPrincipal extends JPanel {

	    private JLabel imagen;
	    private JButton btnVerT;
	    private JButton btnIniciarS;
	    private JButton btnCrearC;

	    public PanelPrincipal() {
	        setBounds(0, 0, 1290, 750);
	        setLayout(null);

	        imagen = new JLabel();
	        imagen.setOpaque(true); 
	        imagen.setBackground(Color.BLACK);
	        imagen.setBounds(0, 0, 1290, 750);
	        imagen.setLayout(null);
	        
	        
	        
	        btnIniciarS = new JButton();
	        btnIniciarS.setBounds(500, 200, 250, 100);
	        btnIniciarS.setFocusable(false);
	        btnIniciarS.setBackground(Color.WHITE);
			btnIniciarS.setBackground(new Color(153, 0, 0));
			
			add(btnIniciarS);
			
			
			
			btnCrearC  = new JButton();
			btnCrearC.setBounds(500, 350, 250, 100);
			btnCrearC.setFocusable(false);
			btnCrearC.setBackground(Color.WHITE);
			btnCrearC.setBackground(new Color(153, 0, 0));
			
			add(btnCrearC);
			
			
			btnVerT  = new JButton();
			btnVerT.setBounds(500, 500, 250, 100);
			btnVerT.setFocusable(false);
			btnVerT.setBackground(Color.WHITE);
			btnVerT.setBackground(new Color(153, 0, 0));
			
			add(btnVerT);
	        

	        add(imagen);
	    }

	    public static void main(String[] args) {
	        JFrame ventana = new JFrame("Prueba del Panel Principal");
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        ventana.setSize(1300, 780);
	        ventana.setLayout(null);

	        PanelPrincipal panel = new PanelPrincipal();
	        ventana.add(panel);

	        ventana.setVisible(true);
	    }

		public JLabel getImagen() {
			return imagen;
		}

		public void setImagen(JLabel imagen) {
			this.imagen = imagen;
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
 