package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoLlaveDTO extends Torneo implements Serializable {

    private int cantidadFase;

    public TorneoLlaveDTO() {
        super();
    }

    public TorneoLlaveDTO(String nombre, String juego) {
        super(nombre, juego);
    }

    public TorneoLlaveDTO(int cantidadFase) {
		super();
		this.cantidadFase = cantidadFase;
	}

	public TorneoLlaveDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
        super(nombre, juego);
        setEquipos(equipos);
        setPartidas(partidas);
    }

    @Override
    public String toString() {
        return "TorneoLlave{" + super.toString() + "}";
    }
}
