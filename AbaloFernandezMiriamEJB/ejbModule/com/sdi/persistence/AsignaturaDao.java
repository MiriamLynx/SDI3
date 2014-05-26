package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

/**
 * Dao de la tabla Tasignaturas, crea clases JDBCs y llama a los metodos
 * correspondientes.
 * 
 * @author UO217345
 * 
 */
public interface AsignaturaDao {

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de asignaturas de la bbdd.
	 */
	List<Asignatura> getAsignaturas();

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return listado de alumnos de esa asignatura.
	 */
	List<Usuario> getAlumnos(String idAsignatura);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param nuevo_codigo
	 * @param nuevo_nombre
	 * @param nuevo_curso
	 * @param nuevo_creditos
	 * @return asignatura creada.
	 */
	Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAlumno
	 * @param idAsignatura
	 */
	void asignarAlumno(String idAlumno, String idAsignatura);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idProfesor
	 * @param idAsignatura
	 */
	void asignarProfesor(String idProfesor, String idAsignatura);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param nombre_buscado
	 * @return listado de asignaturas con ese nombre.
	 */
	List<Asignatura> buscarAsignaturas(String nombre_buscado);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return asignatura eliminada.
	 */
	Asignatura eliminarAsignatura(String idAsignatura);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return asignatura eliminada.
	 */
	List<Matricula> getMatriculasByAsignaturaId(String idAsignatura);

}