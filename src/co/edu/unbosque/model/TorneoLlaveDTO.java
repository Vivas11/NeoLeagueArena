package co.edu.unbosque.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

import co.edu.unbosque.model.persistence.DataMapper;

/**
 * Data Transfer Object para la entidad TorneoLlave.
 */
public class TorneoLlaveDTO extends Torneo implements Serializable {

    /** Cantidad de fases del torneo. */
    private int cantidadFase;

    /**
     * Constructor por defecto.
     */
    public TorneoLlaveDTO() {
        super();
    }

    /**
     * Constructor que inicializa el nombre y el juego del torneo.
     * 
     * @param nombre Nombre del torneo.
     * @param juego  Juego del torneo.
     */
    public TorneoLlaveDTO(String nombre, String juego) {
        super(nombre, juego);
    }

    /**
     * Constructor que inicializa la cantidad de fases del torneo.
     * 
     * @param cantidadFase Cantidad de fases del torneo.
     */
    public TorneoLlaveDTO(int cantidadFase) {
        super();
        this.cantidadFase = cantidadFase;
    }

    /**
     * Constructor que inicializa todos los atributos del torneo.
     * 
     * @param nombre      Nombre del torneo.
     * @param juego       Juego del torneo.
     * @param equipos     Lista de equipos participantes.
     * @param partidas    Lista de partidas del torneo.
     * @param ganador     Equipo ganador del torneo.
     * @param cantidadFase Cantidad de fases del torneo.
     */
    public TorneoLlaveDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
            Equipo ganador, int cantidadFase) {
        super(nombre, juego, equipos, partidas, ganador);
        this.cantidadFase = cantidadFase;
    }

    /**
     * Constructor que inicializa el nombre, el juego, los equipos y las partidas del torneo.
     * 
     * @param nombre   Nombre del torneo.
     * @param juego    Juego del torneo.
     * @param equipos  Lista de equipos participantes.
     * @param partidas Lista de partidas del torneo.
     */
    public TorneoLlaveDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
        super(nombre, juego);
        setEquipos(equipos);
        setPartidas(partidas);
    }

    /**
     * Constructor que inicializa el nombre, el juego y los equipos del torneo.
     * 
     * @param nombre  Nombre del torneo.
     * @param juego   Juego del torneo.
     * @param equipos Lista de equipos participantes.
     */
    public TorneoLlaveDTO(String nombre, String juego, ArrayList<Equipo> equipos) {
        super(nombre, juego, equipos);
    }

    /**
     * Método para crear las fases del torneo.
     * 
     * @param equipos Lista de equipos participantes.
     */
    public void crearFase(ArrayList<Equipo> equipos) {

        int cantidadFase = (int) (Math.log(equipos.size()) / Math.log(2));
        setCantidadFase(cantidadFase);

        ZonedDateTime fechaColombia = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        ZonedDateTime fechaPartido = fechaColombia.plusDays(1);

        ArrayList<Partida> partidas = new ArrayList<>();

        Collections.shuffle(equipos);

        for (int i = 0; i < equipos.size(); i += 2) {
            partidas.add(new Partida(
                equipos.get(i),
                equipos.get(i + 1),
                Date.from(fechaPartido.toInstant()),
                this.getJuego(),
                DataMapper.torneoLlaveDTOToTorneoLlave(this)
             ));
            fechaPartido = fechaPartido.plusDays(1);
        }
        setPartidas(partidas);
    }

    /**
     * Obtiene la cantidad de fases del torneo.
     * 
     * @return Cantidad de fases del torneo.
     */
    public int getCantidadFase() {
        return cantidadFase;
    }

    /**
     * Establece la cantidad de fases del torneo.
     * 
     * @param cantidadFase Cantidad de fases del torneo.
     */
    public void setCantidadFase(int cantidadFase) {
        this.cantidadFase = cantidadFase;
    }

    @Override
    public String toString() {
        return "TorneoLlave{" + super.toString() + "}";
    }
}
