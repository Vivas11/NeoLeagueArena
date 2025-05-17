package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;

public class EquipoDAO implements OperacionDAO<EquipoDTO, Equipo> {

    private final String SERIAL_FILE_NAME = "equipo.dat";

    private ArrayList<Equipo> listaEquipos;

    public EquipoDAO() {
        listaEquipos = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEquipos);
    }

    public void cargarSerializado() {
        listaEquipos = (ArrayList<Equipo>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaEquipos == null) {
            listaEquipos = new ArrayList<>();
        }
    }

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

    @Override
    public ArrayList<EquipoDTO> getAll() {
        return DataMapper.listEquipoToListEquipoDTO(listaEquipos);
    }

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

    @Override
    public Equipo find(Equipo toFind) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getNombre().equals(toFind.getNombre())) {
                return equipo;
            }
        }
        return null;
    }

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

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
}
