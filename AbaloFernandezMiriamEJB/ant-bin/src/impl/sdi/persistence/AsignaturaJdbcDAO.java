package impl.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;
import com.sdi.persistence.AsignaturaDao;

public class AsignaturaJdbcDAO implements AsignaturaDao {

	private AsignaturaJdbc jdbcAsignatura = null;

	public AsignaturaJdbc getJdbcAsignatura() {
		return jdbcAsignatura;
	}

	public void setJdbcAsignatura(AsignaturaJdbc jdbcAsignatura) {
		this.jdbcAsignatura = jdbcAsignatura;
	}

	public AsignaturaJdbcDAO() {
		setJdbcAsignatura(new AsignaturaJdbc());
	}

	@Override
	public List<Asignatura> getAsignaturas() {
		return new AsignaturaJdbc().getAsignaturas();
	}

	@Override
	public List<Usuario> getAlumnos(String idAsignatura) {
		return new AsignaturaJdbc().getAlumnos(idAsignatura);
	}

	@Override
	public Asignatura eliminarAsignatura(String idAsignatura) {
		return new AsignaturaJdbc().eliminarAsignatura(idAsignatura);
	}

	@Override
	public Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos) {
		return new AsignaturaJdbc().nuevaAsignatura(nuevo_codigo, nuevo_nombre,
				nuevo_curso, nuevo_creditos);
	}

	@Override
	public void asignarAlumno(String idAlumno, String idAsignatura) {
		new AsignaturaJdbc().asignarAlumno(idAlumno, idAsignatura);
	}

	@Override
	public void asignarProfesor(String idProfesor, String idAsignatura) {
		new AsignaturaJdbc().asignarProfesor(idProfesor, idAsignatura);
	}

	@Override
	public List<Asignatura> buscarAsignaturas(String nombre_buscado) {
		return new AsignaturaJdbc().buscarAsignaturas(nombre_buscado);
	}

}
