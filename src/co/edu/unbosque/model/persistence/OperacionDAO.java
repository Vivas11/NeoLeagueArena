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

	public String showAll();
	
	public ArrayList<D> getAll();
	
	public boolean add(D newData);
	
	public boolean delete(D toDelete);
	
	public E find(E toFind);
	
	public boolean update(D previous, D newData);
}

