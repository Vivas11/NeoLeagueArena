package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * Representa una partida entre dos equipos.
 */
public class Partida implements Serializable {

    /** Identificador único de la partida. */
    private int id;

    /** Equipo A participante. */
    private Equipo equipoA;

    /** Equipo B participante. */
    private Equipo equipoB;

    /** Puntaje del equipo A. */
    private int puntajeEquipoA;

    /** Puntaje del equipo B. */
    private int puntajeEquipoB;

    /** Equipo ganador de la partida. */
    private Equipo ganador;

    /** Fecha de la partida. */
    private Date fecha;

    /** Nombre del juego. */
    private String juego;

    /** Torneo al que pertenece la partida. */
    private Torneo tor;

    /** Fase del torneo en la que se juega la partida. */
    private int fase;

    /**
     * Conjunto para almacenar códigos generados aleatoriamente y evitar duplicados.
     */
    private HashSet<Integer> generatedCodes = new HashSet<>();

    /**
     * Constructor vacio
     */
    public Partida() {
    }

    /**
     * Constructor que inicializa una partida con los equipos, fecha, juego y torneo especificados.
     * Asigna puntajes iniciales de -1, sin ganador, y genera un identificador único para la partida.
     *
     * @param equipoA Equipo A participante en la partida.
     * @param equipoB Equipo B participante en la partida.
     * @param fecha   Fecha en la que se juega la partida.
     * @param juego   Nombre del juego de la partida.
     * @param tor     Torneo al que pertenece la partida.
     */
    public Partida(Equipo equipoA, Equipo equipoB, Date fecha, String juego, Torneo tor) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.puntajeEquipoA = -1;
        this.puntajeEquipoB = -1;
        this.ganador = null;
        this.fecha = fecha;
        this.juego = juego;
        this.id = codigoAleatorio();
        this.tor = tor;
        this.fase = 1;
    }

    /**
     * Genera un código aleatorio único en el rango de 2000 a 2999.
     * 
     * @return Código aleatorio generado.
     */
    public int codigoAleatorio() {
        int codigo;
        Random random = new Random();

        do {
            codigo = random.nextInt((5000 - 1000 + 1)) + 1000;
        } while (generatedCodes.contains(codigo));

        generatedCodes.add(codigo);
        return codigo;
    }

    /**
     * Obtiene el equipo A de la partida.
     * @return Equipo correspondiente al equipo A.
     */
    public Equipo getEquipoA() {
        return equipoA;
    }

    /**
     * Establece el equipo A de la partida.
     * @param equipoA Equipo a asignar como equipo A.
     */
    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    /**
     * Obtiene el equipo B de la partida.
     * @return Equipo correspondiente al equipo B.
     */
    public Equipo getEquipoB() {
        return equipoB;
    }

    /**
     * Establece el equipo B de la partida.
     * @param equipoB Equipo a asignar como equipo B.
     */
    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    /**
     * Obtiene el equipo ganador de la partida.
     * @return Equipo ganador.
     */
    public Equipo getGanador() {
        return ganador;
    }

    /**
     * Establece el equipo ganador de la partida.
     * @param ganador Equipo a asignar como ganador.
     */
    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    /**
     * Obtiene la fecha de la partida.
     * @return Fecha de la partida.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la partida.
     * @param fecha Fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre del juego de la partida.
     * @return Nombre del juego.
     */
    public String getJuego() {
        return juego;
    }

    /**
     * Establece el nombre del juego de la partida.
     * @param juego Nombre del juego.
     */
    public void setJuego(String juego) {
        this.juego = juego;
    }

    /**
     * Obtiene el torneo al que pertenece la partida.
     * @return Torneo de la partida.
     */
    public Torneo getTor() {
        return tor;
    }

    /**
     * Establece el torneo al que pertenece la partida.
     * @param tor Torneo a asignar.
     */
    public void setTor(Torneo tor) {
        this.tor = tor;
    }

    /**
     * Obtiene el identificador único de la partida.
     * @return Identificador de la partida.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la partida.
     * @param id Identificador a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el puntaje del equipo A.
     * @return Puntaje del equipo A.
     */
    public int getPuntajeEquipoA() {
        return puntajeEquipoA;
    }

    /**
     * Establece el puntaje del equipo A.
     * @param puntajeEquipoA Puntaje a asignar al equipo A.
     */
    public void setPuntajeEquipoA(int puntajeEquipoA) {
        this.puntajeEquipoA = puntajeEquipoA;
    }

    /**
     * Obtiene el puntaje del equipo B.
     * @return Puntaje del equipo B.
     */
    public int getPuntajeEquipoB() {
        return puntajeEquipoB;
    }

    /**
     * Establece el puntaje del equipo B.
     * @param puntajeEquipoB Puntaje a asignar al equipo B.
     */
    public void setPuntajeEquipoB(int puntajeEquipoB) {
        this.puntajeEquipoB = puntajeEquipoB;
    }

    /**
     * Obtiene la fase del torneo en la que se juega la partida.
     * @return Número de fase.
     */
    public int getFase() {
        return fase;
    }

    /**
     * Establece la fase del torneo en la que se juega la partida.
     * @param fase Número de fase.
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * Obtiene el conjunto de códigos generados para la partida.
     * @return HashSet de códigos generados.
     */
    public HashSet<Integer> getGeneratedCodes() {
        return generatedCodes;
    }

    /**
     * Establece el conjunto de códigos generados para la partida.
     * @param generatedCodes HashSet de códigos a asignar.
     */
    public void setGeneratedCodes(HashSet<Integer> generatedCodes) {
        this.generatedCodes = generatedCodes;
    }

    @Override
    public String toString() {
        return "Partida{" + "equipoA=" + equipoA + ", equipoB=" + equipoB + ", ganador=" + ganador + ", fecha=" + fecha + ", juego=" + juego + '}';
    }
}
