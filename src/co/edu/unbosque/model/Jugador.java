package co.edu.unbosque.model;

import java.io.Serializable;

public class Jugador extends Usuario implements Serializable {
	private String pais;
	private String ciudad;
	private Equipo equipo;
    private String imagen;
    private int partidasJugadas;
    private int partidasGanadas;

	public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad,
			Equipo equipo) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}

	public Jugador(String usuario, String contrasena, String correo) {
		super(usuario, contrasena, correo);
		// TODO Auto-generated constructor stub
	}

	public Jugador(String pais, String ciudad, Equipo equipo) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}
	
	public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad, String imagen) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.imagen = imagen;
		partidasJugadas = 0;
		partidasGanadas = 0;
	}

	public Jugador(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo,
			String imagen) {
		super(nombre, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
		this.imagen = imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	
	public int getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	@Override
	public String toString() {
		return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo="
				+ equipo + '}';
	}
}
