package co.edu.unbosque.model;

import java.io.Serializable;
import java.sql.Date;

public class PartidaDTO implements Serializable {
    private Equipo equipoA;
    private Equipo equipoB;
    private Equipo ganador;
    private Date fecha;
    private String juego;

    public PartidaDTO() {
    }

    public PartidaDTO(Equipo equipoA, Equipo equipoB, Equipo ganador, Date fecha, String juego) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.ganador = ganador;
        this.fecha = fecha;
        this.juego = juego;
    }

    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    @Override
    public String toString() {
        return "PartidaDTO{" + "equipoA='" + equipoA + '\'' + ", equipoB='" + equipoB + '\'' + ", ganador='" + ganador + '\'' + ", fecha=" + fecha + ", juego='" + juego + '\'' + '}';
    }
}
