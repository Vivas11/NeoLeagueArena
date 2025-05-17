package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;

/**
 * DAO para la gestión de entrenadores en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class EntrenadorDAO implements OperacionDAO<EntrenadorDTO, Entrenador> {

    /** Nombre del archivo serializado para almacenar objetos de tipo entrenador. */
    private final String SERIAL_FILE_NAME = "entrenador.dat";

    /** Lista de objetos de tipo entrenador gestionados por este DAO. */
    private ArrayList<Entrenador> listaEntrenadores;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public EntrenadorDAO() {
        listaEntrenadores = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Escribe la lista de entrenadores en un archivo serializado.
     */
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEntrenadores);
    }

    /**
     * Carga la lista de entrenadores desde un archivo serializado.
     * Si el archivo no existe, inicializa una nueva lista vacía.
     */
    public void cargarSerializado() {
        listaEntrenadores = (ArrayList<Entrenador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaEntrenadores == null) {
            listaEntrenadores = new ArrayList<>();
        }
    }

    /**
     * Muestra todos los entrenadores en la lista.
     * @return Una cadena con la información de todos los entrenadores.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaEntrenadores.isEmpty()) {
            return "No hay entrenadores en la lista";
        } else {
            for (Entrenador entrenador : listaEntrenadores) {
                rta += entrenador;
            }
            return rta;
        }
    }

    /**
     * Obtiene una lista de objetos EntrenadorDTO a partir de la lista de entrenadores.
     * @return Lista de EntrenadorDTO.
     */
    @Override
    public ArrayList<EntrenadorDTO> getAll() {
        return DataMapper.listEntrenadorToListEntrenadorDTO(listaEntrenadores);
    }

    /**
     * Agrega un nuevo entrenador a la lista.
     * @param newData Datos del nuevo entrenador.
     * @return true si se agregó correctamente, false si ya existía.
     */
    @Override
    public boolean add(EntrenadorDTO newData) {
        if (find(DataMapper.entrenadorDTOToEntrenador(newData)) == null) {
            listaEntrenadores.add(DataMapper.entrenadorDTOToEntrenador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un entrenador de la lista.
     * @param toDelete Datos del entrenador a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
    @Override
    public boolean delete(EntrenadorDTO toDelete) {
        Entrenador found = find(DataMapper.entrenadorDTOToEntrenador(toDelete));
        if (found != null) {
            listaEntrenadores.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un entrenador en la lista.
     * @param toFind Entrenador a buscar.
     * @return El entrenador encontrado, o null si no se encuentra.
     */
    @Override
    public Entrenador find(Entrenador toFind) {
        if (toFind == null) {
            System.out.println("aadsad");
            return null;
        }
        for (Entrenador entrenador : listaEntrenadores) {
            if (entrenador.getNombre().equals(toFind.getNombre())) {
                return entrenador;
            }
        }
        return null; // Si no se encuentra, retorna null
    }

    /**
     * Actualiza los datos de un entrenador en la lista.
     * @param previous Datos anteriores del entrenador.
     * @param newData Nuevos datos del entrenador.
     * @return true si se actualizó correctamente, false si no se encontró.
     */
    @Override
    public boolean update(EntrenadorDTO previous, EntrenadorDTO newData) {
        Entrenador found = find(DataMapper.entrenadorDTOToEntrenador(previous));
        if (found != null) {
            listaEntrenadores.remove(found);
            listaEntrenadores.add(DataMapper.entrenadorDTOToEntrenador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene la lista de entrenadores.
     * @return Lista de entrenadores.
     */
    public ArrayList<Entrenador> getListaEntrenadores() {
        return listaEntrenadores;
    }

    /**
     * Establece la lista de entrenadores.
     * @param listaEntrenadores Nueva lista de entrenadores.
     */
    public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }
}
