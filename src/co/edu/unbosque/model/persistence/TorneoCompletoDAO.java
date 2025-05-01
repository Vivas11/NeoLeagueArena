package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TorneoCompleto;
import co.edu.unbosque.model.TorneoCompletoDTO;

public class TorneoCompletoDAO implements OperacionDAO<TorneoCompletoDTO, TorneoCompleto> {

    private final String SERIAL_FILE_NAME = "torneoCompleto.dat";

    private ArrayList<TorneoCompleto> listaTorneos;

    public TorneoCompletoDAO() {
        listaTorneos = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
    }

    public void cargarSerializado() {
        listaTorneos = (ArrayList<TorneoCompleto>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTorneos == null) {
            listaTorneos = new ArrayList<>();
        }
    }

    @Override
    public String showAll() {
        String rta = "";
        if (listaTorneos.isEmpty()) {
            return "No hay torneos completos en la lista";
        } else {
            for (TorneoCompleto torneo : listaTorneos) {
                rta += torneo;
            }
            return rta;
        }
    }

    @Override
    public ArrayList<TorneoCompletoDTO> getAll() {
        return DataMapper.listaTorneoCompletoToListaTorneoCompletoDTO(listaTorneos);
    }

    @Override
    public boolean add(TorneoCompletoDTO newData) {
        if (find(DataMapper.torneoCompletoDTOToTorneoCompleto(newData)) == null) {
            listaTorneos.add(DataMapper.torneoCompletoDTOToTorneoCompleto(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(TorneoCompletoDTO toDelete) {
        TorneoCompleto found = find(DataMapper.torneoCompletoDTOToTorneoCompleto(toDelete));
        if (found != null) {
            listaTorneos.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TorneoCompleto find(TorneoCompleto toFind) {
        for (TorneoCompleto torneo : listaTorneos) {
            if (torneo.getNombre().equals(toFind.getNombre())) {
                return torneo;
            }
        }
        return null;
    }

    @Override
    public boolean update(TorneoCompletoDTO previous, TorneoCompletoDTO newData) {
        TorneoCompleto found = find(DataMapper.torneoCompletoDTOToTorneoCompleto(previous));
        if (found != null) {
            listaTorneos.remove(found);
            listaTorneos.add(DataMapper.torneoCompletoDTOToTorneoCompleto(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<TorneoCompleto> getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(ArrayList<TorneoCompleto> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
}
