package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

/**
 * Fachada para la gestión de las vistas principales de la aplicación.
 * Permite acceder y modificar las ventanas principales y auxiliares.
 */
public class ViewFacade {

    /** Ventana principal de la aplicación. */
    private VentanaPrincipal vp;
    /** Ventana emergente para mostrar mensajes. */
    private VentanaEmergente vemer;
    /** Ventana para seleccionar equipos. */
    private SelectorEquipo se;

    /**
     * Constructor de la fachada de vistas.
     * Inicializa la ventana principal y la ventana emergente.
     *
     * @param prop Propiedades de configuración para la ventana principal.
     * @throws IOException Si ocurre un error al cargar recursos.
     */
    public ViewFacade(Properties prop) throws IOException {
        vp = new VentanaPrincipal(prop);
        vemer = new VentanaEmergente();
    }

    /**
     * Obtiene la ventana principal.
     * @return VentanaPrincipal de la aplicación.
     */
    public VentanaPrincipal getVp() {
        return vp;
    }

    /**
     * Establece la ventana principal.
     * @param vp VentanaPrincipal a establecer.
     */
    public void setVp(VentanaPrincipal vp) {
        this.vp = vp;
    }

    /**
     * Obtiene la ventana emergente.
     * @return VentanaEmergente utilizada para mostrar mensajes.
     */
    public VentanaEmergente getVemer() {
        return vemer;
    }

    /**
     * Establece la ventana emergente.
     * @param vemer VentanaEmergente a establecer.
     */
    public void setVemer(VentanaEmergente vemer) {
        this.vemer = vemer;
    }

    /**
     * Obtiene la ventana de selección de equipos.
     * @return SelectorEquipo actual.
     */
    public SelectorEquipo getSe() {
        return se;
    }

    /**
     * Establece la ventana de selección de equipos.
     * @param se SelectorEquipo a establecer.
     */
    public void setSe(SelectorEquipo se) {
        this.se = se;
    }
}
