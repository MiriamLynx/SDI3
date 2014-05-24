package impl.sdi.business;

import impl.sdi.business.classes.usuarios.ActivarUsuario;
import impl.sdi.business.classes.usuarios.ActualizarNota;
import impl.sdi.business.classes.usuarios.ActualizarPassword;
import impl.sdi.business.classes.usuarios.ActualizarPerfil;
import impl.sdi.business.classes.usuarios.BuscarProfesores;
import impl.sdi.business.classes.usuarios.BuscarUsuariosActivados;
import impl.sdi.business.classes.usuarios.BuscarUsuariosDesactivados;
import impl.sdi.business.classes.usuarios.DesactivarUsuario;
import impl.sdi.business.classes.usuarios.InsertarUsuario;
import impl.sdi.business.classes.usuarios.ProfesoresListado;
import impl.sdi.business.classes.usuarios.VerExpediente;
import impl.sdi.business.classes.usuarios.VerUsuariosActivados;
import impl.sdi.business.classes.usuarios.VerUsuariosDesactivados;
import impl.sdi.business.local.UsuariosServiceLocal;
import impl.sdi.business.remote.UsuariosServiceRemote;

import java.util.List;

import javax.ejb.Stateless;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

@Stateless
public class EjbUsuariosService implements UsuariosServiceLocal,
		UsuariosServiceRemote {

	@Override
	public List<Usuario> getProfesores() {
		return new ProfesoresListado().getProfesores();
	}

	@Override
	public void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios)
			throws BusinessException {
		new InsertarUsuario().insertarUsuario(id, nombre, apellidos, correo,
				validado, password, privilegios);
	}

	@Override
	public void actualizarPerfil(Usuario usuario) {
		new ActualizarPerfil().actualizarPerfil(usuario.getId(),
				usuario.getNombre(), usuario.getApellidos(),
				usuario.getEmail(), usuario.getPassword(),
				usuario.getPrivilegios());
	}

	@Override
	public void actualizarPassword(String id, String nuevo_password) {
		new ActualizarPassword().actualizarPassword(id, nuevo_password);
	}

	@Override
	public void actualizarNota(String idAsignatura, String idAlumno, int nota) {
		new ActualizarNota().actualizarNota(idAsignatura, idAlumno, nota);
	}

	@Override
	public List<Matricula> verExpediente(String idAlumno) {
		return new VerExpediente().verExpediente(idAlumno);
	}

	@Override
	public List<Usuario> verUsuariosActivados() {
		return new VerUsuariosActivados().verUsuariosActivados();
	}

	@Override
	public List<Usuario> verUsuariosDesactivados() {
		return new VerUsuariosDesactivados().verUsuariosDesactivados();
	}

	@Override
	public Usuario activarUsuario(String id) {
		return new ActivarUsuario().activarUsuario(id);
	}

	@Override
	public Usuario desactivarUsuario(String id) {
		return new DesactivarUsuario().desactivarUsuario(id);
	}

	@Override
	public List<Usuario> buscarProfesores(String criterio_buscado) {
		return new BuscarProfesores().buscarProfesores(criterio_buscado);
	}

	@Override
	public List<Usuario> buscarUsuariosActivados(String criterio_buscado) {
		return new BuscarUsuariosActivados().buscarUsuarios(criterio_buscado);
	}

	@Override
	public List<Usuario> buscarUsuariosDesactivados(String criterio_buscado) {
		return new BuscarUsuariosDesactivados()
				.buscarUsuarios(criterio_buscado);
	}
}
