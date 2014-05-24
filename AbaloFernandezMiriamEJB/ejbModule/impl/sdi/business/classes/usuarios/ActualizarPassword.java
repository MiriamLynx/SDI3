package impl.sdi.business.classes.usuarios;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class ActualizarPassword {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param id
	 * @param nuevo_password
	 */
	public void actualizarPassword(String id, String nuevo_password) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		dao.actualizarPassword(id, nuevo_password);
	}

}
