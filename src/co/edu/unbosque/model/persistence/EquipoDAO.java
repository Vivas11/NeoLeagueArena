package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;

/**
 * DAO para la gestión de equipos en el sistema.
 * Permite operaciones CRUD y serialización de datos.
 */
public class EquipoDAO implements OperacionDAO<EquipoDTO, Equipo> {

    /** Nombre del archivo serializado para almacenar objetos de tipo equipo. */
    private final String SERIAL_FILE_NAME = "equipo.dat";

    /** Lista de objetos de tipo equipo gestionados por este DAO. */
    private ArrayList<Equipo> listaEquipos;

    /**
     * Constructor que inicializa la lista y carga los datos serializados.
     */
    public EquipoDAO() {
        listaEquipos = new ArrayList<>();
        cargarSerializado();
    }

    /**
     * Escribe la lista de equipos en un archivo serializado.
     */
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEquipos);
    }

    /**
     * Carga la lista de equipos desde un archivo serializado.
     * Si el archivo no existe, inicializa una nueva lista vacía.
     */
    public void cargarSerializado() {
        listaEquipos = (ArrayList<Equipo>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaEquipos == null) {
            listaEquipos = new ArrayList<>();
        }
    }

    /**
     * Muestra todos los equipos en la lista.
     * @return Una cadena con la información de todos los equipos.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaEquipos.isEmpty()) {
            return "No hay equipos en la lista";
        } else {
            for (Equipo equipo : listaEquipos) {
                rta += equipo.toString() + "\n";
            }
            return rta.toString();
        }
    }

    /**
     * Obtiene todos los equipos como una lista de DTOs.
     * @return Una lista de objetos EquipoDTO.
     */
    @Override
    public ArrayList<EquipoDTO> getAll() {
        return DataMapper.listEquipoToListEquipoDTO(listaEquipos);
    }

    /**
     * Agrega un nuevo equipo a la lista.
     * @param newData El DTO del equipo a agregar.
     * @return true si el equipo fue agregado, false si ya existía.
     */
    @Override
    public boolean add(EquipoDTO newData) {
        if (find(DataMapper.equipoDTOToEquipo(newData)) == null) {
            listaEquipos.add(DataMapper.equipoDTOToEquipo(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un equipo de la lista.
     * @param toDelete El DTO del equipo a eliminar.
     * @return true si el equipo fue eliminado, false si no se encontró.
     */
    @Override
    public boolean delete(EquipoDTO toDelete) {
        Equipo found = find(DataMapper.equipoDTOToEquipo(toDelete));
        if (found != null) {
            listaEquipos.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un equipo en la lista.
     * @param toFind El equipo a buscar.
     * @return El equipo encontrado, o null si no se encontró.
     */
    @Override
    public Equipo find(Equipo toFind) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getNombre().equals(toFind.getNombre())) {
                return equipo;
            }
        }
        return null;
    }

    /**
     * Actualiza un equipo en la lista.
     * @param previous El DTO del equipo a actualizar.
     * @param newData El nuevo DTO con los datos actualizados.
     * @return true si el equipo fue actualizado, false si no se encontró.
     */
    @Override
    public boolean update(EquipoDTO previous, EquipoDTO newData) {
        Equipo found = find(DataMapper.equipoDTOToEquipo(previous));
        if (found != null) {
            listaEquipos.remove(found);
            listaEquipos.add(DataMapper.equipoDTOToEquipo(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Obtiene el equipo con más torneos jugados.
     * @return El equipo con más torneos jugados.
     */
    public Equipo obtenerEquipoMasTorneos() {
		int tor = 0;
		Equipo eq = null;
		for (Equipo e : getListaEquipos()) {
			if(e.getTorneosJugados().size() > tor) {
				tor = e.getTorneosJugados().size();
			}
		}
		return eq;
	}
	
    /**
     * Obtiene el equipo con más partidos jugados.
     * @return El equipo con más partidos jugados.
     */
	public Equipo obtenerEquipoMasPartidos() {
		int par = 0;
		Equipo eq = null;
		for (Equipo e : getListaEquipos()) {
			if(e.getPartidosJugados().size() > par) {
				par = e.getPartidosJugados().size();
				eq = e;
			}
		}
		return eq;
	}

    /**
     * Obtiene la lista de equipos gestionados por este DAO.
     * @return La lista de equipos.
     */
    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    /**
     * Establece la lista de equipos gestionados por este DAO.
     * @param listaEquipos La nueva lista de equipos.
     */
    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
}
