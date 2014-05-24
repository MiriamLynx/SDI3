package com.sdi.business;

import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

/**
 * Clase que crea clases de business y llama a sus metodos.
 * 
 * @author UO217345
 * 
 */
public interface UsuariosService {

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @return
	 */
	List<Usuario> getProfesores();

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param validado
	 * @param password
	 * @param privilegios
	 * @throws BusinessException
	 *             en caso de que el id ya exista en la bbdd.
	 */
	void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios)
			throws BusinessException;

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param usuario
	 *            , el que se va a actualizar.
	 */
	void actualizarPerfil(Usuario usuario);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param id
	 *            , del usuario dueño de la password.
	 * @param nuevo_password
	 */
	void actualizarPassword(String id, String nuevo_password);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idAsignatura
	 * @param idAlumno
	 * @param nota
	 */
	void actualizarNota(String idAsignatura, String idAlumno, int nota);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param idAlumno
	 * @return lista de matriculas del alumno.
	 */
	List<Matricula> verExpediente(String idAlumno);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @return lista de usuarios activados en la bbdd.
	 */
	List<Usuario> verUsuariosActivados();

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @return lista de usuarios desactivados en la bbdd.
	 */
	List<Usuario> verUsuariosDesactivados();

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param id
	 *            , del usuario.
	 * @return usuario activado.
	 */
	Usuario activarUsuario(String id);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param id
	 *            , del usuario.
	 * @return usuario desactivado.
	 */
	Usuario desactivarUsuario(String id);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param criterio_buscado
	 * @return listado de profesores con ese nombre u apellido.
	 */
	List<Usuario> buscarProfesores(String criterio_buscado);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param criterio_buscado
	 * @return listado de usuarios activados.
	 */
	List<Usuario> buscarUsuariosActivados(String criterio_buscado);

	/**
	 * Crea una nueva clase de business y llama a su metodo.
	 * 
	 * @param criterio_buscado
	 * @return listado de usuarios desactivados.
	 */
	List<Usuario> buscarUsuariosDesactivados(String criterio_buscado);

}