package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoCompletoDTO  extends Torneo implements Serializable {
	private int cantidadFase;
	private int cantidadGrupo;
	private Equipo[][] grupos;

    public TorneoCompletoDTO() {
        super();
    }

    public TorneoCompletoDTO(String nombre, String juego) {
        super(nombre, juego);
    }

    public TorneoCompletoDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
        super(nombre, juego);
        setEquipos(equipos);
        setPartidas(partidas);
    }

    public TorneoCompletoDTO(int cantidadFase, int cantidadGrupo, Equipo[][] grupos) {
		super();
		this.cantidadFase = cantidadFase;
		this.cantidadGrupo = cantidadGrupo;
		this.grupos = grupos;
	}

	@Override
    public String toString() {
        return "TorneoCompleto{" + super.toString() + "}";
    }

	public int getCantidadFase() {
		return cantidadFase;
	}

	public void setCantidadFase(int cantidadFase) {
		this.cantidadFase = cantidadFase;
	}

	public int getCantidadGrupo() {
		return cantidadGrupo;
	}

	public void setCantidadGrupo(int cantidadGrupo) {
		this.cantidadGrupo = cantidadGrupo;
	}

	public Equipo[][] getGrupos() {
		return grupos;
	}

	public void setGrupos(Equipo[][] grupos) {
		this.grupos = grupos;
	}
}
	