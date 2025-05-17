package co.edu.unbosque.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.model.persistence.DataMapper;

/**
 * Data Transfer Object para la entidad TorneoLiga.
 */
public class TorneoLigaDTO extends Torneo implements Serializable {

    /** Mapa de puntos por equipo. */
    private Map<Equipo, Integer> puntos;

    /**
     * Constructor por defecto.
     */
    public TorneoLigaDTO() {
        super();
    }

    /**
     * Constructor con nombre y juego.
     *
     * @param nombre Nombre del torneo.
     * @param juego  Juego del torneo.
     */
    public TorneoLigaDTO(String nombre, String juego) {
        super(nombre, juego);
    }

    /**
     * Constructor con nombre, juego, equipos, partidas y ganador.
     *
     * @param nombre   Nombre del torneo.
     * @param juego    Juego del torneo.
     * @param equipos  Lista de equipos.
     * @param partidas Lista de partidas.
     * @param ganador  Equipo ganador.
     */
    public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
            Equipo ganador) {
        super(nombre, juego, equipos, partidas, ganador);
    }

    /**
     * Constructor con nombre, juego y equipos.
     *
     * @param nombre  Nombre del torneo.
     * @param juego   Juego del torneo.
     * @param equipos Lista de equipos.
     */
    public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos) {
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
                    this.getPartidas().add(new Partida(e1, e2, Date.from(fechaPartido.toInstant()), juego,
                            DataMapper.torneoLigaDTOToTorneoLiga(this)));
                    fechaPartido = fechaPartido.plusDays(1);
                }
            }
        }
    }

    /**
     * Constructor con nombre, juego, equipos, partidas, ganador y puntos.
     *
     * @param nombre   Nombre del torneo.
     * @param juego    Juego del torneo.
     * @param equipos  Lista de equipos.
     * @param partidas Lista de partidas.
     * @param ganador  Equipo ganador.
     * @param puntos   Mapa de puntos por equipo.
     */
    public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
            Equipo ganador, Map<Equipo, Integer> puntos) {
        super(nombre, juego, equipos, partidas, ganador);
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "TorneoLiga{" + super.toString() + "}";
    }

    /**
     * Obtiene el mapa de puntos por equipo.
     *
     * @return Mapa de puntos.
     */
    public Map<Equipo, Integer> getPuntos() {
        return puntos;
    }

    /**
     * Establece el mapa de puntos por equipo.
     *
     * @param puntos Mapa de puntos.
     */
    public void setPuntos(Map<Equipo, Integer> puntos) {
        this.puntos = puntos;
    }
}
