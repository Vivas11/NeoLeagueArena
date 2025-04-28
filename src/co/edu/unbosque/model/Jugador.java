package co.edu.unbosque.model;

import java.io.Serializable;

public class Jugador extends Usuario implements Serializable {
	private String pais;
	private String ciudad;
	private Equipo equipo;

	public Jugador() {

	}

	public Jugador(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo) {
		super(nombre, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}

	public Jugador(String nombre, String contrasena, String correo) {
		super(nombre, contrasena, correo);
		// TODO Auto-generated constructor stub
	}

	public Jugador(String pais, String ciudad, Equipo equipo) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo="
				+ equipo + '}';
	}
}
