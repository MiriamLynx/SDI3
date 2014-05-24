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
public class ActivarUsuario {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param id
	 * @return usuario activado.
	 */
	public Usuario activarUsuario(String id) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.activarUsuario(id);
	}

}
