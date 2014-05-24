package impl.sdi.business.classes.asignaturas;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Usuario;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class VerAlumnosMatriculados {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return listado de alumnos de la asignatura.
	 */
	public List<Usuario> getAlumnos(String idAsignatura) {

		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.getAlumnos(idAsignatura);
	}

}
