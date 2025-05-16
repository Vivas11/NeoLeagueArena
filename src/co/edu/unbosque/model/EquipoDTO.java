package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EquipoDTO implements Serializable {
	private String nombre;
	private String pais;
	private ArrayList<Jugador> jugadores;
	private Entrenador entrenador;
	private ArrayList<Torneo> torneosJugados;
	private ArrayList<Partida> partidosJugados;
	private String imagen;

	public EquipoDTO() {
		this.jugadores = new ArrayList<>();
		this.torneosJugados = new ArrayList<>();
	}
	
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

	public EquipoDTO(String nombre, String pais, String imagen) {
		this.nombre = nombre;
		this.pais = pais;
		this.entrenador = null;
		this.jugadores = new ArrayList<>();
		this.torneosJugados = new ArrayList<>();
		this.partidosJugados = new ArrayList<>();
		this.imagen = imagen;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
