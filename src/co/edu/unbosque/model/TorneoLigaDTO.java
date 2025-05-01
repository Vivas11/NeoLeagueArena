package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoLigaDTO extends Torneo implements Serializable {
	
	private Equipo[][] grupos;
	
    public TorneoLigaDTO() {
        super();
    }
    
    public TorneoLigaDTO(String nombre, String juego) {
		super(nombre, juego);
		// TODO Auto-generated constructor stub
	}

	public TorneoLigaDTO(Equipo[][] grupos) {
		super();
		this.grupos = grupos;
	}

	public TorneoLigaDTO(String nombre, String juego, Equipo[][] grupos) {
		super(nombre, juego);
		this.grupos = grupos;
	}

	public Equipo[][] getGrupos() {
		return grupos;
	}

	public void setGrupos(Equipo[][] grupos) {
		this.grupos = grupos;
	}

	@Override
    public String toString() {
        return "TorneoLiga{" + super.toString() + "}";
    }
}
