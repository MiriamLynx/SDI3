package impl.sdi.business.classes.asignaturas;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class AsignarAlumno {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public AsignarAlumno(String idAlumno, String idAsignatura) {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		dao.asignarAlumno(idAlumno, idAsignatura);
	}

}
