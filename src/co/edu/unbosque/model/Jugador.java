package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Representa un jugador del sistema.
 */
public class Jugador extends Usuario implements Serializable {

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
     * Constructor que inicializa un jugador con usuario, contraseña, correo, país, ciudad y equipo.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     */
    public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad, Equipo equipo) {
        super(usuario, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipo = equipo;
    }

    /**
     * Constructor que inicializa un jugador con usuario, contraseña y correo.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     */
    public Jugador(String usuario, String contrasena, String correo) {
        super(usuario, contrasena, correo);
    }

    /**
     * Constructor que inicializa un jugador con país, ciudad y equipo.
     *
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     */
    public Jugador(String pais, String ciudad, Equipo equipo) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipo = equipo;
    }

    /**
     * Constructor que inicializa un jugador con usuario, contraseña, correo, país y ciudad.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     */
    public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad) {
        super(usuario, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
    }

    /**
     * Constructor que inicializa un jugador con usuario, contraseña, correo, país, ciudad e imagen.
     *
     * @param usuario Usuario del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param imagen Ruta de la imagen del jugador.
     */
    public Jugador(String usuario, String contrasena, String correo, String pais, String ciudad, String imagen) {
        super(usuario, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.imagen = imagen;
        partidasJugadas = 0;
        partidasGanadas = 0;
    }

    /**
     * Constructor que inicializa un jugador con nombre, contraseña, correo, país, ciudad, equipo e imagen.
     *
     * @param nombre Nombre del jugador.
     * @param contrasena Contraseña del jugador.
     * @param correo Correo del jugador.
     * @param pais País del jugador.
     * @param ciudad Ciudad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     * @param imagen Ruta de la imagen del jugador.
     */
    public Jugador(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo,
                   String imagen) {
        super(nombre, contrasena, correo);
        this.pais = pais;
        this.ciudad = ciudad;
        this.equipo = equipo;
        this.imagen = imagen;
    }

    /**
     * Constructor que inicializa un jugador con nombre, contraseña, correo, país, ciudad, equipo, imagen,
     * partidas jugadas y partidas ganadas.
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
    public Jugador(String nombre, String contrasena, String correo, String pais, String ciudad, Equipo equipo,
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
     * Obtiene la ruta de la imagen del jugador.
     *
     * @return Ruta de la imagen del jugador.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen del jugador.
     *
     * @param imagen Ruta de la imagen del jugador.
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
     * @return Equipo al que pertenece el jugador.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Establece el equipo al que pertenece el jugador.
     *
     * @param equipo Equipo al que pertenece el jugador.
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Obtiene la cantidad de partidas jugadas por el jugador.
     *
     * @return Cantidad de partidas jugadas por el jugador.
     */
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Establece la cantidad de partidas jugadas por el jugador.
     *
     * @param partidasJugadas Cantidad de partidas jugadas por el jugador.
     */
    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    /**
     * Obtiene la cantidad de partidas ganadas por el jugador.
     *
     * @return Cantidad de partidas ganadas por el jugador.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece la cantidad de partidas ganadas por el jugador.
     *
     * @param partidasGanadas Cantidad de partidas ganadas por el jugador.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Representación en cadena del jugador.
     *
     * @return Cadena que representa al jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" + super.toString() + ", pais='" + pais + '\'' + ", ciudad='" + ciudad + '\'' + ", equipo="
                + equipo + '}';
    }
}
