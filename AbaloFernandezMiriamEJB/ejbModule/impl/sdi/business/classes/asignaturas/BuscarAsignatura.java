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
public class BuscarAsignatura {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param nombre_buscado
	 * @return listado de asignaturas con ese nombre.
	 */
	public List<Asignatura> buscar(String nombre_buscado) {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.buscarAsignaturas(nombre_buscado);
	}

}
