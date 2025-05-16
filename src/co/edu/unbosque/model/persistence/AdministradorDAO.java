package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;

public class AdministradorDAO implements OperacionDAO<AdministradorDTO, Administrador> {

	/**
	 * Nombre del archivo serializado para almacenar objetos de tipo administrador.
	 */
	private final String SERIAL_FILE_NAME = "administrador.dat";

	/**
	 * Nombre del archivo de texto para almacenar objetos de tipo administrador en
	 * formato CSV.
	 */
	private final String TEXT_FILE_NAME = "administrador.csv";

	/**
	 * Lista de objetos de tipo administrador gestionados por este DAO.
	 */
	private ArrayList<Administrador> listaAdministrador;

	public AdministradorDAO() {
		listaAdministrador = new ArrayList<>();
		cargarSerializado();
	}
    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaAdministrador);
    }

    public void cargarSerializado() {
        listaAdministrador = (ArrayList<Administrador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaAdministrador == null) {
            listaAdministrador = new ArrayList<>(); 
        }
    }
    
	@Override
	public String showAll() {
		String rta = "";
		if (listaAdministrador.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (Administrador administrador : listaAdministrador) {
				rta += administrador;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<AdministradorDTO> getAll() {
		return DataMapper.listAdministradorToListAdministradorDTO(listaAdministrador);

	}

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
	public ArrayList<Administrador> getListaAdministrador() {
		return listaAdministrador;
	}

	public void setListaAdministrador(ArrayList<Administrador> listaAdministrador) {
		this.listaAdministrador = listaAdministrador;
	}
}
