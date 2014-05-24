package com.sdi.business;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Clase que crea clases de business y llama a sus metodos.
 * 
 * @author UO217345
 * 
 */
public interface AsignaturasService {

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @return listado de todas las asignaturas en la bbdd.
	 */
	List<Asignatura> getAsignaturas();

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param id
	 *            , del profesor.
	 * @return lista de asignaturas que imparte un profesor.
	 */
	List<Asignatura> getAsignaturasByProfesorId(String id);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idAsignatura
	 *            .
	 * @return lista de alumnos matriculados en una asignatura.
	 */
	List<Usuario> getAlumnos(String idAsignatura);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idAsignatura
	 *            .
	 * @return la asignatura que ha sido eliminada.
	 */
	Asignatura eliminarAsignaturas(String idAsignatura);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param nuevo_codigo
	 * @param nuevo_nombre
	 * @param nuevo_curso
	 * @param nuevo_creditos
	 * @return la asignatura creada.
	 */
	Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idAlumno
	 * @param idAsignatura
	 */
	void asignarAlumno(String idAlumno, String idAsignatura);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idProfesor
	 * @param idAsignatura
	 */
	void asignarProfesor(String idProfesor, String idAsignatura);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param nombre_buscado
	 * @return listado de asignaturas con ese nombre.
	 */
	List<Asignatura> buscarAsignaturas(String nombre_buscado);

}