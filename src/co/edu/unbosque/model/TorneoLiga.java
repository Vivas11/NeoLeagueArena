package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoLiga extends Torneo implements Serializable {
	
	private Equipo[][] grupos;
	
    public TorneoLiga() {
        super();
    }
    
    public TorneoLiga(String nombre, String juego) {
		super(nombre, juego);
		// TODO Auto-generated constructor stub
	}

	public TorneoLiga(Equipo[][] grupos) {
		super();
		this.grupos = grupos;
	}

	public TorneoLiga(String nombre, String juego, Equipo[][] grupos) {
		super(nombre, juego);
		this.grupos = grupos;
	}

	@Override
    public String toString() {
        return "TorneoLiga{" + super.toString() + "}";
    }
}
