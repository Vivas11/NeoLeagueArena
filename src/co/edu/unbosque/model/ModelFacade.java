package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import co.edu.unbosque.model.persistence.TorneoLigaDAO;
import co.edu.unbosque.model.persistence.TorneoLlaveDAO;

public class ModelFacade {
	
	private AdministradorDAO administradorDAO;
	private EntrenadorDAO entrenadorDAO;
	private EquipoDAO equipoDAO;
	private JugadorDAO jugadorDAO;
	private TorneoLigaDAO torneoLigaDAO;
	private TorneoLlaveDAO torneoLlaveDAO;
	private Usuario usuarioActual;
	
	public ModelFacade() {

		administradorDAO = new AdministradorDAO();
		entrenadorDAO = new EntrenadorDAO();
		equipoDAO = new EquipoDAO();
		jugadorDAO = new JugadorDAO();
		torneoLigaDAO = new TorneoLigaDAO();
		torneoLlaveDAO = new TorneoLlaveDAO();
	}
	
	public ArrayList<Torneo> obtenerTodosTorneos(){

		ArrayList<Torneo> torneos = new ArrayList<>();
		torneos.addAll(torneoLigaDAO.getListaTorneos());
		torneos.addAll(torneoLlaveDAO.getListaTorneos());
		
		for (Torneo torneo : torneos) {
//			System.out.println(torneo.getClass().getName());
		}
		return torneos;
	}
	
	public ArrayList<Partida> obtenerTodasPartidas(){

		ArrayList<Partida> partidas = new ArrayList<>();
		for (Torneo torneo : torneoLigaDAO.getListaTorneos()) {
			partidas.addAll(torneo.getPartidas());
		}
		for (Torneo torneo : torneoLlaveDAO.getListaTorneos()) {
			partidas.addAll(torneo.getPartidas());
		}
		
		for (Partida partida : partidas) {
//			System.out.println(partida.getTor().getClass().getName());
		}
		
		return partidas;
	}

	public Equipo obtenerEquipoMasVictorias() {
	    int maxVictorias = 0;
	    Equipo eq = null;
	    for (Equipo e : getEquipoDAO().getListaEquipos()) {
	    	int ganados = 0;
	        for (Partida p : e.getPartidosJugados()) {
	            if (e.equals(p.getGanador())) {
	                ganados++;
	            }
	        }
	    	
	        int victorias = ganados;
	        if (victorias > maxVictorias) {
	            maxVictorias = victorias;
	            eq = e;
	        }
	    }
	    return eq;
	}

    public Equipo equipoMayorWinrate() {
        double maxWinrate = -1;
        Equipo eq = null;
        for (Equipo e : getEquipoDAO().getListaEquipos()) {
            int jugados = e.getPartidosJugados().size();
            
            int ganados = 0;
	        for (Partida p : e.getPartidosJugados()) {
	            if (e.equals(p.getGanador())) {
	                ganados++;
	            }
	        }
	        
            if (jugados > 0) {
                double winrate = (double) ganados / jugados;
                if (winrate > maxWinrate) {
                    maxWinrate = winrate;
                    eq = e;
                }
            }
        }
        if(eq == null) {
        	eq=getEquipoDAO().getListaEquipos().getFirst();
        }
        return eq;
    }
	
	public Jugador obtenerJugadorMasVictorias() {
	    int maxVictorias = 0;
	    Jugador mejor = null;
	    for (Jugador j : getJugadorDAO().getListaJugadores()) {
	        int victorias = j.getPartidasGanadas();
	        if (victorias > maxVictorias) {
	            maxVictorias = victorias;
	            mejor = j;
	        }
	    }
	    return mejor;
	}

	public Jugador jugadorMayorWinrate() {
	    double maxWinrate = -1;
	    Jugador mejor = null;
	    for (Jugador j : getJugadorDAO().getListaJugadores()) {
	        int jugados = j.getPartidasJugadas();
	        int ganados = j.getPartidasGanadas();
	        if (jugados > 0) {
	            double winrate = (double) ganados / jugados;
	            if (winrate > maxWinrate) {
	                maxWinrate = winrate;
	                mejor = j;
	            }
	        }
	    }
	    return mejor;
	}
	
	public Torneo buscarTorneoPartida(Partida par) {
		for (Torneo tor : obtenerTodosTorneos()) {
			if(tor.getPartidas().contains(par)) {
				return tor;
			}
		}
		return null;
	}
	
	public Map<Equipo, Integer> organizarPuntosLiga(TorneoLiga liga) {
	    Map<Equipo, Integer> puntos = new java.util.HashMap<>(liga.getPuntos());
	    ArrayList<Equipo> equipos = new ArrayList<>(puntos.keySet());
	    for (int i = 0; i < equipos.size() - 1; i++)
	        for (int j = 0; j < equipos.size() - i - 1; j++)
	            if (puntos.get(equipos.get(j)) < puntos.get(equipos.get(j + 1))) {
	                Equipo tmp = equipos.get(j);
	                equipos.set(j, equipos.get(j + 1));
	                equipos.set(j + 1, tmp);
	            }
	    Map<Equipo, Integer> ordenado = new java.util.LinkedHashMap<>();
	    for (Equipo e : equipos) ordenado.put(e, puntos.get(e));
	    return ordenado;
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
			if (u.getNombre().equals(c)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean teamHasPlayer(Equipo e, Jugador u) {
		for (Jugador j : e.getJugadores()) {
			if(j.getNombre().equals(u.getNombre())) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOfJugador(Equipo e, Jugador u) {
		for (Jugador j : e.getJugadores()) {
			if(j.getNombre().equals(u.getNombre())) {
				return e.getJugadores().indexOf(j);
			}
		}
		return -1;
	}
	
	public Usuario findUser(Usuario toFind) {
		ArrayList<Usuario> usuarios = obtenerTodosUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(toFind.getNombre())) {
                return usuario;
            }
        }
        return null;
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

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
}
