package impl.sdi.persistence;

import com.sdi.persistence.AsignaturaDao;
import com.sdi.persistence.PersistenceFactory;
import com.sdi.persistence.UsuarioDao;

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UsuarioDao createUsuarioDao() {
		return new UsuarioJdbcDAO();
	}

	@Override
	public AsignaturaDao createAsignaturaDao() {
		return new AsignaturaJdbcDAO();
	}

}
