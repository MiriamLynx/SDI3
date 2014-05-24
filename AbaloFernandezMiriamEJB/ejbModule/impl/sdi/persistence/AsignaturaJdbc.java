package impl.sdi.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdi.business.exception.BusinessException;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;
import com.sdi.persistence.exception.PersistenceException;

/**
 * Clase que realiza las consultas a la bbdd sobre la clase Tasignaturas.
 * 
 * @author UO217345
 * 
 */
public class AsignaturaJdbc {

	private static final String CONFIG_FILE = "/persistence.properties";

	private static JdbcHelper jdbc = new JdbcHelper(CONFIG_FILE);

	private static Connection c = null;

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @return listado de asignaturas de la bbdd.
	 */
	public List<Asignatura> getAsignaturas() {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		Statement st = null;
		ResultSet rs = null;
		try {
			c = jdbc.createConnection();
			st = c.createStatement();
			rs = st.executeQuery(jdbc.getSql("LISTAR_ASIGNATURAS"));
			while (rs.next()) {
				String id = rs.getString("id");
				Asignatura asignatura = new Asignatura(id,
						rs.getString("nombre"), rs.getInt("creditos"),
						rs.getString("curso"));
				List<Usuario> misProfesores = getProfesoresByAsignaturaId(id);
				asignatura.setProfesores(misProfesores);
				asignaturas.add(asignatura);

			}
			jdbc.close(rs, st);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}

		return asignaturas;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return listado de profesores de una asignatura.
	 */
	public static List<Usuario> getProfesoresByAsignaturaId(String idAsignatura) {

		List<Usuario> profesores = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("GET_PROFESORES_BY_ASIGNATURA_ID"));
			ps.setString(1, idAsignatura);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario profesor = new Usuario(rs.getString("id"),
						rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("correo"), rs.getString("password"),
						rs.getBoolean("validado"), rs.getString("privilegios"));
				profesores.add(profesor);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return profesores;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return listado de alumnos de una asignatura.
	 */
	public List<Usuario> getAlumnos(String idAsignatura) {
		List<Usuario> alumnos = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("GET_ALUMNOS_BY_ASIGNATURA_ID"));
			ps.setString(1, idAsignatura);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario alumno = new Usuario(rs.getString("id"),
						rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("correo"), rs.getString("password"),
						rs.getBoolean("validado"), rs.getString("privilegios"));
				alumno.setNota(getNota(rs.getString("id"), idAsignatura));
				alumnos.add(alumno);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return alumnos;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAlumno
	 * @param idAsignatura
	 * @return nueva nota.
	 */
	public int getNota(String idAlumno, String idAsignatura) {
		int nota = Integer.MAX_VALUE;
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("GET_NOTA_BY_ALUMNO_ID"));
			ps.setString(1, idAlumno);
			ps.setString(2, idAsignatura);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nota = rs.getInt("calificacion");
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return nota;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return asignatura eliminada.
	 */
	public Asignatura eliminarAsignatura(String idAsignatura) {
		Asignatura asignatura = null;
		try {
			c = jdbc.createConnection();
			asignatura = getAsignaturaById(idAsignatura);
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("ELIMINAR_ASIGNATURA_BY_ID"));
			ps.setString(1, idAsignatura);
			ps.executeUpdate();
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Esta asignatura tiene dependencias");
		}
		return asignatura;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return asignatura con ese id.
	 * @throws SQLException
	 *             en caso de error en la consulta.
	 */
	public static Asignatura getAsignaturaById(String idAsignatura)
			throws SQLException {
		c = jdbc.createConnection();
		PreparedStatement ps = c.prepareStatement(jdbc
				.getSql("GET_ASIGNATURA_BY_ID"));
		ps.setString(1, idAsignatura);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Asignatura asignatura = new Asignatura(rs.getString("id"),
					rs.getString("nombre"), rs.getInt("creditos"),
					rs.getString("curso"));
			return asignatura;
		}
		jdbc.close(rs, ps);
		jdbc.close(c);
		return null;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param nuevo_codigo
	 * @param nuevo_nombre
	 * @param nuevo_curso
	 * @param nuevo_creditos
	 * @return asignatura nueva.
	 */
	public Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos) {
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("INSERTAR_ASIGNATURA"));
			ps.setString(1, nuevo_codigo);
			ps.setString(2, nuevo_nombre);
			ps.setString(3, nuevo_curso);
			ps.setInt(4, nuevo_creditos);
			ps.executeUpdate();
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Valores invalidos");
		}
		return new Asignatura(nuevo_codigo, nuevo_nombre, nuevo_creditos,
				nuevo_curso);
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idProfesor
	 * @param idAsignatura
	 */
	public void asignarProfesor(String idProfesor, String idAsignatura) {
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("INSERTAR_IMPARTICION"));
			ps.setString(1, idProfesor);
			ps.setString(2, idAsignatura);
			ps.executeUpdate();
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Valores invalidos");
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAlumno
	 * @param idAsignatura
	 */
	public void asignarAlumno(String idAlumno, String idAsignatura) {
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("INSERTAR_MATRICULA"));
			ps.setInt(1, 12);
			ps.setString(2, idAlumno);
			ps.setString(3, idAsignatura);
			ps.executeUpdate();
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Valores invalidos");
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param nombre_buscado
	 * @return listado de asignaturas con ese nombre.
	 */
	public List<Asignatura> buscarAsignaturas(String nombre_buscado) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("BUSCAR_ASIGNATURAS"));
			ps.setString(1, nombre_buscado);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				Asignatura asignatura = new Asignatura(id,
						rs.getString("nombre"), rs.getInt("creditos"),
						rs.getString("curso"));
				List<Usuario> misProfesores = getProfesoresByAsignaturaId(id);
				asignatura.setProfesores(misProfesores);
				asignaturas.add(asignatura);

			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Valores invalidos");
		}
		return asignaturas;
	}

}
