package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

/**
 * Dao de la tabla Tusuarios, crea clases JDBCs y llama a los metodos
 * correspondientes.
 * 
 * @author UO217345
 * 
 */
public interface UsuarioDao {

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 *            , del usuario.
	 * @return usuario buscado.
	 */
	Usuario findById(String id);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de profesores de la bbdd.
	 */
	List<Usuario> getProfesores();

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 *            , del usuario.
	 * @param password
	 * @return usuario logueado.
	 */
	Usuario validar(String id, String password);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param validado
	 * @param password
	 * @param privilegios
	 */
	void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 */
	void actualizarPerfil(String id, String nombre, String apellidos,
			String email);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @param nuevo_password
	 */
	void actualizarPassword(String id, String nuevo_password);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 *            , del profesor.
	 * @return listado de asignaturas que imparte un profesor.
	 */
	List<Asignatura> verAsignaturasImpartidas(String id);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @param idAlumno
	 * @param nota
	 * @return nota nueva.
	 */
	int actualizarNota(String idAsignatura, String idAlumno, int nota);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param idAlumno
	 * @return listado de matriculas del alumno.
	 */
	List<Matricula> getExpediente(String idAlumno);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de usuarios activados de la bbdd.
	 */
	List<Usuario> verUsuariosActivados();

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de usuarios desactivados de la bbdd.
	 */
	List<Usuario> verUsuariosDesactivados();

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 *            , del usuario.
	 * @return usuario desactivado.
	 */
	Usuario desactivarUsuario(String id);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param id
	 *            , del usuario.
	 * @return usuario activado.
	 */
	Usuario activarUsuario(String id);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param criterio_buscado
	 * @return usuario activado.
	 */
	List<Usuario> buscarUsuario(String criterio_buscado);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param criterio_buscado
	 * @return listado de usuarios desactivados con ese nombre o apellido..
	 */
	List<Usuario> buscarUsuariosDesactivados(String criterio_buscado);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @param criterio_buscado
	 * @return listado de usuarios activados con ese nombre o apellido.
	 */
	List<Usuario> buscarUsuariosActivados(String criterio_buscado);

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * 
	 * @return listado de alumnos.
	 */
	List<Usuario> getAlumnos();

	/**
	 * Crea una clase JDBC y llama al metodo correspondiente.
	 * @param id 
	 * 
	 */
	void incrementCounter(String id);

}