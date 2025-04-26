package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelPrincipal pnP;
	private PanelIniciarSesion pnlIniciarS;
	private VentanaEmergente vemer;
	private PanelRegistro pnlRegistro;

	public VentanaPrincipal() {
		pnlRegistro = new PanelRegistro();
		vemer = new VentanaEmergente();
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
		pnlRegistro.setVisible(false);

		add(pnP);
		add(pnlIniciarS);
		add(pnlRegistro);
	}

	public PanelRegistro getPnlRegistro() {
		return pnlRegistro;
	}

	public void setPnlRegistro(PanelRegistro pnlRegistro) {
		this.pnlRegistro = pnlRegistro;
	}

	public VentanaEmergente getVemer() {
		return vemer;
	}

	public void setVemer(VentanaEmergente vemer) {
		this.vemer = vemer;
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
