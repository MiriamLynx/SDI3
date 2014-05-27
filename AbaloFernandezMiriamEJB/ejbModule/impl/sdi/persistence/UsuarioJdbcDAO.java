package impl.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

public class UsuarioJdbcDAO implements UsuarioDao {

	private UsuarioJdbc jdbcUsuario = null;

	public UsuarioJdbc getJdbcUsuario() {
		return jdbcUsuario;
	}

	public void setJdbcUsuario(UsuarioJdbc jdbcUsuario) {
		this.jdbcUsuario = jdbcUsuario;
	}

	public UsuarioJdbcDAO() {
		setJdbcUsuario(new UsuarioJdbc());
	}

	@Override
	public List<Usuario> getProfesores() {
		return new UsuarioJdbc().getProfesores();
	}

	@Override
	public Usuario findById(String id) {
		return new UsuarioJdbc().getUsuarioById(id);
	}

	@Override
	public Usuario validar(String id, String password) {
		return new UsuarioJdbc().validar(id, password);
	}

	@Override
	public void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios) {
		new UsuarioJdbc().insertarUsuario(id, nombre, apellidos, correo,
				validado, password, privilegios);
	}

	@Override
	public void actualizarPerfil(String id, String nombre, String apellidos,
			String email) {
		new UsuarioJdbc().actualizarPerfil(id, nombre, apellidos, email);
	}

	@Override
	public void actualizarPassword(String id, String nuevo_password) {
		new UsuarioJdbc().actualizarPassword(id, nuevo_password);
	}

	@Override
	public List<Asignatura> verAsignaturasImpartidas(String id) {
		return new UsuarioJdbc().getAsignaturasByProfesorId(id);
	}

	@Override
	public int actualizarNota(String idAsignatura, String idAlumno, int nota) {
		return new UsuarioJdbc().actualizarNota(idAsignatura, idAlumno, nota);
	}

	@Override
	public List<Matricula> getExpediente(String idAlumno) {
		return new UsuarioJdbc().verExpediente(idAlumno);
	}

	@Override
	public List<Usuario> verUsuariosActivados() {
		return new UsuarioJdbc().verUsuariosActivados();
	}

	@Override
	public List<Usuario> verUsuariosDesactivados() {
		return new UsuarioJdbc().verUsuariosDesactivados();
	}

	@Override
	public Usuario desactivarUsuario(String id) {
		return new UsuarioJdbc().desactivarUsuario(id);
	}

	@Override
	public Usuario activarUsuario(String id) {
		return new UsuarioJdbc().activarUsuario(id);
	}

	@Override
	public List<Usuario> buscarUsuario(String criterio_buscado) {
		return new UsuarioJdbc().buscarProfesores(criterio_buscado);
	}

	@Override
	public List<Usuario> buscarUsuariosDesactivados(String criterio_buscado) {
		return new UsuarioJdbc().buscarUsuariosDesctivados(criterio_buscado);
	}

	@Override
	public List<Usuario> buscarUsuariosActivados(String criterio_buscado) {
		return new UsuarioJdbc().buscarUsuariosActivados(criterio_buscado);
	}

	@Override
	public List<Usuario> getAlumnos() {
		return new UsuarioJdbc().getAlumnos();
	}
}
