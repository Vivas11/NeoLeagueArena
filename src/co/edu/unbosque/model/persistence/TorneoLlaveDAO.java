package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;

public class TorneoLlaveDAO implements OperacionDAO<TorneoLlaveDTO, TorneoLlave> {

    private final String SERIAL_FILE_NAME = "torneoLlave.dat";

    private ArrayList<TorneoLlave> listaTorneos;

    public TorneoLlaveDAO() {
        listaTorneos = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTorneos);
    }

    public void cargarSerializado() {
        listaTorneos = (ArrayList<TorneoLlave>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaTorneos == null) {
            listaTorneos = new ArrayList<>();
        }
    }

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

    @Override
    public ArrayList<TorneoLlaveDTO> getAll() {
        return DataMapper.listaTorneoLlaveToListaTorneoLlaveDTO(listaTorneos);
    }

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

    @Override
    public TorneoLlave find(TorneoLlave toFind) {
        for (TorneoLlave torneo : listaTorneos) {
            if (torneo.getNombre().equals(toFind.getNombre())) {
                return torneo;
            }
        }
        return null;
    }

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

    public ArrayList<TorneoLlave> getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(ArrayList<TorneoLlave> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }
}
