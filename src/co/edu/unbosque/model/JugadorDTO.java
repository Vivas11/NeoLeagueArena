package co.edu.unbosque.model;

import java.io.Serializable;

public class JugadorDTO extends Usuario implements Serializable {
	private String pais;
	private String ciudad;
	private Equipo equipo;
    private String imagen;

	public JugadorDTO(String usuario, String contrasena, String correo, String pais, String ciudad,
			Equipo equipo) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}

	public JugadorDTO(String usuario, String contrasena, String correo) {
		super(usuario, contrasena, correo);
		// TODO Auto-generated constructor stub
	}

	public JugadorDTO(String pais, String ciudad, Equipo equipo) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}
	
	public JugadorDTO(String usuario, String contrasena, String correo, String pais, String ciudad) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public JugadorDTO(String usuario, String contrasena, String correo, String pais, String ciudad, String imagen) {
		super(usuario, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.imagen = imagen;
	}

	public JugadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo,
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

	@Override
	public String toString() {
		return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo="
				+ equipo + '}';
	}
}
