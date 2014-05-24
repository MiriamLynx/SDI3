package impl.sdi.business.classes.usuarios;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class ActualizarPerfil {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param password
	 * @param privilegios
	 */
	public void actualizarPerfil(String id, String nombre, String apellidos,
			String email, String password, String privilegios) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		dao.actualizarPerfil(id, nombre, apellidos, email);

	}
}
