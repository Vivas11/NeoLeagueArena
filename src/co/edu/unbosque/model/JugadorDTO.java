package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Data Transfer Object para la entidad Jugador.
 */
public class JugadorDTO extends Usuario implements Serializable {

    /** País del jugador. */
    private String pais;

    /** Ciudad del jugador. */
    private String ciudad;

    /** Equipo al que pertenece el jugador. */
    private Equipo equipo;

    /** Ruta de la imagen del jugador. */
    private String imagen;

    /** Cantidad de partidas jugadas por el jugador. */
    private int partidasJugadas;

    /** Cantidad de partidas ganadas por el jugador. */
    private int partidasGanadas;

    /**
     * Constructor con todos los atributos.
     *
     * @param nombre Nombre del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     * @param imagen Ruta de la imagen del jugador.
     * @param partidasJugadas Cantidad de partidas jugadas por el jugador.
     * @param partidasGanadas Cantidad de partidas ganadas por el jugador.
     */
    public JugadorDTO(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo,
                      String imagen, int partidasJugadas, int partidasGanadas) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipo = equipo;
        this.imagen = imagen;
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Constructor con atributos básicos.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     */
    public JugadorDTO(String usuario, String contrasena, String correo) {
        super(usuario, contrasena, correo);
    }

    /**
     * Constructor con atributos de ubicación y equipo.
     *
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     */
    public JugadorDTO(String pais, String ciudad, Equipo equipo) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipo = equipo;
    }

    /**
     * Constructor con atributos de usuario y ubicación.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     */
    public JugadorDTO(String usuario, String contrasena, String correo, String pais, String ciudad) {
        super(usuario, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
    }

    /**
     * Constructor con atributos de usuario, ubicación e imagen.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param imagen Ruta de la imagen del jugador.
     */
    public JugadorDTO(String usuario, String contrasena, String correo, String pais, String ciudad, String imagen) {
        super(usuario, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.imagen = imagen;
    }

    /**
     * Obtiene la ruta de la imagen del jugador.
     *
     * @return Ruta de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen del jugador.
     *
     * @param imagen Ruta de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el país del jugador.
     *
     * @return País del jugador.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del jugador.
     *
     * @param pais País del jugador.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la ciudad del jugador.
     *
     * @return Ciudad del jugador.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del jugador.
     *
     * @param ciudad Ciudad del jugador.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el equipo al que pertenece el jugador.
     *
     * @return Equipo del jugador.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Establece el equipo al que pertenece el jugador.
     *
     * @param equipo Equipo del jugador.
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Obtiene la cantidad de partidas jugadas por el jugador.
     *
     * @return Cantidad de partidas jugadas.
     */
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Establece la cantidad de partidas jugadas por el jugador.
     *
     * @param partidasJugadas Cantidad de partidas jugadas.
     */
    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    /**
     * Obtiene la cantidad de partidas ganadas por el jugador.
     *
     * @return Cantidad de partidas ganadas.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece la cantidad de partidas ganadas por el jugador.
     *
     * @param partidasGanadas Cantidad de partidas ganadas.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Representación en cadena del objeto Jugador.
     *
     * @return Cadena con los atributos del jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo="
                + equipo + '}';
    }
}
