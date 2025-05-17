package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;

/**
 * DAO para la gestión de jugadores en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class JugadorDAO implements OperacionDAO<JugadorDTO, Jugador> {

    /** Nombre del archivo serializado para almacenar objetos de tipo jugador. */
    private final String SERIAL_FILE_NAME = "jugador.dat";

    /** Lista de objetos de tipo jugador gestionados por este DAO. */
    private ArrayList<Jugador> listaJugadores;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public JugadorDAO() {
        listaJugadores = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Escribe la lista de jugadores en un archivo serializado.
     */
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaJugadores);
    }

    /**
     * Carga la lista de jugadores desde un archivo serializado.
     * Si el archivo no existe, inicializa una nueva lista vacía.
     */
    public void cargarSerializado() {
        listaJugadores = (ArrayList<Jugador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaJugadores == null) {
            listaJugadores = new ArrayList<>();
        }
    }

    /**
     * Muestra todos los jugadores en la lista.
     * @return Una cadena con la información de todos los jugadores.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaJugadores.isEmpty()) {
            return "No hay jugadores en la lista";
        } else {
            for (Jugador jugador : listaJugadores) {
                rta += jugador.toString() + "\n";
            }
            return rta.toString();
        }
    }

    /**
     * Obtiene todos los jugadores en formato DTO.
     * @return Una lista de objetos JugadorDTO.
     */
    @Override
    public ArrayList<JugadorDTO> getAll() {
        return DataMapper.listJugadorToListJugadorDTO(listaJugadores);
    }

    /**
     * Agrega un nuevo jugador a la lista.
     * @param newData El jugador a agregar en formato DTO.
     * @return true si el jugador fue agregado, false si ya existía.
     */
    @Override
    public boolean add(JugadorDTO newData) {
        if (find(DataMapper.jugadorDTOToJugador(newData)) == null) {
            listaJugadores.add(DataMapper.jugadorDTOToJugador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un jugador de la lista.
     * @param toDelete El jugador a eliminar en formato DTO.
     * @return true si el jugador fue eliminado, false si no se encontró.
     */
    @Override
    public boolean delete(JugadorDTO toDelete) {
        Jugador found = find(DataMapper.jugadorDTOToJugador(toDelete));
        if (found != null) {
            listaJugadores.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un jugador en la lista.
     * @param toFind El jugador a buscar.
     * @return El jugador encontrado, o null si no se encontró.
     */
    @Override
    public Jugador find(Jugador toFind) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombre().equals(toFind.getNombre())) {
                return jugador;
            }
        }
        return null;
    }

    /**
     * Actualiza la información de un jugador en la lista.
     * @param previous El jugador a actualizar en formato DTO.
     * @param newData Los nuevos datos del jugador en formato DTO.
     * @return true si el jugador fue actualizado, false si no se encontró.
     */
    @Override
    public boolean update(JugadorDTO previous, JugadorDTO newData) {
        Jugador found = find(DataMapper.jugadorDTOToJugador(previous));
        if (found != null) {
            listaJugadores.remove(found);
            listaJugadores.add(DataMapper.jugadorDTOToJugador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Organiza la lista de jugadores por su tasa de victorias.
     */
    public void organizarUsuarioPorWinRate() {
    	
    }

    /**
     * Obtiene la lista de jugadores.
     * @return La lista de jugadores.
     */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /**
     * Establece la lista de jugadores.
     * @param listaJugadores La nueva lista de jugadores.
     */
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
}
