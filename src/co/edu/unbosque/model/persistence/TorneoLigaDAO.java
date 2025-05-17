package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.TorneoLigaDTO;

/**
 * DAO para la gestión de torneos de liga en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class TorneoLigaDAO implements OperacionDAO<TorneoLigaDTO, TorneoLiga> {

    /** Nombre del archivo serializado para almacenar objetos de tipo torneo liga. */
    private final String SERIAL_FILE_NAME = "torneoLiga.dat";

    /** Lista de objetos de tipo torneo liga gestionados por este DAO. */
    private ArrayList<TorneoLiga> listaTorneos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public TorneoLigaDAO() {
        listaTorneos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Escribe la lista de torneos en un archivo serializado.
     */
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
    }

    /**
     * Carga la lista de torneos desde un archivo serializado.
     * Si el archivo no existe, inicializa una lista vacía.
     */
    public void cargarSerializado() {
        listaTorneos = (ArrayList<TorneoLiga>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTorneos == null) {
            listaTorneos = new ArrayList<>();
        }
    }

    /**
     * Muestra todos los torneos de liga en la lista.
     * @return Una cadena con la información de todos los torneos.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaTorneos.isEmpty()) {
            return "No hay torneos de liga en la lista";
        } else {
            for (TorneoLiga torneo : listaTorneos) {
                rta += torneo;
            }
            return rta;
        }
    }

    /**
     * Obtiene todos los torneos de liga como una lista de DTOs.
     * @return Una lista de objetos TorneoLigaDTO.
     */
    @Override
    public ArrayList<TorneoLigaDTO> getAll() {
        return DataMapper.listaTorneoLigaToListaTorneoLigaDTO(listaTorneos);
    }

    /**
     * Agrega un nuevo torneo de liga a la lista.
     * @param newData El DTO del torneo a agregar.
     * @return true si se agregó correctamente, false si ya existía.
     */
    @Override
    public boolean add(TorneoLigaDTO newData) {
        if (find(DataMapper.torneoLigaDTOToTorneoLiga(newData)) == null) {
            listaTorneos.add(DataMapper.torneoLigaDTOToTorneoLiga(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un torneo de liga de la lista.
     * @param toDelete El DTO del torneo a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
    @Override
    public boolean delete(TorneoLigaDTO toDelete) {
        TorneoLiga found = find(DataMapper.torneoLigaDTOToTorneoLiga(toDelete));
        if (found != null) {
            listaTorneos.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un torneo de liga en la lista.
     * @param toFind El objeto TorneoLiga a buscar.
     * @return El objeto TorneoLiga encontrado, o null si no se encontró.
     */
    @Override
    public TorneoLiga find(TorneoLiga toFind) {
        for (TorneoLiga torneo : listaTorneos) {
            if (torneo.getNombre().equals(toFind.getNombre())) {
                return torneo;
            }
        }
        return null;
    }

    /**
     * Actualiza un torneo de liga en la lista.
     * @param previous El DTO del torneo a actualizar.
     * @param newData El nuevo DTO con los datos actualizados.
     * @return true si se actualizó correctamente, false si no se encontró.
     */
    @Override
    public boolean update(TorneoLigaDTO previous, TorneoLigaDTO newData) {
        TorneoLiga found = find(DataMapper.torneoLigaDTOToTorneoLiga(previous));
        if (found != null) {
            listaTorneos.remove(found);
            listaTorneos.add(DataMapper.torneoLigaDTOToTorneoLiga(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene la lista de torneos de liga.
     * @return La lista de objetos TorneoLiga.
     */
    public ArrayList<TorneoLiga> getListaTorneos() {
        return listaTorneos;
    }

    /**
     * Establece la lista de torneos de liga.
     * @param listaTorneos La nueva lista de objetos TorneoLiga.
     */
    public void setListaTorneos(ArrayList<TorneoLiga> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
}
