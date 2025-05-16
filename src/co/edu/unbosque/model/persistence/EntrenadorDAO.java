package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;

public class EntrenadorDAO implements OperacionDAO<EntrenadorDTO, Entrenador> {

    private final String SERIAL_FILE_NAME = "entrenador.dat";

    private ArrayList<Entrenador> listaEntrenadores;

    public EntrenadorDAO() {
        listaEntrenadores = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaEntrenadores);
    }

    public void cargarSerializado() {
        listaEntrenadores = (ArrayList<Entrenador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaEntrenadores == null) {
            listaEntrenadores = new ArrayList<>();
        }
    }

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

    @Override
    public ArrayList<EntrenadorDTO> getAll() {
        return DataMapper.listEntrenadorToListEntrenadorDTO(listaEntrenadores);
    }

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

    public ArrayList<Entrenador> getListaEntrenadores() {
        return listaEntrenadores;
    }

    public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }
}
