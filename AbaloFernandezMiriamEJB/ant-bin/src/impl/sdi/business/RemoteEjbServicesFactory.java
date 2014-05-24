package impl.sdi.business;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sdi.business.AsignaturasService;
import com.sdi.business.ServicesFactory;
import com.sdi.business.SesionService;
import com.sdi.business.UsuariosService;

public class RemoteEjbServicesFactory implements ServicesFactory {

	private static final String USUARIOS_SERVICE_JNDI_KEY = "ejb:AbaloFernandezMiriamEAR/AbaloFernandezMiriamEJB/EjbUsuariosService!impl.sdi.business.remote.UsuariosServiceRemote";
	private static final String ASIGNATURAS_SERVICE_JNDI_KEY = "ejb:AbaloFernandezMiriamEAR/AbaloFernandezMiriamEJB/EjbAsignaturasService!impl.sdi.business.remote.AsignaturasServiceRemote";
	private static final String SESION_SERVICE_JNDI_KEY = "ejb:AbaloFernandezMiriamEAR/AbaloFernandezMiriamEJB/EjbSesionService!impl.sdi.business.remote.SesionServiceRemote";

	@Override
	public UsuariosService createUsuariosService() {
		try {
			Context ctx = new InitialContext();
			return (UsuariosService) ctx.lookup(USUARIOS_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public AsignaturasService createAsignaturasService() {
		try {
			Context ctx = new InitialContext();
			return (AsignaturasService) ctx
					.lookup(ASIGNATURAS_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public SesionService createSesionService() {
		try {
			Context ctx = new InitialContext();
			return (SesionService) ctx.lookup(SESION_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

}
