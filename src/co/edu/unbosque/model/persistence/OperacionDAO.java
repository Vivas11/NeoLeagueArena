package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Interfaz que define las operaciones básicas para un DAO (Data Access Object).
 * Estas operaciones incluyen métodos para crear, eliminar, actualizar, mostrar todos los
 * objetos, y métodos para cargar y guardar los datos serializados.
 * @param <D> DTO genérico de los objetos que serán gestionados por el DAO.
 * @param <E> Entidad genérico de los objetos que serán gestionados por el DAO.
 */
public interface OperacionDAO<D, E> {

    /**
     * Muestra todos los objetos gestionados por el DAO en formato String.
     * @return Cadena con la información de todos los objetos.
     */
    public String showAll();

    /**
     * Obtiene todos los objetos gestionados por el DAO en formato DTO.
     * @return Lista de DTOs.
     */
    public ArrayList<D> getAll();

    /**
     * Agrega un nuevo objeto al DAO.
     * @param newData Objeto DTO a agregar.
     * @return true si se agregó correctamente, false si ya existe.
     */
    public boolean add(D newData);

    /**
     * Elimina un objeto del DAO.
     * @param toDelete Objeto DTO a eliminar.
     * @return true si se eliminó correctamente, false si no existe.
     */
    public boolean delete(D toDelete);

    /**
     * Busca un objeto en el DAO.
     * @param toFind Objeto entidad a buscar.
     * @return El objeto encontrado o null si no existe.
     */
    public E find(E toFind);

    /**
     * Actualiza un objeto existente en el DAO.
     * @param previous Objeto DTO anterior.
     * @param newData Objeto DTO con los nuevos datos.
     * @return true si se actualizó correctamente, false si no existe.
     */
    public boolean update(D previous, D newData);
}

