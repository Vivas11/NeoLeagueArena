package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private PanelPrincipal pnP;
	private PanelIniciarSesion pnlIniciarS;
	private VentanaEmergente vemer;
	private PanelRegistro pnlRegistro;
	private PanelEquipo pnE;
	private PanelHistorial pnH;
	private PanelJugador pnJD;
	private PanelAdministrar pAdmin;
	private PanelAdministrarU pAdminU;
	private PanelAdministrarUE pAdminUE;
	private PanelAdministrarEquipo pAdminE;
	private PanelAdministrarPartido pAdminP;
	private PanelAdministrarTorneo pAdminT;
	private PanelTorneo pTor;

	public VentanaPrincipal(Properties prop) throws IOException {
		pnlRegistro = new PanelRegistro(prop);
		pnP = new PanelPrincipal(prop);
		pnlIniciarS = new PanelIniciarSesion(prop);
		pnE = new PanelEquipo(prop);
		pnH = new PanelHistorial(prop);
		pnJD = new PanelJugador(prop);
		pAdmin = new PanelAdministrar(prop);
		pAdminU = new PanelAdministrarU(prop);
		pAdminUE = new PanelAdministrarUE(prop);
		pAdminT = new PanelAdministrarTorneo(prop);
		pAdminE = new PanelAdministrarEquipo(prop);
		pAdminP = new PanelAdministrarPartido(prop);
		pTor = new PanelTorneo(prop);

		setBounds(300, 150, 1280, 720);
		setTitle("Neo League Arena");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);
		setResizable(false);

		pnP.setVisible(true);
		pnlIniciarS.setVisible(false);
		pnlRegistro.setVisible(false);
		pnE.setVisible(false);
		pnH.setVisible(false);
		pnJD.setVisible(false);
		pAdmin.setVisible(false);
		pAdminU.setVisible(false);
		pAdminUE.setVisible(false);
		pAdminT.setVisible(false);
		pAdminE.setVisible(false);
		pAdminP.setVisible(false);
		pTor.setVisible(false);

		add(pnP);
		add(pnlIniciarS);
		add(pnlRegistro);
		add(pnE);
		add(pnH);
		add(pnJD);
		add(pAdmin);
		add(pAdminU);
		add(pAdminUE);
		add(pAdminT);
		add(pAdminE);
		add(pAdminP);
		add(pTor);

	}

	public void refrescarUI(Properties prop) throws IOException {
		pnlRegistro.setProp(prop);
		pnP.setProp(prop);
		pnlIniciarS.setProp(prop);
		pnE.setProp(prop);
		pnH.setProp(prop);
		pnJD.setProp(prop);
		pAdmin.setProp(prop);
		pAdminU.setProp(prop);
		pAdminUE.setProp(prop);
		pAdminT.setProp(prop);
		pAdminE.setProp(prop);
		pAdminP.setProp(prop);
		pTor.setProp(prop);

		pnlRegistro.actualizarComp();
		pnP.actualizarComp();
		pnlIniciarS.actualizarComp();
		pnE.actualizarComp();
		pnH.actualizarComp();
		pnJD.actualizarComp();
		pAdmin.actualizarComp();
		pAdminU.actualizarComp();
		pAdminUE.actualizarComp();
		pAdminT.actualizarComp();
		pAdminE.actualizarComp();
		pAdminP.actualizarComp();
		pTor.actualizarComp();
		
		pnlRegistro.revalidate();
		pnP.revalidate();
		pnlIniciarS.revalidate();
		pnE.revalidate();
		pnH.revalidate();
		pnJD.revalidate();
		pAdmin.revalidate();
		pAdminU.revalidate();
		pAdminUE.revalidate();
		pAdminT.revalidate();
		pAdminE.revalidate();
		pAdminP.revalidate();
		pTor.revalidate();

		pnlRegistro.repaint();
		pnP.repaint();
		pnlIniciarS.repaint();
		pnE.repaint();
		pnH.repaint();
		pnJD.repaint();
		pAdmin.repaint();
		pAdminU.repaint();
		pAdminUE.repaint();
		pAdminT.repaint();
		pAdminE.repaint();
		pAdminP.repaint();
		pTor.repaint();

		this.revalidate();
		this.repaint();
	}


	public PanelAdministrarEquipo getpAdminE() {
		return pAdminE;
	}

	public void setpAdminE(PanelAdministrarEquipo pAdminE) {
		this.pAdminE = pAdminE;
	}

	public PanelAdministrarPartido getpAdminP() {
		return pAdminP;
	}

	public void setpAdminP(PanelAdministrarPartido pAdminP) {
		this.pAdminP = pAdminP;
	}

	public PanelAdministrarTorneo getpAdminT() {
		return pAdminT;
	}

	public void setpAdminT(PanelAdministrarTorneo pAdminT) {
		this.pAdminT = pAdminT;
	}

	public PanelAdministrarUE getpAdminUE() {
		return pAdminUE;
	}

	public void setpAdminUE(PanelAdministrarUE pAdminUE) {
		this.pAdminUE = pAdminUE;
	}

	public PanelAdministrarU getpAdminU() {
		return pAdminU;
	}

	public void setpAdminU(PanelAdministrarU pAdminU) {
		this.pAdminU = pAdminU;
	}

	public PanelPrincipal getPnP() {
		return pnP;
	}

	public void setPnP(PanelPrincipal pnP) {
		this.pnP = pnP;
	}

	public PanelAdministrar getpAdmin() {
		return pAdmin;
	}

	public void setpAdmin(PanelAdministrar pAdmin) {
		this.pAdmin = pAdmin;
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

	public PanelRegistro getPnlRegistro() {
		return pnlRegistro;
	}

	public void setPnlRegistro(PanelRegistro pnlRegistro) {
		this.pnlRegistro = pnlRegistro;
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

	public PanelJugador getPnJD() {
		return pnJD;
	}

	public void setPnJD(PanelJugador pnJD) {
		this.pnJD = pnJD;
	}

	public PanelTorneo getpTor() {
		return pTor;
	}

	public void setpTor(PanelTorneo pTor) {
		this.pTor = pTor;
	}
	
}
