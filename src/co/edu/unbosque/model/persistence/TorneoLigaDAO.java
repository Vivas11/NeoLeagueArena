package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.TorneoLigaDTO;

public class TorneoLigaDAO implements OperacionDAO<TorneoLigaDTO, TorneoLiga> {

    private final String SERIAL_FILE_NAME = "torneoLiga.dat";

    private ArrayList<TorneoLiga> listaTorneos;

    public TorneoLigaDAO() {
        listaTorneos = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
    }

    public void cargarSerializado() {
        listaTorneos = (ArrayList<TorneoLiga>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTorneos == null) {
            listaTorneos = new ArrayList<>();
        }
    }

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

    @Override
    public ArrayList<TorneoLigaDTO> getAll() {
        return DataMapper.listaTorneoLigaToListaTorneoLigaDTO(listaTorneos);
    }

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

    @Override
    public TorneoLiga find(TorneoLiga toFind) {
        for (TorneoLiga torneo : listaTorneos) {
            if (torneo.getNombre().equals(toFind.getNombre())) {
                return torneo;
            }
        }
        return null;
    }

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

    public ArrayList<TorneoLiga> getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(ArrayList<TorneoLiga> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
}
