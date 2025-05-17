package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Representa un administrador del sistema.
 */
public class Administrador extends Usuario implements Serializable {

    /**
     * Constructor por defecto.
     */
    public Administrador() {
        super();
    }

    /**
     * Constructor que inicializa un administrador con nombre, contraseña y correo.
     * @param nombre Nombre del administrador.
     * @param contrasena Contraseña del administrador.
     * @param correo Correo electrónico del administrador.
     */
    public Administrador(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);
    }

    /**
     * Devuelve una representación en cadena del objeto Administrador.
     * @return una cadena que representa al administrador.
     */
    @Override
    public String toString() {
        return "Administrador{" + super.toString() + "}";
    }
}
