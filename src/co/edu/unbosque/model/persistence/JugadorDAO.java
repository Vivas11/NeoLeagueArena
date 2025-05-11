package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;

public class JugadorDAO implements OperacionDAO<JugadorDTO, Jugador> {

    private final String SERIAL_FILE_NAME = "jugador.dat";

    private ArrayList<Jugador> listaJugadores;

    public JugadorDAO() {
        listaJugadores = new ArrayList<>();
        cargarSerializado();
    }

    public void escribirSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaJugadores);
    }

    public void cargarSerializado() {
        listaJugadores = (ArrayList<Jugador>) FileManager.leerArchivoSerialziado(SERIAL_FILE_NAME);
        if (listaJugadores == null) {
            listaJugadores = new ArrayList<>();
        }
    }

    @Override
    public String showAll() {
        String rta = "";
        if (listaJugadores.isEmpty()) {
            return "No hay jugadores en la lista";
        } else {
            for (Jugador jugador : listaJugadores) {
                rta += jugador.toString() + "\n";
            }
            return rta.toString();
        }
    }

    @Override
    public ArrayList<JugadorDTO> getAll() {
        return DataMapper.listJugadorToListJugadorDTO(listaJugadores);
    }

    @Override
    public boolean add(JugadorDTO newData) {
        if (find(DataMapper.jugadorDTOToJugador(newData)) == null) {
            listaJugadores.add(DataMapper.jugadorDTOToJugador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(JugadorDTO toDelete) {
        Jugador found = find(DataMapper.jugadorDTOToJugador(toDelete));
        if (found != null) {
            listaJugadores.remove(found);
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Jugador find(Jugador toFind) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombre().equals(toFind.getNombre())) {
                return jugador;
            }
        }
        return null;
    }

    @Override
    public boolean update(JugadorDTO previous, JugadorDTO newData) {
        Jugador found = find(DataMapper.jugadorDTOToJugador(previous));
        if (found != null) {
            listaJugadores.remove(found);
            listaJugadores.add(DataMapper.jugadorDTOToJugador(newData));
            escribirSerializado();
            return true;
        } else {
            return false;
        }
    }
    
    public void organizarUsuarioPorWinRate() {
    	
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
}
