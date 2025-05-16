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
import co.edu.unbosque.model.TorneoLiga;
import co.edu.unbosque.model.TorneoLigaDTO;
import co.edu.unbosque.model.TorneoLlave;
import co.edu.unbosque.model.TorneoLlaveDTO;

public class DataMapper {

    // ADMINISTRADOR

    public static Administrador administradorDTOToAdministrador(AdministradorDTO dtoAdministrador) {
        Administrador entity;
        entity = new Administrador(
            dtoAdministrador.getNombre(),
            dtoAdministrador.getContrasena(),
            dtoAdministrador.getCorreo()
        );
        return entity;
    }

    public static AdministradorDTO administradorToAdministradorDTO(Administrador entity) {
        AdministradorDTO dto;
        dto = new AdministradorDTO(
            entity.getNombre(),
            entity.getContrasena(),
            entity.getCorreo()
        );
        return dto;
    }

    public static ArrayList<AdministradorDTO> listAdministradorToListAdministradorDTO(
            ArrayList<Administrador> entityList) {
        ArrayList<AdministradorDTO> dtoAdministradorList = new ArrayList<>();
        for (Administrador administrador : entityList) {
            dtoAdministradorList.add(administradorToAdministradorDTO(administrador));
        }
        return dtoAdministradorList;
    }

    public static ArrayList<Administrador> listAdministradorDTOToListAdministrador(
            ArrayList<AdministradorDTO> dtoListAdministrador) {
        ArrayList<Administrador> entityListAdministrador = new ArrayList<>();
        for (AdministradorDTO administradorDTO : dtoListAdministrador) {
            entityListAdministrador.add(administradorDTOToAdministrador(administradorDTO));
        }
        return entityListAdministrador;
    }

    // ENTRENADOR

    public static Entrenador entrenadorDTOToEntrenador(EntrenadorDTO dtoEntrenador) {
        Entrenador entity;
        entity = new Entrenador(
            dtoEntrenador.getNombre(),
            dtoEntrenador.getContrasena(),
            dtoEntrenador.getCorreo(),
            dtoEntrenador.getPais(),
            dtoEntrenador.getCiudad(),
            dtoEntrenador.getEquipos(),
            dtoEntrenador.getImagen()
        );
        return entity;
    }

    public static EntrenadorDTO entrenadorToEntrenadorDTO(Entrenador entity) {
        EntrenadorDTO dto;
        dto = new EntrenadorDTO(
            entity.getNombre(),
            entity.getContrasena(),
            entity.getCorreo(),
            entity.getPais(),
            entity.getCiudad(),
            entity.getEquipos(),
            entity.getImagen()
        );
        return dto;
    }

    public static ArrayList<EntrenadorDTO> listEntrenadorToListEntrenadorDTO(ArrayList<Entrenador> entityList) {
        ArrayList<EntrenadorDTO> dtoEntrenadorList = new ArrayList<>();
        for (Entrenador entrenador : entityList) {
            dtoEntrenadorList.add(entrenadorToEntrenadorDTO(entrenador));
        }
        return dtoEntrenadorList;
    }

    public static ArrayList<Entrenador> listEntrenadorDTOToListEntrenador(ArrayList<EntrenadorDTO> dtoListEntrenador) {
        ArrayList<Entrenador> entityListEntrenador = new ArrayList<>();
        for (EntrenadorDTO entrenadorDTO : dtoListEntrenador) {
            entityListEntrenador.add(entrenadorDTOToEntrenador(entrenadorDTO));
        }
        return entityListEntrenador;
    }

    // EQUIPO

    public static Equipo equipoDTOToEquipo(EquipoDTO dtoEquipo) {
        Equipo entity;
        entity = new Equipo(
            dtoEquipo.getNombre(),
            dtoEquipo.getPais(),
            dtoEquipo.getJugadores(),
            dtoEquipo.getEntrenador(),
            dtoEquipo.getTorneosJugados(),
            dtoEquipo.getPartidosJugados(),
            dtoEquipo.getImagen()
        );
        return entity;
    }

    public static EquipoDTO equipoToEquipoDTO(Equipo entity) {
        EquipoDTO dto;
        dto = new EquipoDTO(
            entity.getNombre(),
            entity.getPais(),
            entity.getJugadores(),
            entity.getEntrenador(),
            entity.getTorneosJugados(),
            entity.getPartidosJugados(),
            entity.getImagen()
        );
        return dto;
    }

    public static ArrayList<EquipoDTO> listEquipoToListEquipoDTO(ArrayList<Equipo> entityList) {
        ArrayList<EquipoDTO> dtoEquipoList = new ArrayList<>();
        for (Equipo equipo : entityList) {
            dtoEquipoList.add(equipoToEquipoDTO(equipo));
        }
        return dtoEquipoList;
    }

    public static ArrayList<Equipo> listEquipoDTOToListEquipo(ArrayList<EquipoDTO> dtoListEquipo) {
        ArrayList<Equipo> entityListEquipo = new ArrayList<>();
        for (EquipoDTO equipoDTO : dtoListEquipo) {
            entityListEquipo.add(equipoDTOToEquipo(equipoDTO));
        }
        return entityListEquipo;
    }

    // JUGADOR

    public static Jugador jugadorDTOToJugador(JugadorDTO dtoJugador) {
        Jugador entity;
        entity = new Jugador(
            dtoJugador.getNombre(),
            dtoJugador.getContrasena(),
            dtoJugador.getCorreo(),
            dtoJugador.getPais(),
            dtoJugador.getCiudad(),
            dtoJugador.getEquipo(),
            dtoJugador.getImagen(),
            dtoJugador.getPartidasJugadas(),
            dtoJugador.getPartidasGanadas()
        );
        return entity;
    }

    public static JugadorDTO jugadorToJugadorDTO(Jugador entity) {
        JugadorDTO dto;
        dto = new JugadorDTO(
            entity.getNombre(),
            entity.getContrasena(),
            entity.getCorreo(),
            entity.getPais(),
            entity.getCiudad(),
            entity.getEquipo(),
            entity.getImagen(),
            entity.getPartidasJugadas(),
            entity.getPartidasGanadas()
        );
        return dto;
    }

    public static ArrayList<JugadorDTO> listJugadorToListJugadorDTO(ArrayList<Jugador> entityList) {
        ArrayList<JugadorDTO> dtoJugadorList = new ArrayList<>();
        for (Jugador jugador : entityList) {
            dtoJugadorList.add(jugadorToJugadorDTO(jugador));
        }
        return dtoJugadorList;
    }

    public static ArrayList<Jugador> listJugadorDTOToListJugador(ArrayList<JugadorDTO> dtoListJugador) {
        ArrayList<Jugador> entityListJugador = new ArrayList<>();
        for (JugadorDTO jugadorDTO : dtoListJugador) {
            entityListJugador.add(jugadorDTOToJugador(jugadorDTO));
        }
        return entityListJugador;
    }

    // TorneoLiga
    public static TorneoLigaDTO torneoLigaToTorneoLigaDTO(TorneoLiga torneo) {
        if (torneo == null) return null;
        TorneoLigaDTO dto;
        dto = new TorneoLigaDTO(
            torneo.getNombre(),
            torneo.getJuego(),
            torneo.getEquipos(),
            torneo.getPartidas(),
            torneo.getGanador(),
            torneo.getPuntos()
        );
        return dto;
    }

    public static TorneoLiga torneoLigaDTOToTorneoLiga(TorneoLigaDTO dto) {
        if (dto == null) return null;
        TorneoLiga entity;
        entity = new TorneoLiga(
            dto.getNombre(),
            dto.getJuego(),
            dto.getEquipos(),
            dto.getPartidas(),
            dto.getGanador(),
            dto.getPuntos()
        );
        return entity;
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
        TorneoLlaveDTO dto;
        dto = new TorneoLlaveDTO(
            torneo.getNombre(),
            torneo.getJuego(),
            torneo.getEquipos(),
            torneo.getPartidas(),
            torneo.getGanador(),
            torneo.getCantidadFase()
        );
        return dto;
    }

    public static TorneoLlave torneoLlaveDTOToTorneoLlave(TorneoLlaveDTO dto) {
        if (dto == null) return null;
        TorneoLlave entity;
        entity = new TorneoLlave(
            dto.getNombre(),
            dto.getJuego(),
            dto.getEquipos()
//            dto.getPartidas(),
//            dto.getGanador(),
//            dto.getCantidadFase()
        );
        return entity;
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
