package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un torneo de tipo liga.
 */
public class TorneoLiga extends Torneo implements Serializable {

    /** Mapa de puntos por equipo. */
    private Map<Equipo, Integer> puntos;

    /**
     * Constructor por defecto.
     */
    public TorneoLiga() {
        super();
    }

    /**
     * Constructor que inicializa el nombre y el juego del torneo.
     *
     * @param nombre Nombre del torneo.
     * @param juego Juego del torneo.
     */
    public TorneoLiga(String nombre, String juego) {
        super(nombre, juego);
    }

    /**
     * Constructor que inicializa el nombre, el juego, los equipos, las partidas y el ganador del torneo.
     *
     * @param nombre Nombre del torneo.
     * @param juego Juego del torneo.
     * @param equipos Lista de equipos participantes.
     * @param partidas Lista de partidas del torneo.
     * @param ganador Equipo ganador del torneo.
     */
    public TorneoLiga(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
                      Equipo ganador) {
        super(nombre, juego, equipos, partidas, ganador);
    }

    /**
     * Constructor que inicializa el nombre, el juego y los equipos del torneo.
     * También genera las partidas y asigna puntos iniciales a los equipos.
     *
     * @param nombre Nombre del torneo.
     * @param juego Juego del torneo.
     * @param equipos Lista de equipos participantes.
     */
    public TorneoLiga(String nombre, String juego, ArrayList<Equipo> equipos) {
        super(nombre, juego, equipos);
        puntos = new HashMap<>();
        for (Equipo equipo : equipos) {
            puntos.put(equipo, 0);
        }

        ZonedDateTime fechaColombia = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        ZonedDateTime fechaPartido = fechaColombia.plusDays(1);

        for (Equipo e1 : equipos) {
            for (Equipo e2 : equipos) {
                if (!e1.equals(e2)) {
                    this.getPartidas().add(new Partida(e1, e2, Date.from(fechaPartido.toInstant()), juego, this));
                    fechaPartido = fechaPartido.plusDays(1);
                }
            }
        }
    }

    /**
     * Constructor que inicializa el nombre, el juego, los equipos, las partidas, el ganador y los puntos del torneo.
     *
     * @param nombre Nombre del torneo.
     * @param juego Juego del torneo.
     * @param equipos Lista de equipos participantes.
     * @param partidas Lista de partidas del torneo.
     * @param ganador Equipo ganador del torneo.
     * @param puntos Mapa de puntos por equipo.
     */
    public TorneoLiga(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
                      Equipo ganador, Map<Equipo, Integer> puntos) {
        super(nombre, juego, equipos, partidas, ganador);
        this.puntos = puntos;
    }

    /**
     * Devuelve una representación en cadena del torneo.
     *
     * @return Representación en cadena del torneo.
     */
    @Override
    public String toString() {
        return "TorneoLiga{" + super.toString() + "}";
    }

    /**
     * Obtiene el mapa de puntos por equipo.
     *
     * @return Mapa de puntos por equipo.
     */
    public Map<Equipo, Integer> getPuntos() {
        return puntos;
    }

    /**
     * Establece el mapa de puntos por equipo.
     *
     * @param puntos Mapa de puntos por equipo.
     */
    public void setPuntos(Map<Equipo, Integer> puntos) {
        this.puntos = puntos;
    }
}
