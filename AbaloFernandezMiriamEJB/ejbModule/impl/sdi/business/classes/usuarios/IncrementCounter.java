package impl.sdi.business.classes.usuarios;

import com.sdi.infrastructure.Factories;
import com.sdi.persistence.UsuarioDao;

public class IncrementCounter {

	/**
	 * Crea el dao y llama al metodo correspondiente.
	 * 
	 * @param id
	 */
	public void increment(String id) {
		UsuarioDao dao = Factories.persistence.createUsuarioDao();
		dao.incrementCounter(id);

	}

}
