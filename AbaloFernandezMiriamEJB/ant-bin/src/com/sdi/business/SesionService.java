package com.sdi.business;

import java.sql.SQLException;

import com.sdi.model.Usuario;

/**
 * Clase que crea clases de business y llama a sus metodos.
 * 
 * @author UO217345
 * 
 */
public interface SesionService {

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * @param idUsuario
	 * @param password
	 * @return usuario que se corresponde con los datos.
	 * @throws SQLException en caso de no encontrar el usuario.
	 */
	Usuario validar(String idUsuario, String password) throws SQLException;

}
