package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EntrenadorDTO;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.JugadorDTO;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PartidaDTO;
import co.edu.unbosque.model.TorneoCompleto;
import co.edu.unbosque.model.TorneoCompletoDTO;

public class DataMapper {

	// ADMINISTRADOR

	public static Administrador administradorDTOToAdministrador(AdministradorDTO dtoAdministrador) {

		Administrador entity;
		entity = new Administrador(dtoAdministrador.getNombre(), dtoAdministrador.getContrasena(),
				dtoAdministrador.getCorreo());

		return entity;

	}

	public static AdministradorDTO administradorToAdministradorDTO(Administrador entity) {
		AdministradorDTO dto;
		dto = new AdministradorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo());

		return dto;
	}

	public static ArrayList<AdministradorDTO> listAdministradorToListAdministradorDTO(
			ArrayList<Administrador> entityList) {

		ArrayList<AdministradorDTO> dtoAdministradorList = new ArrayList<>();
		for (AdministradorDTO administradorDTO : dtoAdministradorList) {
			dtoAdministradorList.add(new AdministradorDTO(administradorDTO.getNombre(),
					administradorDTO.getContrasena(), administradorDTO.getCorreo()));
		}

		return dtoAdministradorList;

	}

	public static ArrayList<Administrador> listAdministradorDTOToListAdministrador(
			ArrayList<AdministradorDTO> dtoListAdministrador) {
		ArrayList<Administrador> entityListAdministrador = new ArrayList<>();

		for (Administrador administrador : entityListAdministrador) {
			entityListAdministrador.add(new Administrador(administrador.getNombre(), administrador.getContrasena(),
					administrador.getCorreo()));
		}
		return entityListAdministrador;
	}

	// ENTRENADOR

	public static Entrenador EntrenadorDTOToEntrenador(EntrenadorDTO dtoEntrenador) {

		Entrenador entity;
		entity = new Entrenador(dtoEntrenador.getNombre(), dtoEntrenador.getContrasena(), dtoEntrenador.getCorreo(),
				dtoEntrenador.getPais(), dtoEntrenador.getCiudad(), dtoEntrenador.getEquipos());

		return entity;

	}

	public static EntrenadorDTO EntrenadorToEntrenadorDTO(Entrenador entity) {
		EntrenadorDTO dto;
		dto = new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getPais(),
				entity.getCiudad(), entity.getEquipos());

		return dto;
	}

	public static ArrayList<EntrenadorDTO> listEntrenadorToListEntrenadorDTO(ArrayList<Entrenador> entityList) {

		ArrayList<EntrenadorDTO> dtoEntrenadorList = new ArrayList<>();
		for (EntrenadorDTO entrenadorDTO : dtoEntrenadorList) {
			dtoEntrenadorList.add(new EntrenadorDTO(entrenadorDTO.getNombre(), entrenadorDTO.getContrasena(),
					entrenadorDTO.getCorreo(), entrenadorDTO.getPais(), entrenadorDTO.getCiudad(), entrenadorDTO.getEquipos()));
		}

		return dtoEntrenadorList;

	}

	public static ArrayList<Entrenador> listEntrenadorDTOToListEntrenador(ArrayList<EntrenadorDTO> dtoListEntrenador) {
		ArrayList<Entrenador> entityListEntrenador = new ArrayList<>();

		for (Entrenador entrenador : entityListEntrenador) {
			entityListEntrenador.add(new Entrenador(entrenador.getNombre(), entrenador.getContrasena(),
					entrenador.getCorreo(), entrenador.getPais(), entrenador.getCiudad() , entrenador.getEquipos()));
		}
		return entityListEntrenador;
	}

	// EQUIPO

	public static Equipo EquipoDTOToEquipo(EquipoDTO dtoEquipo) {

		Equipo entity;
		entity = new Equipo(dtoEquipo.getNombre(), dtoEquipo.getContrasena(), dtoEquipo.getCorreo(),
				dtoEquipo.getEntrenador());

		return entity;

	}

	public static EquipoDTO EquipoToEquipoDTO(Equipo entity) {
		EquipoDTO dto;
		dto = new EquipoDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getEntrenador());

		return dto;
	}

	public static ArrayList<EquipoDTO> listEquipoToListEquipoDTO(ArrayList<Equipo> entityList) {

		ArrayList<EquipoDTO> dtoEquipoList = new ArrayList<>();
		for (EquipoDTO equipoDTO : dtoEquipoList) {
			dtoEquipoList.add(new EquipoDTO(equipoDTO.getNombre(), equipoDTO.getContrasena(), equipoDTO.getCorreo(),
					equipoDTO.getEntrenador()));
		}

		return dtoEquipoList;

	}

	public static ArrayList<Equipo> listEquipoDTOToListEquipo(ArrayList<EquipoDTO> dtoListEquipo) {
		ArrayList<Equipo> entityListEquipo = new ArrayList<>();

		for (Equipo equipo : entityListEquipo) {
			entityListEquipo.add(
					new Equipo(equipo.getNombre(), equipo.getContrasena(), equipo.getCorreo(), equipo.getEntrenador()));
		}
		return entityListEquipo;
	}

	// JUGADOR

	public static Jugador JugadorDTOToJugador(JugadorDTO dtoJugador) {

		Jugador entity;
		entity = new Jugador(dtoJugador.getNombre(), dtoJugador.getContrasena(), dtoJugador.getCorreo(),
				dtoJugador.getPais(), dtoJugador.getCiudad(), dtoJugador.getEquipo());

		return entity;

	}

	public static JugadorDTO JugadorToJugadorDTO(Jugador entity) {
		JugadorDTO dto;
		dto = new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getPais(),
				entity.getCiudad(), entity.getEquipo());

		return dto;
	}

	public static ArrayList<JugadorDTO> listJugadorToListJugadorDTO(ArrayList<Jugador> entityList) {

		ArrayList<JugadorDTO> dtoJugadorList = new ArrayList<>();
		for (JugadorDTO jugadorDTO : dtoJugadorList) {
			dtoJugadorList.add(new JugadorDTO(jugadorDTO.getNombre(), jugadorDTO.getContrasena(),
					jugadorDTO.getCorreo(), jugadorDTO.getPais(), jugadorDTO.getCiudad(), jugadorDTO.getEquipo()));
		}

		return dtoJugadorList;

	}

	public static ArrayList<Jugador> listJugadorDTOToListJugador(ArrayList<JugadorDTO> dtoListJugador) {
		ArrayList<Jugador> entityListJugador = new ArrayList<>();

		for (Jugador jugador : entityListJugador) {
			entityListJugador.add(new Jugador(jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(),
					jugador.getPais(), jugador.getCiudad(), jugador.getEquipo()));
		}
		return entityListJugador;
	}

	// PARTIDA

	public static Partida PartidaDTOToPartida(PartidaDTO dtoPartida) {

		Partida entity;
		entity = new Partida(dtoPartida.getEquipoA(), dtoPartida.getEquipoB(), dtoPartida.getGanador(),
				dtoPartida.getFecha(), dtoPartida.getJuego());

		return entity;

	}

	public static PartidaDTO PartidaToPartidaDTO(Partida entity) {
		PartidaDTO dto;
		dto = new PartidaDTO(entity.getEquipoA(), entity.getEquipoB(), entity.getGanador(), entity.getFecha(),
				entity.getJuego());

		return dto;
	}

	public static ArrayList<PartidaDTO> listPartidaToListPartidaDTO(ArrayList<Partida> entityList) {

		ArrayList<PartidaDTO> dtoPartidaList = new ArrayList<>();
		for (PartidaDTO partidaDTO : dtoPartidaList) {
			dtoPartidaList.add(new PartidaDTO(partidaDTO.getEquipoA(), partidaDTO.getEquipoB(), partidaDTO.getGanador(),
					partidaDTO.getFecha(), partidaDTO.getJuego()));
		}

		return dtoPartidaList;

	}

	public static ArrayList<Partida> listPartidaDTOToListPartida(ArrayList<PartidaDTO> dtoListPartida) {
		ArrayList<Partida> entityListPartida = new ArrayList<>();

		for (Partida partida : entityListPartida) {
			entityListPartida.add(new Partida(partida.getEquipoA(), partida.getEquipoB(), partida.getGanador(),
					partida.getFecha(), partida.getJuego()));
		}
		return entityListPartida;
	}

	// TORNEOs .............................

}
