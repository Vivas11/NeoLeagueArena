package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Torneo implements Serializable{
	private String nombre;
	private String juego;
	private ArrayList<Equipo> equipos;
	private ArrayList<Partida> partidas;
}
