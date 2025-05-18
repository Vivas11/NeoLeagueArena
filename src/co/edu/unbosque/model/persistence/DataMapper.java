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

/**
 * Clase utilitaria para mapear entidades y DTOs de la capa de modelo.
 * Proporciona métodos estáticos para convertir entre entidades y sus DTOs,
 * así como para convertir listas de entidades y DTOs.
 */
public class DataMapper {

    // ADMINISTRADOR

    /**
     * Convierte un objeto AdministradorDTO a Administrador.
     * @param dtoAdministrador DTO de administrador.
     * @return Entidad Administrador.
     */
    public static Administrador administradorDTOToAdministrador(AdministradorDTO dtoAdministrador) {
        Administrador entity;
        entity = new Administrador(
            dtoAdministrador.getNombre(),
            dtoAdministrador.getContrasena(),
            dtoAdministrador.getCorreo()
        );
        return entity;
    }

    /**
     * Convierte un objeto Administrador a AdministradorDTO.
     * @param entity Entidad Administrador.
     * @return DTO de administrador.
     */
    public static AdministradorDTO administradorToAdministradorDTO(Administrador entity) {
        AdministradorDTO dto;
        dto = new AdministradorDTO(
            entity.getNombre(),
            entity.getContrasena(),
            entity.getCorreo()
        );
        return dto;
    }

    /**
     * Convierte una lista de Administrador a una lista de AdministradorDTO.
     * @param entityList Lista de entidades Administrador.
     * @return Lista de DTOs de administrador.
     */
    public static ArrayList<AdministradorDTO> listAdministradorToListAdministradorDTO(
            ArrayList<Administrador> entityList) {
        ArrayList<AdministradorDTO> dtoAdministradorList = new ArrayList<>();
        for (Administrador administrador : entityList) {
            dtoAdministradorList.add(administradorToAdministradorDTO(administrador));
        }
        return dtoAdministradorList;
    }

    /**
     * Convierte una lista de AdministradorDTO a una lista de Administrador.
     * @param dtoListAdministrador Lista de DTOs de administrador.
     * @return Lista de entidades Administrador.
     */
    public static ArrayList<Administrador> listAdministradorDTOToListAdministrador(
            ArrayList<AdministradorDTO> dtoListAdministrador) {
        ArrayList<Administrador> entityListAdministrador = new ArrayList<>();
        for (AdministradorDTO administradorDTO : dtoListAdministrador) {
            entityListAdministrador.add(administradorDTOToAdministrador(administradorDTO));
        }
        return entityListAdministrador;
    }

    // ENTRENADOR

    /**
     * Convierte un objeto EntrenadorDTO a Entrenador.
     * @param dtoEntrenador DTO de entrenador.
     * @return Entidad Entrenador.
     */
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

    /**
     * Convierte un objeto Entrenador a EntrenadorDTO.
     * @param entity Entidad Entrenador.
     * @return DTO de entrenador.
     */
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

    /**
     * Convierte una lista de Entrenador a una lista de EntrenadorDTO.
     * @param entityList Lista de entidades Entrenador.
     * @return Lista de DTOs de entrenador.
     */
    public static ArrayList<EntrenadorDTO> listEntrenadorToListEntrenadorDTO(ArrayList<Entrenador> entityList) {
        ArrayList<EntrenadorDTO> dtoEntrenadorList = new ArrayList<>();
        for (Entrenador entrenador : entityList) {
            dtoEntrenadorList.add(entrenadorToEntrenadorDTO(entrenador));
        }
        return dtoEntrenadorList;
    }

    /**
     * Convierte una lista de EntrenadorDTO a una lista de Entrenador.
     * @param dtoListEntrenador Lista de DTOs de entrenador.
     * @return Lista de entidades Entrenador.
     */
    public static ArrayList<Entrenador> listEntrenadorDTOToListEntrenador(ArrayList<EntrenadorDTO> dtoListEntrenador) {
        ArrayList<Entrenador> entityListEntrenador = new ArrayList<>();
        for (EntrenadorDTO entrenadorDTO : dtoListEntrenador) {
            entityListEntrenador.add(entrenadorDTOToEntrenador(entrenadorDTO));
        }
        return entityListEntrenador;
    }

    // EQUIPO

    /**
     * Convierte un objeto EquipoDTO a Equipo.
     * @param dtoEquipo DTO de equipo.
     * @return Entidad Equipo.
     */
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

    /**
     * Convierte un objeto Equipo a EquipoDTO.
     * @param entity Entidad Equipo.
     * @return DTO de equipo.
     */
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

    /**
     * Convierte una lista de Equipo a una lista de EquipoDTO.
     * @param entityList Lista de entidades Equipo.
     * @return Lista de DTOs de equipo.
     */
    public static ArrayList<EquipoDTO> listEquipoToListEquipoDTO(ArrayList<Equipo> entityList) {
        ArrayList<EquipoDTO> dtoEquipoList = new ArrayList<>();
        for (Equipo equipo : entityList) {
            dtoEquipoList.add(equipoToEquipoDTO(equipo));
        }
        return dtoEquipoList;
    }

    /**
     * Convierte una lista de EquipoDTO a una lista de Equipo.
     * @param dtoListEquipo Lista de DTOs de equipo.
     * @return Lista de entidades Equipo.
     */
    public static ArrayList<Equipo> listEquipoDTOToListEquipo(ArrayList<EquipoDTO> dtoListEquipo) {
        ArrayList<Equipo> entityListEquipo = new ArrayList<>();
        for (EquipoDTO equipoDTO : dtoListEquipo) {
            entityListEquipo.add(equipoDTOToEquipo(equipoDTO));
        }
        return entityListEquipo;
    }

    // JUGADOR

    /**
     * Convierte un objeto JugadorDTO a Jugador.
     * @param dtoJugador DTO de jugador.
     * @return Entidad Jugador.
     */
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

    /**
     * Convierte un objeto Jugador a JugadorDTO.
     * @param entity Entidad Jugador.
     * @return DTO de jugador.
     */
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

    /**
     * Convierte una lista de Jugador a una lista de JugadorDTO.
     * @param entityList Lista de entidades Jugador.
     * @return Lista de DTOs de jugador.
     */
    public static ArrayList<JugadorDTO> listJugadorToListJugadorDTO(ArrayList<Jugador> entityList) {
        ArrayList<JugadorDTO> dtoJugadorList = new ArrayList<>();
        for (Jugador jugador : entityList) {
            dtoJugadorList.add(jugadorToJugadorDTO(jugador));
        }
        return dtoJugadorList;
    }

    /**
     * Convierte una lista de JugadorDTO a una lista de Jugador.
     * @param dtoListJugador Lista de DTOs de jugador.
     * @return Lista de entidades Jugador.
     */
    public static ArrayList<Jugador> listJugadorDTOToListJugador(ArrayList<JugadorDTO> dtoListJugador) {
        ArrayList<Jugador> entityListJugador = new ArrayList<>();
        for (JugadorDTO jugadorDTO : dtoListJugador) {
            entityListJugador.add(jugadorDTOToJugador(jugadorDTO));
        }
        return entityListJugador;
    }

    // TorneoLiga

    /**
     * Convierte un objeto TorneoLiga a TorneoLigaDTO.
     * @param torneo Entidad TorneoLiga.
     * @return DTO de torneo liga.
     */
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

    /**
     * Convierte un objeto TorneoLigaDTO a TorneoLiga.
     * @param dto DTO de torneo liga.
     * @return Entidad TorneoLiga.
     */
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

    /**
     * Convierte una lista de TorneoLiga a una lista de TorneoLigaDTO.
     * @param lista Lista de entidades TorneoLiga.
     * @return Lista de DTOs de torneo liga.
     */
    public static ArrayList<TorneoLigaDTO> listaTorneoLigaToListaTorneoLigaDTO(ArrayList<TorneoLiga> lista) {
        ArrayList<TorneoLigaDTO> dtoList = new ArrayList<>();
        for (TorneoLiga torneo : lista) {
            dtoList.add(torneoLigaToTorneoLigaDTO(torneo));
        }
        return dtoList;
    }

    /**
     * Convierte una lista de TorneoLigaDTO a una lista de TorneoLiga.
     * @param lista Lista de DTOs de torneo liga.
     * @return Lista de entidades TorneoLiga.
     */
    public static ArrayList<TorneoLiga> listaTorneoLigaDTOToListaTorneoLiga(ArrayList<TorneoLigaDTO> lista) {
        ArrayList<TorneoLiga> torneoList = new ArrayList<>();
        for (TorneoLigaDTO dto : lista) {
            torneoList.add(torneoLigaDTOToTorneoLiga(dto));
        }
        return torneoList;
    }

    // TorneoLlave

    /**
     * Convierte un objeto TorneoLlave a TorneoLlaveDTO.
     * @param torneo Entidad TorneoLlave.
     * @return DTO de torneo llave.
     */
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

    /**
     * Convierte un objeto TorneoLlaveDTO a TorneoLlave.
     * @param dto DTO de torneo llave.
     * @return Entidad TorneoLlave.
     */
    public static TorneoLlave torneoLlaveDTOToTorneoLlave(TorneoLlaveDTO dto) {
        if (dto == null) return null;
        TorneoLlave entity;
        entity = new TorneoLlave(
            dto.getNombre(),
            dto.getJuego(),
            dto.getEquipos()
            // dto.getPartidas(),
            // dto.getGanador(),
            // dto.getCantidadFase()
        );
        return entity;
    }

    /**
     * Convierte una lista de TorneoLlave a una lista de TorneoLlaveDTO.
     * @param lista Lista de entidades TorneoLlave.
     * @return Lista de DTOs de torneo llave.
     */
    public static ArrayList<TorneoLlaveDTO> listaTorneoLlaveToListaTorneoLlaveDTO(ArrayList<TorneoLlave> lista) {
        ArrayList<TorneoLlaveDTO> dtoList = new ArrayList<>();
        for (TorneoLlave torneo : lista) {
            dtoList.add(torneoLlaveToTorneoLlaveDTO(torneo));
        }
        return dtoList;
    }

    /**
     * Convierte una lista de TorneoLlaveDTO a una lista de TorneoLlave.
     * @param lista Lista de DTOs de torneo llave.
     * @return Lista de entidades TorneoLlave.
     */
    public static ArrayList<TorneoLlave> listaTorneoLlaveDTOToListaTorneoLlave(ArrayList<TorneoLlaveDTO> lista) {
        ArrayList<TorneoLlave> torneoList = new ArrayList<>();
        for (TorneoLlaveDTO dto : lista) {
            torneoList.add(torneoLlaveDTOToTorneoLlave(dto));
        }
        return torneoList;
    }
}
