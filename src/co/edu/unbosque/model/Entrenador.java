package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Entrenador extends Usuario implements Serializable {
    private String pais;
    private String ciudad;
    private ArrayList<Equipo> equipos;
    private String imagen;
    
    
    public Entrenador() {
        super();
        this.equipos = new ArrayList<>();
    }

    public Entrenador(String nombre, String contrasena, String correo, String pais, String ciudad) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = new ArrayList<>();
    }
    
    public Entrenador(String nombre, String contrasena, String correo, String pais, String ciudad, String imagen) {
		super(nombre, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipos = new ArrayList<>();
		this.imagen = imagen;
	}

    public Entrenador(String pais, String ciudad, ArrayList<Equipo> equipos) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipos = equipos;
	}

    
	public Entrenador(String nombre, String contrasena, String correo, String pais, String ciudad,
			ArrayList<Equipo> equipos) {
		super(nombre, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipos = equipos;
	}

	public Entrenador(String nombre, String contrasena, String correo, String pais, String ciudad,
			ArrayList<Equipo> equipos, String imagen) {
		super(nombre, contrasena, correo);
		this.pais = pais;
		this.ciudad = ciudad;
		this.equipos = equipos;
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

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Entrenador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipos=" + equipos + '}';
    }
}
