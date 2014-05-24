package impl.sdi.business.classes.usuarios;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class BuscarUsuariosActivados {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param criterio_buscado
	 * @return listado de usuarios con ese nombre o apellido.
	 */
	public List<Usuario> buscarUsuarios(String criterio_buscado) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.buscarUsuariosActivados(criterio_buscado);
	}

}
