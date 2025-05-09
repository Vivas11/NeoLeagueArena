package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EquipoDTO implements Serializable {
	private String nombre;
    private ArrayList<Jugador> jugadores;
    private Entrenador entrenador;
    private ArrayList<Torneo> torneosJugados;
	private ArrayList<Partida> partidosJugados;

    public EquipoDTO() {
        this.jugadores = new ArrayList<>();
        this.torneosJugados = new ArrayList<>();
    }

    public EquipoDTO(String nombre, Entrenador entrenador) {
    	this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
        this.torneosJugados = new ArrayList<>();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Torneo> getTorneosJugados() {
        return torneosJugados;
    }

    public void setTorneosJugados(ArrayList<Torneo> torneosJugados) {
        this.torneosJugados = torneosJugados;
    }

	public ArrayList<Partida> getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(ArrayList<Partida> partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    @Override
    public String toString() {
        return "Equipo{" + super.toString() + ", jugadores=" + jugadores + ", entrenador=" + entrenador + ", torneosJugados=" + torneosJugados + '}';
    }
}
