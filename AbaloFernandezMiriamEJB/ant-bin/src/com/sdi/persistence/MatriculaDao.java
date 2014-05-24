package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Matricula;

/**
 * Dao de la tabla Tmatriculas, crea clases JDBCs y llama a los metodos
 * correspondientes.
 * 
 * @author UO217345
 * 
 */
public interface MatriculaDao {

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de matriculas de la bbdd.
	 */
	List<Matricula> getMatriculas();

}