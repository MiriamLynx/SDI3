package impl.sdi.business.classes.asignaturas;

import java.util.List;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.persistence.AsignaturaDao;

/**
 * Clase que crea el dao correspondiente y llama al metodo que procede.
 * 
 * @author UO217345
 * 
 */
public class AsignaturasListado {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @return listado de asignaturas de la bbdd.
	 */
	public List<Asignatura> getAsignaturas() {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.getAsignaturas();
	}
}
