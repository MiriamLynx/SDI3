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
public class NuevaAsignatura {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param nuevo_codigo
	 * @param nuevo_nombre
	 * @param nuevo_curso
	 * @param nuevo_creditos
	 * @return nueva asignatura.
	 */
	public Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos) {
		AsignaturaDao dao = Factories.persistence.createAsignaturaDao();
		return dao.nuevaAsignatura(nuevo_codigo, nuevo_nombre, nuevo_curso,
				nuevo_creditos);
	}

}
