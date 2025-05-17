package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;

/**
 * DAO para la gestión de torneos de eliminación directa (llave) en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class TorneoLlaveDAO implements OperacionDAO<TorneoLlaveDTO, TorneoLlave> {

    /** Nombre del archivo serializado para almacenar objetos de tipo torneo llave. */
    private final String SERIAL_FILE_NAME = "torneoLlave.dat";

    /** Lista de objetos de tipo torneo llave gestionados por este DAO. */
    private ArrayList<TorneoLlave> listaTorneos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public TorneoLlaveDAO() {
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
     * Si el archivo no existe, inicializa una nueva lista vacía.
     */
    public void cargarSerializado() {
        listaTorneos = (ArrayList<TorneoLlave>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTorneos == null) {
            listaTorneos = new ArrayList<>();
        }
    }

    /**
     * Muestra todos los torneos en la lista como una cadena de texto.
     * @return Una cadena con la información de todos los torneos o un mensaje indicando que la lista está vacía.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaTorneos.isEmpty()) {
            return "No hay torneos de llave en la lista";
        } else {
            for (TorneoLlave torneo : listaTorneos) {
                rta += torneo;
            }
            return rta;
        }
    }

    /**
     * Obtiene todos los torneos en la lista como objetos DTO.
     * @return Una lista de objetos TorneoLlaveDTO.
     */
    @Override
    public ArrayList<TorneoLlaveDTO> getAll() {
        return DataMapper.listaTorneoLlaveToListaTorneoLlaveDTO(listaTorneos);
    }

    /**
     * Agrega un nuevo torneo a la lista si no existe ya.
     * @param newData El objeto DTO del torneo a agregar.
     * @return true si el torneo fue agregado, false si ya existía.
     */
    @Override
    public boolean add(TorneoLlaveDTO newData) {
        if (find(DataMapper.torneoLlaveDTOToTorneoLlave(newData)) == null) {
            listaTorneos.add(DataMapper.torneoLlaveDTOToTorneoLlave(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un torneo de la lista si existe.
     * @param toDelete El objeto DTO del torneo a eliminar.
     * @return true si el torneo fue eliminado, false si no se encontró.
     */
    @Override
    public boolean delete(TorneoLlaveDTO toDelete) {
        TorneoLlave found = find(DataMapper.torneoLlaveDTOToTorneoLlave(toDelete));
        if (found != null) {
            listaTorneos.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un torneo en la lista por su nombre.
     * @param toFind El objeto TorneoLlave a buscar.
     * @return El objeto TorneoLlave encontrado o null si no se encontró.
     */
    @Override
    public TorneoLlave find(TorneoLlave toFind) {
        for (TorneoLlave torneo : listaTorneos) {
            if (torneo.getNombre().equals(toFind.getNombre())) {
                return torneo;
            }
        }
        return null;
    }

    /**
     * Actualiza un torneo en la lista con nuevos datos.
     * @param previous El objeto DTO del torneo a actualizar.
     * @param newData El objeto DTO con los nuevos datos del torneo.
     * @return true si el torneo fue actualizado, false si no se encontró.
     */
    @Override
    public boolean update(TorneoLlaveDTO previous, TorneoLlaveDTO newData) {
        TorneoLlave found = find(DataMapper.torneoLlaveDTOToTorneoLlave(previous));
        if (found != null) {
            listaTorneos.remove(found);
            listaTorneos.add(DataMapper.torneoLlaveDTOToTorneoLlave(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene la lista de torneos gestionados por este DAO.
     * @return La lista de objetos TorneoLlave.
     */
    public ArrayList<TorneoLlave> getListaTorneos() {
        return listaTorneos;
    }

    /**
     * Establece la lista de torneos gestionados por este DAO.
     * @param listaTorneos La nueva lista de objetos TorneoLlave.
     */
    public void setListaTorneos(ArrayList<TorneoLlave> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
}
