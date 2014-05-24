package impl.sdi.business;

import impl.sdi.business.classes.usuarios.UsuarioValidar;
import impl.sdi.business.local.SesionServiceLocal;
import impl.sdi.business.remote.SesionServiceRemote;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.jws.WebService;

import com.sdi.model.Usuario;

@Stateless
@WebService
public class EjbSesionService implements SesionServiceLocal,
		SesionServiceRemote {

	@Override
	public Usuario validar(String idUsuario, String password)
			throws SQLException {
		return new UsuarioValidar().validar(idUsuario, password);
	}

}
