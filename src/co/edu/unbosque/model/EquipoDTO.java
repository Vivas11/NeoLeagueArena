package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data Transfer Object para la entidad Equipo.
 */
public class EquipoDTO implements Serializable {

    /** Nombre del equipo. */
    private String nombre;

    /** País del equipo. */
    private String pais;

    /** Lista de jugadores que pertenecen al equipo. */
    private ArrayList<Jugador> jugadores;

    /** Entrenador del equipo. */
    private Entrenador entrenador;

    /** Lista de torneos en los que ha participado el equipo. */
    private ArrayList<Torneo> torneosJugados;

    /** Lista de partidos jugados por el equipo. */
    private ArrayList<Partida> partidosJugados;

    /** Ruta de la imagen del equipo. */
    private String imagen;

    /**
     * Constructor por defecto.
     */
    public EquipoDTO() {
        this.jugadores = new ArrayList<>();
        this.torneosJugados = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param nombre Nombre del equipo.
     * @param pais País del equipo.
     * @param jugadores Lista de jugadores del equipo.
     * @param entrenador Entrenador del equipo.
     * @param torneosJugados Lista de torneos jugados por el equipo.
     * @param partidosJugados Lista de partidos jugados por el equipo.
     * @param imagen Ruta de la imagen del equipo.
     */
    public EquipoDTO(String nombre, String pais, ArrayList<Jugador> jugadores, Entrenador entrenador,
                     ArrayList<Torneo> torneosJugados, ArrayList<Partida> partidosJugados, String imagen) {
        super();
        this.nombre = nombre;
        this.pais = pais;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.torneosJugados = torneosJugados;
        this.partidosJugados = partidosJugados;
        this.imagen = imagen;
    }

    /**
     * Constructor con atributos básicos.
     *
     * @param nombre Nombre del equipo.
     * @param pais País del equipo.
     * @param imagen Ruta de la imagen del equipo.
     */
    public EquipoDTO(String nombre, String pais, String imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.entrenador = null;
        this.jugadores = new ArrayList<>();
        this.torneosJugados = new ArrayList<>();
        this.partidosJugados = new ArrayList<>();
        this.imagen = imagen;
    }

    /**
     * Obtiene el país del equipo.
     *
     * @return País del equipo.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del equipo.
     *
     * @param pais País del equipo.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la ruta de la imagen del equipo.
     *
     * @return Ruta de la imagen del equipo.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen del equipo.
     *
     * @param imagen Ruta de la imagen del equipo.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la lista de jugadores del equipo.
     *
     * @return Lista de jugadores del equipo.
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Establece la lista de jugadores del equipo.
     *
     * @param jugadores Lista de jugadores del equipo.
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Obtiene el entrenador del equipo.
     *
     * @return Entrenador del equipo.
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Establece el entrenador del equipo.
     *
     * @param entrenador Entrenador del equipo.
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return Nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     *
     * @param nombre Nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de torneos jugados por el equipo.
     *
     * @return Lista de torneos jugados por el equipo.
     */
    public ArrayList<Torneo> getTorneosJugados() {
        return torneosJugados;
    }

    /**
     * Establece la lista de torneos jugados por el equipo.
     *
     * @param torneosJugados Lista de torneos jugados por el equipo.
     */
    public void setTorneosJugados(ArrayList<Torneo> torneosJugados) {
        this.torneosJugados = torneosJugados;
    }

    /**
     * Obtiene la lista de partidos jugados por el equipo.
     *
     * @return Lista de partidos jugados por el equipo.
     */
    public ArrayList<Partida> getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * Establece la lista de partidos jugados por el equipo.
     *
     * @param partidosJugados Lista de partidos jugados por el equipo.
     */
    public void setPartidosJugados(ArrayList<Partida> partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * Representación en cadena del objeto Equipo.
     *
     * @return Cadena que representa el objeto Equipo.
     */
    @Override
    public String toString() {
        return "Equipo{" + super.toString() + ", jugadores=" + jugadores + ", entrenador=" + entrenador + ", torneosJugados=" + torneosJugados + '}';
    }
}
