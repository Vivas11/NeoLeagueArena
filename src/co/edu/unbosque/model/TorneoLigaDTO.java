package co.edu.unbosque.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.model.persistence.DataMapper;

public class TorneoLigaDTO extends Torneo implements Serializable {
	

	private Map<Equipo, Integer> puntos;
	
    public TorneoLigaDTO() {
        super();
    }
    
    public TorneoLigaDTO(String nombre, String juego) {
		super(nombre, juego);
		// TODO Auto-generated constructor stub
	}
    
    
    
	public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
			Equipo ganador) {
		super(nombre, juego, equipos, partidas, ganador);
		// TODO Auto-generated constructor stub
	}

	public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos) {
		super(nombre, juego, equipos);
		puntos = new HashMap<>();
		for (Equipo equipo : equipos) {
			puntos.put(equipo, 0);
		}
		
		ZonedDateTime fechaColombia = ZonedDateTime.now(ZoneId.of("America/Bogota"));
		ZonedDateTime fechaPartido = fechaColombia.plusDays(1);

		for (Equipo e1 : equipos) {
			for (Equipo e2 : equipos) {
				if(!e1.equals(e2)) {
					this.getPartidas().add(new Partida(e1, e2, Date.from(fechaPartido.toInstant()), juego, DataMapper.torneoLigaDTOToTorneoLiga(this)));
					fechaPartido = fechaPartido.plusDays(1);
				}
			}
		}
	}
	
	
	
	public TorneoLigaDTO(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
			Equipo ganador, Map<Equipo, Integer> puntos) {
		super(nombre, juego, equipos, partidas, ganador);
		this.puntos = puntos;
	}

	@Override
    public String toString() {
        return "TorneoLiga{" + super.toString() + "}";
    }


	public Map<Equipo, Integer> getPuntos() {
		return puntos;
	}

	public void setPuntos(Map<Equipo, Integer> puntos) {
		this.puntos = puntos;
	}
}
