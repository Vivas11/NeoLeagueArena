package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

/**
 * DAO para la gestión de administradores en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class AdministradorDAO implements OperacionDAO<AdministradorDTO, Administrador> {

    /** Nombre del archivo serializado para almacenar objetos de tipo administrador. */
    private final String SERIAL_FILE_NAME = "administrador.dat";

    /** Nombre del archivo de texto para almacenar objetos de tipo administrador en formato CSV. */
    private final String TEXT_FILE_NAME = "administrador.csv";

    /** Lista de objetos de tipo administrador gestionados por este DAO. */
    private ArrayList<Administrador> listaAdministrador;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public AdministradorDAO() {
        listaAdministrador = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Escribe la lista de administradores en un archivo serializado.
     */
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaAdministrador);
    }

    /**
     * Carga la lista de administradores desde un archivo serializado.
     * Si el archivo no existe, inicializa una nueva lista vacía.
     */
    public void cargarSerializado() {
        listaAdministrador = (ArrayList<Administrador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaAdministrador == null) {
            listaAdministrador = new ArrayList<>(); 
        }
    }
    
    /**
     * Muestra todos los administradores en la lista.
     * @return Una cadena con la información de todos los administradores.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaAdministrador.isEmpty()) {
            return "No hay admins en la lista";
        } else {
            for (Administrador administrador : listaAdministrador) {
                rta += administrador;
            }
            return rta;
        }
    }

    /**
     * Obtiene todos los administradores como una lista de DTOs.
     * @return Una lista de AdministradorDTO.
     */
    @Override
    public ArrayList<AdministradorDTO> getAll() {
        return DataMapper.listAdministradorToListAdministradorDTO(listaAdministrador);
    }

    /**
     * Agrega un nuevo administrador a la lista.
     * @param newData El DTO del administrador a agregar.
     * @return true si se agregó correctamente, false si ya existía.
     */
    @Override
    public boolean add(AdministradorDTO newData) {
        if (find(DataMapper.administradorDTOToAdministrador(newData)) == null) {
            listaAdministrador.add(DataMapper.administradorDTOToAdministrador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un administrador de la lista.
     * @param toDelete El DTO del administrador a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
    @Override
    public boolean delete(AdministradorDTO toDelete) {
        Administrador found = find(DataMapper.administradorDTOToAdministrador(toDelete));
        if (found != null) {
            listaAdministrador.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un administrador en la lista.
     * @param toFind El administrador a buscar.
     * @return El administrador encontrado, o null si no se encontró.
     */
    @Override
    public Administrador find(Administrador toFind) {
        Administrador found = null;
        if (!listaAdministrador.isEmpty()) {
            for (Administrador administrador : listaAdministrador) {
                if (administrador.getNombre().equals(toFind.getNombre())) {
                    found = administrador;
                    return found;
                } else {
                    continue;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * Actualiza un administrador en la lista.
     * @param previous El DTO del administrador a actualizar.
     * @param newData El nuevo DTO con los datos actualizados.
     * @return true si se actualizó correctamente, false si no se encontró.
     */
    @Override
    public boolean update(AdministradorDTO previous, AdministradorDTO newData) {
        Administrador found = find(DataMapper.administradorDTOToAdministrador(previous));
        if (found != null) {
            listaAdministrador.remove(found);
            listaAdministrador.add(DataMapper.administradorDTOToAdministrador(newData));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene la lista de administradores.
     * @return La lista de administradores.
     */
    public ArrayList<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    /**
     * Establece la lista de administradores.
     * @param listaAdministrador La nueva lista de administradores.
     */
    public void setListaAdministrador(ArrayList<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }
}
