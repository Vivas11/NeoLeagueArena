package co.edu.unbosque.model;

import java.io.Serializable;

public class JugadorDTO extends Usuario implements Serializable {
    private String nombre;
    private String pais;
    private String ciudad;
    private Equipo equipo;
    
    public JugadorDTO() {
    	
	}
    
    
    
    public JugadorDTO(String nombre, String contrasena, String correo, String nombre2, String pais, String ciudad,
			Equipo equipo) {
		super(nombre, contrasena, correo);
		nombre = nombre2;
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}



	public JugadorDTO(String nombre, String contrasena, String correo) {
		super(nombre, contrasena, correo);
		// TODO Auto-generated constructor stub
	}



	public JugadorDTO(String nombre, String pais, String ciudad, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipo = equipo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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
        return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo=" + equipo + '}';
    }
}
