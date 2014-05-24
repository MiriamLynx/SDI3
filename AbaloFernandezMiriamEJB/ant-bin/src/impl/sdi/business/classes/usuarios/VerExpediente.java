package impl.sdi.business.classes.usuarios;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Matricula;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class VerExpediente {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param idAlumno
	 * @return listado de matriculas de un alumno.
	 */
	public List<Matricula> verExpediente(String idAlumno) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.getExpediente(idAlumno);
	}

}
