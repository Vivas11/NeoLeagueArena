package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoLlave extends Torneo implements Serializable {

    private int cantidadFase;

    public TorneoLlave() {
        super();
    }

    public TorneoLlave(String nombre, String juego) {
        super(nombre, juego);
    }

    public TorneoLlave(int cantidadFase) {
		super();
		this.cantidadFase = cantidadFase;
	}

	public TorneoLlave(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
        super(nombre, juego);
        setEquipos(equipos);
        setPartidas(partidas);
    }

    @Override
    public String toString() {
        return "TorneoLlave{" + super.toString() + "}";
    }
}
