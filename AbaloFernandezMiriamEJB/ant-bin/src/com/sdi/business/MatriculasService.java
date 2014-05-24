package com.sdi.business;

import java.util.List;

import com.sdi.model.Matricula;

/**
 * Clase que crea clases de business y llama a sus metodos.
 * 
 * @author UO217345
 * 
 */
public interface MatriculasService {

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @return listado de matriculas en la bbdd.
	 */
	List<Matricula> getMatriculas();

}