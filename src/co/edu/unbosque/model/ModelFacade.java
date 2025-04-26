package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import co.edu.unbosque.model.persistence.PartidaDAO;
import co.edu.unbosque.model.persistence.TorneoDAO;

public class ModelFacade {
	
	private AdministradorDAO administradorDAO;
	private EntrenadorDAO entrenadorDAO;
	private EquipoDAO equipoDAO;
	private JugadorDAO jugadorDAO;
	private PartidaDAO partidaDAO;
	private TorneoDAO torneoDAO;
	
	public ModelFacade() {

		administradorDAO = new AdministradorDAO();
		entrenadorDAO = new EntrenadorDAO();
		equipoDAO = new EquipoDAO();
		jugadorDAO = new JugadorDAO();
		partidaDAO = new PartidaDAO();
		torneoDAO = new TorneoDAO();
	}

	public AdministradorDAO getAdministradorDAO() {
		return administradorDAO;
	}

	public void setAdministradorDAO(AdministradorDAO administradorDAO) {
		this.administradorDAO = administradorDAO;
	}

	public EntrenadorDAO getEntrenadorDAO() {
		return entrenadorDAO;
	}

	public void setEntrenadorDAO(EntrenadorDAO entrenadorDAO) {
		this.entrenadorDAO = entrenadorDAO;
	}

	public EquipoDAO getEquipoDAO() {
		return equipoDAO;
	}

	public void setEquipoDAO(EquipoDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	public JugadorDAO getJugadorDAO() {
		return jugadorDAO;
	}

	public void setJugadorDAO(JugadorDAO jugadorDAO) {
		this.jugadorDAO = jugadorDAO;
	}

	public PartidaDAO getPartidaDAO() {
		return partidaDAO;
	}

	public void setPartidaDAO(PartidaDAO partidaDAO) {
		this.partidaDAO = partidaDAO;
	}

	public TorneoDAO getTorneoDAO() {
		return torneoDAO;
	}

	public void setTorneoDAO(TorneoDAO torneoDAO) {
		this.torneoDAO = torneoDAO;
	}


}
