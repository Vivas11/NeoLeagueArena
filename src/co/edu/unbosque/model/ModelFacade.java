package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Map;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.EntrenadorDAO;
import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.JugadorDAO;
import co.edu.unbosque.model.persistence.TorneoLigaDAO;
import co.edu.unbosque.model.persistence.TorneoLlaveDAO;

/**
 * Fachada del modelo que centraliza el acceso a los DAOs y operaciones principales
 * sobre entidades como equipos, jugadores, torneos y usuarios.
 * Permite obtener información agregada y realizar búsquedas y cálculos sobre los datos.
 * 
 */
public class ModelFacade {
    
    /** DAO para la gestión de administradores */
    private AdministradorDAO administradorDAO;
    /** DAO para la gestión de entrenadores */
    private EntrenadorDAO entrenadorDAO;
    /** DAO para la gestión de equipos */
    private EquipoDAO equipoDAO;
    /** DAO para la gestión de jugadores */
    private JugadorDAO jugadorDAO;
    /** DAO para la gestión de torneos tipo liga */
    private TorneoLigaDAO torneoLigaDAO;
    /** DAO para la gestión de torneos tipo llave */
    private TorneoLlaveDAO torneoLlaveDAO;
    /** Usuario actualmente autenticado o en sesión */
    private Usuario usuarioActual;
    
    /**
     * Crea una nueva instancia de ModelFacade e inicializa los DAOs.
     */
    public ModelFacade() {
        administradorDAO = new AdministradorDAO();
        entrenadorDAO = new EntrenadorDAO();
        equipoDAO = new EquipoDAO();
        jugadorDAO = new JugadorDAO();
        torneoLigaDAO = new TorneoLigaDAO();
        torneoLlaveDAO = new TorneoLlaveDAO();
    }
    
    /**
     * Obtiene una lista con todos los torneos, tanto de liga como de llave.
     * @return Lista de todos los torneos.
     */
    public ArrayList<Torneo> obtenerTodosTorneos() {
        ArrayList<Torneo> torneos = new ArrayList<>();
        torneos.addAll(torneoLigaDAO.getListaTorneos());
        torneos.addAll(torneoLlaveDAO.getListaTorneos());
        return torneos;
    }
    
    /**
     * Obtiene una lista con todas las partidas de todos los torneos.
     * @return Lista de todas las partidas.
     */
    public ArrayList<Partida> obtenerTodasPartidas() {
        ArrayList<Partida> partidas = new ArrayList<>();
        for (Torneo torneo : torneoLigaDAO.getListaTorneos()) {
            partidas.addAll(torneo.getPartidas());
        }
        for (Torneo torneo : torneoLlaveDAO.getListaTorneos()) {
            partidas.addAll(torneo.getPartidas());
        }
        return partidas;
    }

    /**
     * Obtiene el equipo con mayor cantidad de victorias.
     * @return Equipo con más victorias, o null si no hay equipos.
     */
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

    /**
     * Obtiene el equipo con el mayor winrate (porcentaje de victorias).
     * @return Equipo con mayor winrate.
     */
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
    
    /**
     * Obtiene el jugador con más victorias.
     * @return Jugador con más victorias, o null si no hay jugadores.
     */
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

    /**
     * Obtiene el jugador con el mayor winrate (porcentaje de victorias).
     * @return Jugador con mayor winrate.
     */
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
    
    /**
     * Busca el torneo al que pertenece una partida dada.
     * @param par Partida a buscar.
     * @return Torneo que contiene la partida, o null si no se encuentra.
     */
    public Torneo buscarTorneoPartida(Partida par) {
        for (Torneo tor : obtenerTodosTorneos()) {
            if(tor.getPartidas().contains(par)) {
                return tor;
            }
        }
        return null;
    }
    
    /**
     * Organiza los equipos de un torneo de liga según sus puntos de mayor a menor.
     * @param liga Torneo de liga.
     * @return Mapa ordenado de equipos y sus puntos.
     */
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
    
    /**
     * Obtiene una lista con todos los usuarios del sistema (administradores, entrenadores y jugadores).
     * @return Lista de todos los usuarios.
     */
    public ArrayList<Usuario> obtenerTodosUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(administradorDAO.getListaAdministrador());
        usuarios.addAll(entrenadorDAO.getListaEntrenadores());
        usuarios.addAll(jugadorDAO.getListaJugadores());
        return usuarios;
    }
    
    /**
     * Verifica si existe un usuario con el nombre dado.
     * @param c Nombre a verificar.
     * @return true si el usuario existe, false en caso contrario.
     */
    public boolean usuarioRepetido(String c) {
        for (Usuario u : obtenerTodosUsuarios()) {
            if (u.getNombre().equals(c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica si un equipo contiene a un jugador específico.
     * @param e Equipo a consultar.
     * @param u Jugador a buscar.
     * @return true si el jugador pertenece al equipo, false en caso contrario.
     */
    public boolean teamHasPlayer(Equipo e, Jugador u) {
        for (Jugador j : e.getJugadores()) {
            if(j.getNombre().equals(u.getNombre())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene el índice de un jugador dentro de la lista de jugadores de un equipo.
     * @param e Equipo a consultar.
     * @param u Jugador a buscar.
     * @return Índice del jugador en el equipo, o -1 si no se encuentra.
     */
    public int indexOfJugador(Equipo e, Jugador u) {
        for (Jugador j : e.getJugadores()) {
            if(j.getNombre().equals(u.getNombre())) {
                return e.getJugadores().indexOf(j);
            }
        }
        return -1;
    }
    
    /**
     * Busca un usuario en la lista de usuarios por nombre.
     * @param toFind Usuario a buscar.
     * @return Usuario encontrado, o null si no existe.
     */
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
     * Convierte un texto plano en formato HTML, reemplazando saltos de línea por etiquetas &lt;br&gt;.
     * @param texto Texto a convertir.
     * @return Texto en formato HTML.
     */
    public String convertirAHtml(String texto) {
        String cadena = texto.replace("\n", "<br>");
        return "<html><p>" + cadena + "</p></html>";
    }
    
    /**
     * Obtiene el DAO de administradores.
     * @return AdministradorDAO.
     */
    public AdministradorDAO getAdministradorDAO() {
        return administradorDAO;
    }

    /**
     * Establece el DAO de administradores.
     * @param administradorDAO Nuevo AdministradorDAO.
     */
    public void setAdministradorDAO(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    /**
     * Obtiene el DAO de entrenadores.
     * @return EntrenadorDAO.
     */
    public EntrenadorDAO getEntrenadorDAO() {
        return entrenadorDAO;
    }

    /**
     * Establece el DAO de entrenadores.
     * @param entrenadorDAO Nuevo EntrenadorDAO.
     */
    public void setEntrenadorDAO(EntrenadorDAO entrenadorDAO) {
        this.entrenadorDAO = entrenadorDAO;
    }

    /**
     * Obtiene el DAO de equipos.
     * @return EquipoDAO.
     */
    public EquipoDAO getEquipoDAO() {
        return equipoDAO;
    }

    /**
     * Establece el DAO de equipos.
     * @param equipoDAO Nuevo EquipoDAO.
     */
    public void setEquipoDAO(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    /**
     * Obtiene el DAO de jugadores.
     * @return JugadorDAO.
     */
    public JugadorDAO getJugadorDAO() {
        return jugadorDAO;
    }

    /**
     * Establece el DAO de jugadores.
     * @param jugadorDAO Nuevo JugadorDAO.
     */
    public void setJugadorDAO(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    /**
     * Obtiene el DAO de torneos de liga.
     * @return TorneoLigaDAO.
     */
    public TorneoLigaDAO getTorneoLigaDAO() {
        return torneoLigaDAO;
    }

    /**
     * Establece el DAO de torneos de liga.
     * @param torneoLigaDAO Nuevo TorneoLigaDAO.
     */
    public void setTorneoLigaDAO(TorneoLigaDAO torneoLigaDAO) {
        this.torneoLigaDAO = torneoLigaDAO;
    }

    /**
     * Obtiene el DAO de torneos de llave.
     * @return TorneoLlaveDAO.
     */
    public TorneoLlaveDAO getTorneoLlaveDAO() {
        return torneoLlaveDAO;
    }

    /**
     * Establece el DAO de torneos de llave.
     * @param torneoLlaveDAO Nuevo TorneoLlaveDAO.
     */
    public void setTorneoLlaveDAO(TorneoLlaveDAO torneoLlaveDAO) {
        this.torneoLlaveDAO = torneoLlaveDAO;
    }

    /**
     * Obtiene el usuario actualmente autenticado.
     * @return Usuario actual.
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Establece el usuario actualmente autenticado.
     * @param usuarioActual Nuevo usuario actual.
     */
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
