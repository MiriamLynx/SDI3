package impl.sdi.business.classes.usuarios;

import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class InsertarUsuario {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param validado
	 * @param password
	 * @param privilegios
	 * @throws BusinessException
	 *             , en caso de que el id ya exista en la bbdd.
	 */
	public void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios)
			throws BusinessException {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		dao.insertarUsuario(id, nombre, apellidos, correo, validado, password,
				privilegios);

	}
}
