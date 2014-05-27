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
public class AlumnosListado {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @return listado de profesores en la bbdd.
	 */
	public List<Usuario> getAlumnos() {

		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.getAlumnos();

	}
}
