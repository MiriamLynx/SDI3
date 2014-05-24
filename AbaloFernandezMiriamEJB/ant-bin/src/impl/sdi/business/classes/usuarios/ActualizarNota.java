package impl.sdi.business.classes.usuarios;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class ActualizarNota {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param idAsignatura
	 * @param idAlumno
	 * @param nota
	 * @return nueva nota.
	 */
	public int actualizarNota(String idAsignatura, String idAlumno, int nota) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		return dao.actualizarNota(idAsignatura, idAlumno, nota);
	}

}
