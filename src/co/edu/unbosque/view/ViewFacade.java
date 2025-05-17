package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

public class ViewFacade {
	
	private VentanaPrincipal vp;
    /** Ventana emergente para mostrar mensajes. */
    private VentanaEmergente vemer;
    private SelectorEquipo se;
    
	public ViewFacade(Properties prop) throws IOException {
		vp = new VentanaPrincipal(prop);
        vemer = new VentanaEmergente();
	}

	public VentanaPrincipal getVp() {
		return vp;
	}

	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}

	public VentanaEmergente getVemer() {
		return vemer;
	}

	public void setVemer(VentanaEmergente vemer) {
		this.vemer = vemer;
	}

	public SelectorEquipo getSe() {
		return se;
	}

	public void setSe(SelectorEquipo se) {
		this.se = se;
	}

	
}
