package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase abstracta que representa un torneo.
 */
public abstract class Torneo implements Serializable {

    /** Nombre del torneo. */
    private String nombre;

    /** Nombre del juego del torneo. */
    private String juego;

    /** Lista de equipos participantes. */
    private ArrayList<Equipo> equipos;

    /** Lista de partidas del torneo. */
    private ArrayList<Partida> partidas;

    /** Equipo ganador del torneo. */
    private Equipo ganador;

    /**
     * Constructor por defecto.
     */
    public Torneo() {
        this.equipos = new ArrayList<>();
        this.partidas = new ArrayList<>();
        this.ganador = null;
    }

    /**
     * Constructor con nombre y juego.
     *
     * @param nombre Nombre del torneo.
     * @param juego Nombre del juego del torneo.
     */
    public Torneo(String nombre, String juego) {
        this.nombre = nombre;
        this.juego = juego;
        this.ganador = null;
        this.equipos = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    /**
     * Constructor con nombre, juego y equipos.
     *
     * @param nombre Nombre del torneo.
     * @param juego Nombre del juego del torneo.
     * @param equipos Lista de equipos participantes.
     */
    public Torneo(String nombre, String juego, ArrayList<Equipo> equipos) {
        super();
        this.nombre = nombre;
        this.juego = juego;
        this.equipos = equipos;
        this.partidas = new ArrayList<>();
        this.ganador = null;
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param nombre Nombre del torneo.
     * @param juego Nombre del juego del torneo.
     * @param equipos Lista de equipos participantes.
     * @param partidas Lista de partidas del torneo.
     * @param ganador Equipo ganador del torneo.
     */
    public Torneo(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas, Equipo ganador) {
        super();
        this.nombre = nombre;
        this.juego = juego;
        this.equipos = equipos;
        this.partidas = partidas;
        this.ganador = ganador;
    }

    /**
     * Actualiza una partida en la lista de partidas.
     *
     * @param partida Partida a actualizar.
     * @return true si la partida fue actualizada, false en caso contrario.
     */
    public boolean updateMatch(Partida partida) {
        for (Partida p : partidas) {
            if (p.getId() == partida.getId()) {
                partidas.set(partidas.indexOf(p), partida);
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene el nombre del torneo.
     *
     * @return Nombre del torneo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del torneo.
     *
     * @param nombre Nombre del torneo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del juego del torneo.
     *
     * @return Nombre del juego del torneo.
     */
    public String getJuego() {
        return juego;
    }

    /**
     * Establece el nombre del juego del torneo.
     *
     * @param juego Nombre del juego del torneo.
     */
    public void setJuego(String juego) {
        this.juego = juego;
    }

    /**
     * Obtiene la lista de equipos participantes.
     *
     * @return Lista de equipos participantes.
     */
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Establece la lista de equipos participantes.
     *
     * @param equipos Lista de equipos participantes.
     */
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    /**
     * Obtiene la lista de partidas del torneo.
     *
     * @return Lista de partidas del torneo.
     */
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Establece la lista de partidas del torneo.
     *
     * @param partidas Lista de partidas del torneo.
     */
    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    /**
     * Obtiene el equipo ganador del torneo.
     *
     * @return Equipo ganador del torneo.
     */
    public Equipo getGanador() {
        return ganador;
    }

    /**
     * Establece el equipo ganador del torneo.
     *
     * @param ganador Equipo ganador del torneo.
     */
    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    /**
     * Representación en cadena del torneo.
     *
     * @return Representación en cadena del torneo.
     */
    @Override
    public String toString() {
        return "Torneo{" +
                "nombre='" + nombre + '\'' +
                ", juego='" + juego + '\'' +
                ", equipos=" + equipos +
                ", partidas=" + partidas +
                '}';
    }
}
