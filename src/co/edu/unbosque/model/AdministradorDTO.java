package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Data Transfer Object para la entidad Administrador.
 */
public class AdministradorDTO extends Usuario implements Serializable {

    /**
     * Constructor por defecto.
     */
    public AdministradorDTO() {
        super();
    }

    /**
     * Constructor que inicializa un administrador con nombre, contraseña y correo.
     * @param nombre Nombre del administrador.
     * @param contrasena Contraseña del administrador.
     * @param correo Correo electrónico del administrador.
     */
    public AdministradorDTO(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);
    }

    /**
     * Devuelve una representación en cadena del objeto AdministradorDTO.
     * @return una cadena que representa al administrador.
     */
    @Override
    public String toString() {
        return "Administrador{" + super.toString() + "}";
    }
}