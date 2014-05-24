package impl.sdi.business.classes.usuarios;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class UsuarioValidar {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @param password
	 * @return el usuario logueado.
	 */
	public Usuario validar(String id, String password) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.validar(id, password);
	}

}
