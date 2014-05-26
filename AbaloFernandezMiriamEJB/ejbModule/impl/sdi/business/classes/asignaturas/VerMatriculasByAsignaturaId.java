package impl.sdi.business.classes.asignaturas;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Matricula;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class VerMatriculasByAsignaturaId {
	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return listado de matriculas en la asignatura.
	 */
	public List<Matricula> getMatriculasByAsignaturaId(String idAsignatura) {

		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.getMatriculasByAsignaturaId(idAsignatura);
	}

}
