package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class Partida implements Serializable {
	private int id;
    private Equipo equipoA;
    private Equipo equipoB;
    private int puntajeEquipoA;
    private int puntajeEquipoB;
    private Equipo ganador;
    private Date fecha;
	private String juego;
	private Torneo tor;
	private int fase;
	/**
	 * Conjunto para almacenar códigos generados aleatoriamente y evitar duplicados.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

    public Partida() {
    }

	public Partida(Equipo equipoA, Equipo equipoB, Date fecha, String juego, Torneo tor) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.puntajeEquipoA = -1;
        this.puntajeEquipoB = -1;
        this.ganador = null;
        this.fecha = fecha;
        this.juego = juego;
        this.id = codigoAleatorio();
        this.tor = tor;
        this.fase = 1;
    }
	

	/**
	 * Genera un código aleatorio único en el rango de 2000 a 2999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();
		
		 do {
	            codigo = random.nextInt((5000 - 1000 + 1)) + 1000;
	        } while (generatedCodes.contains(codigo));

	        generatedCodes.add(codigo);
	        return codigo;
	}
	
    public int getPuntajeEquipoA() {
		return puntajeEquipoA;
	}

	public void setPuntajeEquipoA(int puntajeEquipoA) {
		this.puntajeEquipoA = puntajeEquipoA;
	}

	public int getPuntajeEquipoB() {
		return puntajeEquipoB;
	}

	public void setPuntajeEquipoB(int puntajeEquipoB) {
		this.puntajeEquipoB = puntajeEquipoB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}
	
	public Torneo getTor() {
		return tor;
	}

	public void setTor(Torneo tor) {
		this.tor = tor;
	}

	public HashSet<Integer> getGeneratedCodes() {
		return generatedCodes;
	}

	public void setGeneratedCodes(HashSet<Integer> generatedCodes) {
		this.generatedCodes = generatedCodes;
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	@Override
    public String toString() {
        return "Partida{" + "equipoA=" + equipoA + ", equipoB=" + equipoB + ", ganador=" + ganador + ", fecha=" + fecha + ", juego=" + juego +'}';
    }
}
