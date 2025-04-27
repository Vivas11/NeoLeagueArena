package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Torneo implements Serializable {
    private String nombre;
    private String juego;
    private ArrayList<Equipo> equipos;
    private ArrayList<Partida> partidas;

    public Torneo() {
        this.equipos = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public Torneo(String nombre, String juego) {
        this.nombre = nombre;
        this.juego = juego;
        this.equipos = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombre='" + nombre + '\'' + ", juego='" + juego + '\'' + ", equipos=" + equipos + ", partidas=" + partidas + '}';
    }
}
