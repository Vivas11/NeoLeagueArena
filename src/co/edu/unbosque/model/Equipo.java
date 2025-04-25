package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo extends Usuario implements Serializable{
	private ArrayList<Jugador> jugadores;
	private Entrenador entrenador;
}
