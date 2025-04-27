package co.edu.unbosque.model;

import java.io.Serializable;

public class AdministradorDTO extends Usuario implements Serializable {

    public AdministradorDTO() {
        super();
    }

    public AdministradorDTO(String nombre, String contrasena, String correo) {
        super(nombre, contrasena, correo);
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() + "}";
    }
}