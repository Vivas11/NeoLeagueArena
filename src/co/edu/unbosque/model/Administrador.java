package co.edu.unbosque.model;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    public Administrador() {
        super();
    }

    public Administrador(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() + "}";
    }
}
