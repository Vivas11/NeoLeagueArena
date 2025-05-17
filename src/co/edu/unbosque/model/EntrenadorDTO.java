package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data Transfer Object para la entidad Entrenador.
 */
public class EntrenadorDTO extends Usuario implements Serializable {

    /** País del entrenador. */
    private String pais;

    /** Ciudad del entrenador. */
    private String ciudad;

    /** Lista de equipos que entrena. */
    private ArrayList<Equipo> equipos;

    /** Ruta de la imagen del entrenador. */
    private String imagen;

    /**
     * Constructor por defecto.
     */
    public EntrenadorDTO() {
        super();
        this.equipos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros básicos.
     *
     * @param nombre Nombre del entrenador.
     * @param contrasena Contraseña del entrenador.
     * @param correo Correo del entrenador.
     * @param pais País del entrenador.
     * @param ciudad Ciudad del entrenador.
     */
    public EntrenadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros básicos y ruta de imagen.
     *
     * @param nombre Nombre del entrenador.
     * @param contrasena Contraseña del entrenador.
     * @param correo Correo del entrenador.
     * @param pais País del entrenador.
     * @param ciudad Ciudad del entrenador.
     * @param imagen Ruta de la imagen del entrenador.
     */
    public EntrenadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad, String imagen) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = new ArrayList<>();
        this.imagen = imagen;
    }

    /**
     * Constructor con país, ciudad y lista de equipos.
     *
     * @param pais País del entrenador.
     * @param ciudad Ciudad del entrenador.
     * @param equipos Lista de equipos que entrena.
     */
    public EntrenadorDTO(String pais, String ciudad, ArrayList<Equipo> equipos) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = equipos;
    }

    /**
     * Constructor con parámetros básicos y lista de equipos.
     *
     * @param nombre Nombre del entrenador.
     * @param contrasena Contraseña del entrenador.
     * @param correo Correo del entrenador.
     * @param pais País del entrenador.
     * @param ciudad Ciudad del entrenador.
     * @param equipos Lista de equipos que entrena.
     */
    public EntrenadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad,
                         ArrayList<Equipo> equipos) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = equipos;
    }

    /**
     * Constructor con parámetros básicos, lista de equipos y ruta de imagen.
     *
     * @param nombre Nombre del entrenador.
     * @param contrasena Contraseña del entrenador.
     * @param correo Correo del entrenador.
     * @param pais País del entrenador.
     * @param ciudad Ciudad del entrenador.
     * @param equipos Lista de equipos que entrena.
     * @param imagen Ruta de la imagen del entrenador.
     */
    public EntrenadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad,
                         ArrayList<Equipo> equipos, String imagen) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipos = equipos;
        this.imagen = imagen;
    }

    /**
     * Obtiene la ruta de la imagen del entrenador.
     *
     * @return Ruta de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen del entrenador.
     *
     * @param imagen Ruta de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el país del entrenador.
     *
     * @return País del entrenador.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del entrenador.
     *
     * @param pais País del entrenador.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la ciudad del entrenador.
     *
     * @return Ciudad del entrenador.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del entrenador.
     *
     * @param ciudad Ciudad del entrenador.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la lista de equipos que entrena.
     *
     * @return Lista de equipos.
     */
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Establece la lista de equipos que entrena.
     *
     * @param equipos Lista de equipos.
     */
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    /**
     * Representación en cadena del objeto Entrenador.
     *
     * @return Cadena con los datos del entrenador.
     */
    @Override
    public String toString() {
        return "Entrenador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipos=" + equipos + '}';
    }
}
