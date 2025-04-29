package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelPrincipal pnP;
	private PanelIniciarSesion pnlIniciarS;
	private VentanaEmergente vemer;
	private PanelRegistroEntrenador pnlRegistroEntrenador;
	private PanelRegistroAdministrador pnlRegistroAdministrador;
	private PanelRegistroJugador pnlRegistroJugador;
	private PanelEquipo pnE;
	private PanelHistorial pnH;

	public VentanaPrincipal() {
		pnlRegistroEntrenador = new PanelRegistroEntrenador();
		pnlRegistroJugador = new PanelRegistroJugador();
		pnlRegistroAdministrador = new PanelRegistroAdministrador();
		vemer = new VentanaEmergente();
		pnP = new PanelPrincipal();
		pnlIniciarS = new PanelIniciarSesion();
		pnE = new PanelEquipo();

		setBounds(150, 150, 1300, 750);
		setTitle("Neo League Arena");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);
		setResizable(false);

		pnP.setVisible(true);
		pnlIniciarS.setVisible(false);
		pnlRegistroEntrenador.setVisible(false);
		pnlRegistroAdministrador.setVisible(false);
		pnlRegistroJugador.setVisible(false);
		pnE.setVisible(false);
		pnH.setVisible(false);

		add(pnP);
		add(pnlIniciarS);
		add(pnlRegistroEntrenador);
		add(pnlRegistroAdministrador);
		add(pnlRegistroJugador);
		add(pnE);
		add(pnH);
		
	}

	public PanelPrincipal getPnP() {
		return pnP;
	}

	public void setPnP(PanelPrincipal pnP) {
		this.pnP = pnP;
	}

	public PanelIniciarSesion getPnlIniciarS() {
		return pnlIniciarS;
	}

	public void setPnlIniciarS(PanelIniciarSesion pnlIniciarS) {
		this.pnlIniciarS = pnlIniciarS;
	}

	public VentanaEmergente getVemer() {
		return vemer;
	}

	public void setVemer(VentanaEmergente vemer) {
		this.vemer = vemer;
	}

	public PanelRegistroEntrenador getPnlRegistroEntrenador() {
		return pnlRegistroEntrenador;
	}

	public void setPnlRegistroEntrenador(PanelRegistroEntrenador pnlRegistroEntrenador) {
		this.pnlRegistroEntrenador = pnlRegistroEntrenador;
	}

	public PanelRegistroAdministrador getPnlRegistroAdministrador() {
		return pnlRegistroAdministrador;
	}

	public void setPnlRegistroAdministrador(PanelRegistroAdministrador pnlRegistroAdministrador) {
		this.pnlRegistroAdministrador = pnlRegistroAdministrador;
	}

	public PanelRegistroJugador getPnlRegistroJugador() {
		return pnlRegistroJugador;
	}

	public void setPnlRegistroJugador(PanelRegistroJugador pnlRegistroJugador) {
		this.pnlRegistroJugador = pnlRegistroJugador;
	}

	public PanelEquipo getPnE() {
		return pnE;
	}

	public void setPnE(PanelEquipo pnE) {
		this.pnE = pnE;
	}

	public PanelHistorial getPnH() {
		return pnH;
	}

	public void setPnH(PanelHistorial pnH) {
		this.pnH = pnH;
	}
	

}
