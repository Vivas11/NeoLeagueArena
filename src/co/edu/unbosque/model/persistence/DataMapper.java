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
import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.TorneoLigaDTO;
import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;

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

	public static Entrenador entrenadorDTOToEntrenador(EntrenadorDTO dtoEntrenador) {

		Entrenador entity;
		entity = new Entrenador(dtoEntrenador.getNombre(), dtoEntrenador.getContrasena(), dtoEntrenador.getCorreo(),
				dtoEntrenador.getPais(), dtoEntrenador.getCiudad(), dtoEntrenador.getEquipos(),dtoEntrenador.getImagen());

		return entity;

	}

	public static EntrenadorDTO entrenadorToEntrenadorDTO(Entrenador entity) {
		EntrenadorDTO dto;
		dto = new EntrenadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getPais(),
				entity.getCiudad(), entity.getEquipos(),entity.getImagen());

		return dto;
	}

	public static ArrayList<EntrenadorDTO> listEntrenadorToListEntrenadorDTO(ArrayList<Entrenador> entityList) {

		ArrayList<EntrenadorDTO> dtoEntrenadorList = new ArrayList<>();
		for (EntrenadorDTO entrenadorDTO : dtoEntrenadorList) {
			dtoEntrenadorList.add(new EntrenadorDTO(entrenadorDTO.getNombre(), entrenadorDTO.getContrasena(),
					entrenadorDTO.getCorreo(), entrenadorDTO.getPais(), entrenadorDTO.getCiudad(), entrenadorDTO.getEquipos(),entrenadorDTO.getImagen()));
		}

		return dtoEntrenadorList;

	}

	public static ArrayList<Entrenador> listEntrenadorDTOToListEntrenador(ArrayList<EntrenadorDTO> dtoListEntrenador) {
		ArrayList<Entrenador> entityListEntrenador = new ArrayList<>();

		for (Entrenador entrenador : entityListEntrenador) {
			entityListEntrenador.add(new Entrenador(entrenador.getNombre(), entrenador.getContrasena(),
					entrenador.getCorreo(), entrenador.getPais(), entrenador.getCiudad() , entrenador.getEquipos(),entrenador.getImagen()));
		}
		return entityListEntrenador;
	}

	// EQUIPO

	public static Equipo equipoDTOToEquipo(EquipoDTO dtoEquipo) {

		Equipo entity;
		entity = new Equipo(dtoEquipo.getNombre(),
				dtoEquipo.getEntrenador());

		return entity;

	}

	public static EquipoDTO equipoToEquipoDTO(Equipo entity) {
		EquipoDTO dto;
		dto = new EquipoDTO(entity.getNombre(), entity.getEntrenador());

		return dto;
	}

	public static ArrayList<EquipoDTO> listEquipoToListEquipoDTO(ArrayList<Equipo> entityList) {

		ArrayList<EquipoDTO> dtoEquipoList = new ArrayList<>();
		for (EquipoDTO equipoDTO : dtoEquipoList) {
			dtoEquipoList.add(new EquipoDTO(equipoDTO.getNombre(),
					equipoDTO.getEntrenador()));
		}

		return dtoEquipoList;

	}

	public static ArrayList<Equipo> listEquipoDTOToListEquipo(ArrayList<EquipoDTO> dtoListEquipo) {
		ArrayList<Equipo> entityListEquipo = new ArrayList<>();

		for (Equipo equipo : entityListEquipo) {
			entityListEquipo.add(
					new Equipo(equipo.getNombre(), equipo.getEntrenador()));
		}
		return entityListEquipo;
	}

	// JUGADOR

	public static Jugador jugadorDTOToJugador(JugadorDTO dtoJugador) {

		Jugador entity;
		entity = new Jugador(dtoJugador.getNombre(), dtoJugador.getContrasena(), dtoJugador.getCorreo(),
				dtoJugador.getPais(), dtoJugador.getCiudad(), dtoJugador.getEquipo(),dtoJugador.getImagen());

		return entity;

	}

	public static JugadorDTO jugadorToJugadorDTO(Jugador entity) {
		JugadorDTO dto;
		dto = new JugadorDTO(entity.getNombre(), entity.getContrasena(), entity.getCorreo(), entity.getPais(),
				entity.getCiudad(), entity.getEquipo(),entity.getImagen());

		return dto;
	}

	public static ArrayList<JugadorDTO> listJugadorToListJugadorDTO(ArrayList<Jugador> entityList) {

		ArrayList<JugadorDTO> dtoJugadorList = new ArrayList<>();
		for (JugadorDTO jugadorDTO : dtoJugadorList) {
			dtoJugadorList.add(new JugadorDTO(jugadorDTO.getNombre(), jugadorDTO.getContrasena(),
					jugadorDTO.getCorreo(), jugadorDTO.getPais(), jugadorDTO.getCiudad(), jugadorDTO.getEquipo(),jugadorDTO.getImagen()));
		}

		return dtoJugadorList;

	}

	public static ArrayList<Jugador> listJugadorDTOToListJugador(ArrayList<JugadorDTO> dtoListJugador) {
		ArrayList<Jugador> entityListJugador = new ArrayList<>();

		for (Jugador jugador : entityListJugador) {
			entityListJugador.add(new Jugador(jugador.getNombre(), jugador.getContrasena(), jugador.getCorreo(),
					jugador.getPais(), jugador.getCiudad(), jugador.getEquipo(),jugador.getImagen()));
		}
		return entityListJugador;
	}

	// PARTIDA

	public static Partida partidaDTOToPartida(PartidaDTO dtoPartida) {

		Partida entity;
		entity = new Partida(dtoPartida.getEquipoA(), dtoPartida.getEquipoB(), dtoPartida.getGanador(),
				dtoPartida.getFecha(), dtoPartida.getJuego(), dtoPartida.getId());

		return entity;

	}

	public static PartidaDTO partidaToPartidaDTO(Partida entity) {
		PartidaDTO dto;
		dto = new PartidaDTO(entity.getEquipoA(), entity.getEquipoB(), entity.getGanador(), entity.getFecha(),
				entity.getJuego(), entity.getId());

		return dto;
	}

	public static ArrayList<PartidaDTO> listPartidaToListPartidaDTO(ArrayList<Partida> entityList) {

		ArrayList<PartidaDTO> dtoPartidaList = new ArrayList<>();
		for (PartidaDTO partidaDTO : dtoPartidaList) {
			dtoPartidaList.add(new PartidaDTO(partidaDTO.getEquipoA(), partidaDTO.getEquipoB(), partidaDTO.getGanador(),
					partidaDTO.getFecha(), partidaDTO.getJuego(), partidaDTO.getId()));
		}

		return dtoPartidaList;

	}

	public static ArrayList<Partida> listPartidaDTOToListPartida(ArrayList<PartidaDTO> dtoListPartida) {
		ArrayList<Partida> entityListPartida = new ArrayList<>();

		for (Partida partida : entityListPartida) {
			entityListPartida.add(new Partida(partida.getEquipoA(), partida.getEquipoB(), partida.getGanador(),
					partida.getFecha(), partida.getJuego(), partida.getId()));
		}
		return entityListPartida;
	}

	// TorneoCompleto
	public static TorneoCompletoDTO torneoCompletoToTorneoCompletoDTO(TorneoCompleto torneo) {
		if (torneo == null) return null;
		TorneoCompletoDTO dto = new TorneoCompletoDTO(
			torneo.getCantidadFase(),
			torneo.getCantidadGrupo(),
			torneo.getGrupos()
		);
		dto.setNombre(torneo.getNombre());
		dto.setJuego(torneo.getJuego());
		dto.setEquipos(torneo.getEquipos());
		dto.setPartidas(torneo.getPartidas());
		return dto;
	}

	public static TorneoCompleto torneoCompletoDTOToTorneoCompleto(TorneoCompletoDTO dto) {
		if (dto == null) return null;
		TorneoCompleto torneo = new TorneoCompleto(
			dto.getCantidadFase(),
			dto.getCantidadGrupo(),
			dto.getGrupos()
		);
		torneo.setNombre(dto.getNombre());
		torneo.setJuego(dto.getJuego());
		torneo.setEquipos(dto.getEquipos());
		torneo.setPartidas(dto.getPartidas());
		return torneo;
	}

	public static ArrayList<TorneoCompletoDTO> listaTorneoCompletoToListaTorneoCompletoDTO(ArrayList<TorneoCompleto> lista) {
		ArrayList<TorneoCompletoDTO> dtoList = new ArrayList<>();
		for (TorneoCompleto torneo : lista) {
			dtoList.add(torneoCompletoToTorneoCompletoDTO(torneo));
		}
		return dtoList;
	}

	public static ArrayList<TorneoCompleto> listaTorneoCompletoDTOToListaTorneoCompleto(ArrayList<TorneoCompletoDTO> lista) {
		ArrayList<TorneoCompleto> torneoList = new ArrayList<>();
		for (TorneoCompletoDTO dto : lista) {
			torneoList.add(torneoCompletoDTOToTorneoCompleto(dto));
		}
		return torneoList;
	}

	// TorneoLiga
	public static TorneoLigaDTO torneoLigaToTorneoLigaDTO(TorneoLiga torneo) {
		if (torneo == null) return null;
		TorneoLigaDTO dto = new TorneoLigaDTO(
			torneo.getNombre(),
			torneo.getJuego(),
			torneo.getGrupos()
		);
		return dto;
	}

	public static TorneoLiga torneoLigaDTOToTorneoLiga(TorneoLigaDTO dto) {
		if (dto == null) return null;
		TorneoLiga torneo = new TorneoLiga(
			dto.getNombre(),
			dto.getJuego(),
			dto.getGrupos()
		);
		return torneo;
	}

	public static ArrayList<TorneoLigaDTO> listaTorneoLigaToListaTorneoLigaDTO(ArrayList<TorneoLiga> lista) {
		ArrayList<TorneoLigaDTO> dtoList = new ArrayList<>();
		for (TorneoLiga torneo : lista) {
			dtoList.add(torneoLigaToTorneoLigaDTO(torneo));
		}
		return dtoList;
	}

	public static ArrayList<TorneoLiga> listaTorneoLigaDTOToListaTorneoLiga(ArrayList<TorneoLigaDTO> lista) {
		ArrayList<TorneoLiga> torneoList = new ArrayList<>();
		for (TorneoLigaDTO dto : lista) {
			torneoList.add(torneoLigaDTOToTorneoLiga(dto));
		}
		return torneoList;
	}

	// TorneoLlave
	public static TorneoLlaveDTO torneoLlaveToTorneoLlaveDTO(TorneoLlave torneo) {
		if (torneo == null) return null;
		TorneoLlaveDTO dto = new TorneoLlaveDTO(
			torneo.getNombre(),
			torneo.getJuego(),
			torneo.getEquipos(),
			torneo.getPartidas()
		);
		dto.setCantidadFase(torneo.getCantidadFase());
		return dto;
	}

	public static TorneoLlave torneoLlaveDTOToTorneoLlave(TorneoLlaveDTO dto) {
		if (dto == null) return null;
		TorneoLlave torneo = new TorneoLlave(
			dto.getNombre(),
			dto.getJuego(),
			dto.getEquipos(),
			dto.getPartidas()
		);
		torneo.setCantidadFase(dto.getCantidadFase());
		return torneo;
	}

	public static ArrayList<TorneoLlaveDTO> listaTorneoLlaveToListaTorneoLlaveDTO(ArrayList<TorneoLlave> lista) {
		ArrayList<TorneoLlaveDTO> dtoList = new ArrayList<>();
		for (TorneoLlave torneo : lista) {
			dtoList.add(torneoLlaveToTorneoLlaveDTO(torneo));
		}
		return dtoList;
	}

	public static ArrayList<TorneoLlave> listaTorneoLlaveDTOToListaTorneoLlave(ArrayList<TorneoLlaveDTO> lista) {
		ArrayList<TorneoLlave> torneoList = new ArrayList<>();
		for (TorneoLlaveDTO dto : lista) {
			torneoList.add(torneoLlaveDTOToTorneoLlave(dto));
		}
		return torneoList;
	}

}
