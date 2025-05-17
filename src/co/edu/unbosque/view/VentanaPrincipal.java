package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

/**
 * Ventana principal de la aplicación NeoLeagueArena.
 * Contiene y gestiona la visibilidad de todos los paneles principales de la aplicación.
 * Permite refrescar la interfaz y acceder a cada panel mediante métodos getter y setter.
 */
public class VentanaPrincipal extends JFrame {

    /** Panel principal de la aplicación. */
    private PanelPrincipal pnP;
    /** Panel para iniciar sesión. */
    private PanelIniciarSesion pnlIniciarS;
    /** Ventana emergente para mostrar mensajes. */
    private VentanaEmergente vemer;
    /** Panel para el registro de usuarios. */
    private PanelRegistro pnlRegistro;
    /** Panel para la gestión de equipos. */
    private PanelEquipo pnE;
    /** Panel para la visualización del historial de partidas. */
    private PanelHistorial pnH;
    /** Panel para la visualización de jugadores. */
    private PanelJugador pnJD;
    /** Panel para la administración general. */
    private PanelAdministrar pAdmin;
    /** Panel para la administración de usuarios. */
    private PanelAdministrarU pAdminU;
    /** Panel para la administración de usuarios específicos. */
    private PanelAdministrarUE pAdminUE;
    /** Panel para la administración de equipos. */
    private PanelAdministrarEquipo pAdminE;
    /** Panel para la administración de partidos. */
    private PanelAdministrarPartido pAdminP;
    /** Panel para la administración de torneos. */
    private PanelAdministrarTorneo pAdminT;
    /** Panel para la visualización de torneos. */
    private PanelTorneo pTor;

    /**
     * Constructor de la ventana principal.
     * Inicializa todos los paneles y los agrega a la ventana.
     * 
     * @param prop Propiedades de configuración para cargar recursos.
     * @throws IOException Si ocurre un error al cargar imágenes o recursos.
     */
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

    /**
     * Refresca la interfaz de usuario y actualiza las propiedades de todos los paneles.
     * 
     * @param prop Propiedades de configuración actualizadas.
     * @throws IOException Si ocurre un error al actualizar imágenes o recursos.
     */
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

    /**
     * Obtiene el panel de administración de equipos.
     * @return PanelAdministrarEquipo.
     */
    public PanelAdministrarEquipo getpAdminE() {
        return pAdminE;
    }

    /**
     * Establece el panel de administración de equipos.
     * @param pAdminE PanelAdministrarEquipo a establecer.
     */
    public void setpAdminE(PanelAdministrarEquipo pAdminE) {
        this.pAdminE = pAdminE;
    }

    /**
     * Obtiene el panel de administración de partidos.
     * @return PanelAdministrarPartido.
     */
    public PanelAdministrarPartido getpAdminP() {
        return pAdminP;
    }

    /**
     * Establece el panel de administración de partidos.
     * @param pAdminP PanelAdministrarPartido a establecer.
     */
    public void setpAdminP(PanelAdministrarPartido pAdminP) {
        this.pAdminP = pAdminP;
    }

    /**
     * Obtiene el panel de administración de torneos.
     * @return PanelAdministrarTorneo.
     */
    public PanelAdministrarTorneo getpAdminT() {
        return pAdminT;
    }

    /**
     * Establece el panel de administración de torneos.
     * @param pAdminT PanelAdministrarTorneo a establecer.
     */
    public void setpAdminT(PanelAdministrarTorneo pAdminT) {
        this.pAdminT = pAdminT;
    }

    /**
     * Obtiene el panel de administración de usuarios específicos.
     * @return PanelAdministrarUE.
     */
    public PanelAdministrarUE getpAdminUE() {
        return pAdminUE;
    }

    /**
     * Establece el panel de administración de usuarios específicos.
     * @param pAdminUE PanelAdministrarUE a establecer.
     */
    public void setpAdminUE(PanelAdministrarUE pAdminUE) {
        this.pAdminUE = pAdminUE;
    }

    /**
     * Obtiene el panel de administración de usuarios.
     * @return PanelAdministrarU.
     */
    public PanelAdministrarU getpAdminU() {
        return pAdminU;
    }

    /**
     * Establece el panel de administración de usuarios.
     * @param pAdminU PanelAdministrarU a establecer.
     */
    public void setpAdminU(PanelAdministrarU pAdminU) {
        this.pAdminU = pAdminU;
    }

    /**
     * Obtiene el panel principal.
     * @return PanelPrincipal.
     */
    public PanelPrincipal getPnP() {
        return pnP;
    }

    /**
     * Establece el panel principal.
     * @param pnP PanelPrincipal a establecer.
     */
    public void setPnP(PanelPrincipal pnP) {
        this.pnP = pnP;
    }

    /**
     * Obtiene el panel de administración general.
     * @return PanelAdministrar.
     */
    public PanelAdministrar getpAdmin() {
        return pAdmin;
    }

    /**
     * Establece el panel de administración general.
     * @param pAdmin PanelAdministrar a establecer.
     */
    public void setpAdmin(PanelAdministrar pAdmin) {
        this.pAdmin = pAdmin;
    }

    /**
     * Obtiene el panel para iniciar sesión.
     * @return PanelIniciarSesion.
     */
    public PanelIniciarSesion getPnlIniciarS() {
        return pnlIniciarS;
    }

    /**
     * Establece el panel para iniciar sesión.
     * @param pnlIniciarS PanelIniciarSesion a establecer.
     */
    public void setPnlIniciarS(PanelIniciarSesion pnlIniciarS) {
        this.pnlIniciarS = pnlIniciarS;
    }

    /**
     * Obtiene la ventana emergente para mostrar mensajes.
     * @return VentanaEmergente.
     */
    public VentanaEmergente getVemer() {
        return vemer;
    }

    /**
     * Establece la ventana emergente para mostrar mensajes.
     * @param vemer VentanaEmergente a establecer.
     */
    public void setVemer(VentanaEmergente vemer) {
        this.vemer = vemer;
    }

    /**
     * Obtiene el panel de registro de usuarios.
     * @return PanelRegistro.
     */
    public PanelRegistro getPnlRegistro() {
        return pnlRegistro;
    }

    /**
     * Establece el panel de registro de usuarios.
     * @param pnlRegistro PanelRegistro a establecer.
     */
    public void setPnlRegistro(PanelRegistro pnlRegistro) {
        this.pnlRegistro = pnlRegistro;
    }

    /**
     * Obtiene el panel de equipos.
     * @return PanelEquipo.
     */
    public PanelEquipo getPnE() {
        return pnE;
    }

    /**
     * Establece el panel de equipos.
     * @param pnE PanelEquipo a establecer.
     */
    public void setPnE(PanelEquipo pnE) {
        this.pnE = pnE;
    }

    /**
     * Obtiene el panel de historial de partidas.
     * @return PanelHistorial.
     */
    public PanelHistorial getPnH() {
        return pnH;
    }

    /**
     * Establece el panel de historial de partidas.
     * @param pnH PanelHistorial a establecer.
     */
    public void setPnH(PanelHistorial pnH) {
        this.pnH = pnH;
    }

    /**
     * Obtiene el panel de jugadores.
     * @return PanelJugador.
     */
    public PanelJugador getPnJD() {
        return pnJD;
    }

    /**
     * Establece el panel de jugadores.
     * @param pnJD PanelJugador a establecer.
     */
    public void setPnJD(PanelJugador pnJD) {
        this.pnJD = pnJD;
    }

    /**
     * Obtiene el panel de torneos.
     * @return PanelTorneo.
     */
    public PanelTorneo getpTor() {
        return pTor;
    }

    /**
     * Establece el panel de torneos.
     * @param pTor PanelTorneo a establecer.
     */
    public void setpTor(PanelTorneo pTor) {
        this.pTor = pTor;
    }
    
}
