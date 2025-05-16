package co.edu.unbosque.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

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

	public TorneoLlave(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas,
			Equipo ganador, int cantidadFase) {
		super(nombre, juego, equipos, partidas, ganador);
		this.cantidadFase = cantidadFase;
	}

	public TorneoLlave(String nombre, String juego, ArrayList<Equipo> equipos, ArrayList<Partida> partidas) {
		super(nombre, juego);
		setEquipos(equipos);
		setPartidas(partidas);
	}

	public TorneoLlave(String nombre, String juego, ArrayList<Equipo> equipos) {
		super(nombre, juego, equipos);
		crearFase(equipos);
	}

	public void crearFase(ArrayList<Equipo> equipos) {

		int cantidadFase = (int) (Math.log(equipos.size()) / Math.log(2));
		setCantidadFase(cantidadFase);

		ZonedDateTime fechaColombia = ZonedDateTime.now(ZoneId.of("America/Bogota"));
		ZonedDateTime fechaPartido = fechaColombia.plusDays(1);

		ArrayList<Partida> partidas = new ArrayList<>();

		Collections.shuffle(equipos);

		for (int i = 0; i < equipos.size(); i += 2) {
			partidas.add(new Partida(equipos.get(i), equipos.get(i + 1), Date.from(fechaPartido.toInstant()),
					this.getJuego(), this));
			fechaPartido = fechaPartido.plusDays(1);
		}
		setPartidas(partidas);
	}

	public void crearFasesPost(ArrayList<Equipo> equipos) {
		
		System.out.println("creando siguiente fase");
		
		for (Equipo equipo : equipos) {
			System.out.println(equipo.getNombre() + "Creado");
		}
		
		ZonedDateTime fechaColombia = ZonedDateTime.now(ZoneId.of("America/Bogota"));
		ZonedDateTime fechaPartido = fechaColombia.plusDays(1);
		
		ArrayList<Partida> partidas = new ArrayList<>();
		partidas.addAll(getPartidas());
		
		for (int i = 0; i < equipos.size(); i += 2) {

			partidas.add(new Partida(equipos.get(i), equipos.get(i + 1), Date.from(fechaPartido.toInstant()),
					this.getJuego(), this));
			fechaPartido = fechaPartido.plusDays(1);
		}
		setPartidas(partidas);
	}

	public int getCantidadFase() {
		return cantidadFase;
	}

	public void setCantidadFase(int cantidadFase) {
		this.cantidadFase = cantidadFase;
	}

	@Override
	public String toString() {
		return "TorneoLlave{" + super.toString() + "}";
	}
}
