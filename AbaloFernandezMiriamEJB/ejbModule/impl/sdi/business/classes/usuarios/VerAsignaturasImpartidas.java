package impl.sdi.business.classes.usuarios;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class VerAsignaturasImpartidas {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param id
	 * @return listado de asignaturas de la bbdd.
	 */
	public List<Asignatura> getAsignaturas(String id) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.verAsignaturasImpartidas(id);
	}

}
