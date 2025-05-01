package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;

public class PartidaDAO implements OperacionDAO<PartidaDTO, Partida> {

    private final String SERIAL_FILE_NAME = "partida.dat";

    private ArrayList<Partida> listaPartidas;

    public PartidaDAO() {
        listaPartidas = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPartidas);
    }

    public void cargarSerializado() {
        listaPartidas = (ArrayList<Partida>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaPartidas == null) {
            listaPartidas = new ArrayList<>();
        }
    }

    @Override
    public String showAll() {
        String rta = "";
        if (listaPartidas.isEmpty()) {
            return "No hay partidas en la lista";
        } else {
            for (Partida partida : listaPartidas) {
                rta += partida;
            }
            return rta;
        }
    }

    @Override
    public ArrayList<PartidaDTO> getAll() {
        return DataMapper.listPartidaToListPartidaDTO(listaPartidas);
    }

    @Override
    public boolean add(PartidaDTO newData) {
        if (find(DataMapper.partidaDTOToPartida(newData)) == null) {
            listaPartidas.add(DataMapper.partidaDTOToPartida(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(PartidaDTO toDelete) {
        Partida found = find(DataMapper.partidaDTOToPartida(toDelete));
        if (found != null) {
            listaPartidas.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Partida find(Partida toFind) {
        Partida found = null;
        if (!listaPartidas.isEmpty()) {
            for (Partida partida : listaPartidas) {
                if (partida.getId() == toFind.getId()) {
                    found = partida;
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
    public boolean update(PartidaDTO previous, PartidaDTO newData) {
        Partida found = find(DataMapper.partidaDTOToPartida(previous));
        if (found != null) {
            listaPartidas.remove(found);
            listaPartidas.add(DataMapper.partidaDTOToPartida(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Partida> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(ArrayList<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }
}
