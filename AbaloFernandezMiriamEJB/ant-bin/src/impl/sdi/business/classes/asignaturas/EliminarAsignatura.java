package impl.sdi.business.classes.asignaturas;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class EliminarAsignatura {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param idAsignatura
	 * @return asignatura eliminada.
	 */
	public Asignatura eliminarAsignatura(String idAsignatura) {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.eliminarAsignatura(idAsignatura);
	}

}
