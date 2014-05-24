package impl.sdi.business.classes.asignaturas;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class AsignarProfesor {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param idProfesor
	 * @param idAsignatura
	 */
	public AsignarProfesor(String idProfesor, String idAsignatura) {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		dao.asignarProfesor(idProfesor, idAsignatura);
	}
}
