package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PanelPrincipal pnP;
	private PanelIniciarSesion pnlIniciarS;
	   
public VentanaPrincipal() {
	
	pnP = new PanelPrincipal();
	pnlIniciarS = new PanelIniciarSesion();
	
	 setBounds(150, 150, 1300, 750);
     setTitle("Neo League Arena");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setResizable(true);
     setLayout(null);
     setResizable(false); 
     
     pnP.setVisible(true);
     pnlIniciarS.setVisible(false);
     
     add(pnP);
     add(pnlIniciarS);
}


public PanelIniciarSesion getPnlIniciarS() {
	return pnlIniciarS;
}


public void setPnlIniciarS(PanelIniciarSesion pnlIniciarS) {
	this.pnlIniciarS = pnlIniciarS;
}


public PanelPrincipal getPnP() {
	return pnP;
}

public void setPnP(PanelPrincipal pnP) {
	this.pnP = pnP;
}	 


}
