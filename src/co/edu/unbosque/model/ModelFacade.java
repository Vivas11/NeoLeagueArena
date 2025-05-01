package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import co.edu.unbosque.model.persistence.PartidaDAO;
import co.edu.unbosque.model.persistence.TorneoCompletoDAO;
import co.edu.unbosque.model.persistence.TorneoLigaDAO;
import co.edu.unbosque.model.persistence.TorneoLlaveDAO;

public class ModelFacade {
	
	private AdministradorDAO administradorDAO;
	private EntrenadorDAO entrenadorDAO;
	private EquipoDAO equipoDAO;
	private JugadorDAO jugadorDAO;
	private PartidaDAO partidaDAO;
	private TorneoCompletoDAO torneoCompletoDAO;
	private TorneoLigaDAO torneoLigaDAO;
	private TorneoLlaveDAO torneoLlaveDAO;
	
	public ModelFacade() {

		administradorDAO = new AdministradorDAO();
		entrenadorDAO = new EntrenadorDAO();
		equipoDAO = new EquipoDAO();
		jugadorDAO = new JugadorDAO();
		partidaDAO = new PartidaDAO();
		torneoCompletoDAO = new TorneoCompletoDAO();
		torneoLigaDAO = new TorneoLigaDAO();
		torneoLlaveDAO = new TorneoLlaveDAO();
	}
	
	public ArrayList<Usuario> obtenerTodosUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.addAll(administradorDAO.getListaAdministrador());
		usuarios.addAll(entrenadorDAO.getListaEntrenadores());
		usuarios.addAll(jugadorDAO.getListaJugadores());
		return usuarios;
	}
	
	public boolean usuarioRepetido(String c) {
		for (Usuario u : obtenerTodosUsuarios()) {
			System.out.println(u.toString());
			if (u.getNombre().equals(c)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Convierte un texto en formato HTML.
	 * 
	 * @param texto Texto a convertir.
	 * @return Texto en formato HTML.
	 */
	public String convertirAHtml(String texto) {
		String cadena = texto.replace("\n", "<br>");
		return "<html><p>" + cadena + "</p></html>";
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

	public TorneoCompletoDAO getTorneoCompletoDAO() {
		return torneoCompletoDAO;
	}

	public void setTorneoCompletoDAO(TorneoCompletoDAO torneoCompletoDAO) {
		this.torneoCompletoDAO = torneoCompletoDAO;
	}

	public TorneoLigaDAO getTorneoLigaDAO() {
		return torneoLigaDAO;
	}

	public void setTorneoLigaDAO(TorneoLigaDAO torneoLigaDAO) {
		this.torneoLigaDAO = torneoLigaDAO;
	}

	public TorneoLlaveDAO getTorneoLlaveDAO() {
		return torneoLlaveDAO;
	}

	public void setTorneoLlaveDAO(TorneoLlaveDAO torneoLlaveDAO) {
		this.torneoLlaveDAO = torneoLlaveDAO;
	}
	
	

}
