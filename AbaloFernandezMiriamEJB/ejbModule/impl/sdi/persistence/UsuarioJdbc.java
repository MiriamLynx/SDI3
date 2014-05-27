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
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;
import com.sdi.persistence.exception.PersistenceException;

/**
 * Clase que realiza las consultas a la bbdd sobre la clase Tasignaturas.
 * 
 * @author UO217345
 * 
 */
public class UsuarioJdbc {

	private static final String CONFIG_FILE = "/persistence.properties";

	private static JdbcHelper jdbc = new JdbcHelper(CONFIG_FILE);

	private static Connection c = null;

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @return listado de profesores.
	 */
	public List<Usuario> getProfesores() {
		List<Usuario> profesores = new ArrayList<Usuario>();
		Statement st = null;
		ResultSet rs = null;

		try {
			c = jdbc.createConnection();
			st = c.createStatement();
			rs = st.executeQuery(jdbc.getSql("LISTAR_PROFESORES"));
			while (rs.next()) {
				String id = rs.getString("id");
				Usuario profesor = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				List<Asignatura> misAsignaturas = getAsignaturasByProfesorId(id);
				profesor.setAsignaturas(misAsignaturas);
				profesores.add(profesor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			jdbc.close(rs, st);
			jdbc.close(c);
		}

		return profesores;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @return listado de asignaturas de un profesor.
	 */
	public List<Asignatura> getAsignaturasByProfesorId(String id) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc
					.getSql("GET_ASIGNATURAS_BY_PROFESOR_ID"));
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Asignatura asignatura = new Asignatura(rs.getString("id"),
						rs.getString("nombre"), rs.getInt("creditos"),
						rs.getString("curso"));
				asignaturas.add(asignatura);
			}
			jdbc.close(rs, ps);
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
	 * @param id
	 * @return usuario con ese id.
	 */
	public Usuario getUsuarioById(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("GET_USUARIO_BY_ID"));
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			jdbc.close(rs, ps);
			jdbc.close(c);
		}
		return null;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @param password
	 * @return usuario logueado.
	 */
	public Usuario validar(String id, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("GET_VALIDATED_USER"));
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			jdbc.close(rs, ps);
			jdbc.close(c);
		}
		return null;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param validado
	 * @param password
	 * @param privilegios
	 */
	public void insertarUsuario(String id, String nombre, String apellidos,
			String correo, boolean validado, String password, String privilegios) {
		PreparedStatement ps = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("INSERTAR_USUARIO"));
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, correo);
			ps.setString(5, password);
			ps.setString(6, privilegios);
			ps.setBoolean(7, false);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Invalid values", e);
		} finally {
			jdbc.close(ps);
			jdbc.close(c);
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 */
	public void actualizarPerfil(String id, String nombre, String apellidos,
			String email) {
		PreparedStatement ps = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("MODIFICAR_USUARIO_BY_ID"));
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, email);
			ps.setString(4, id);
			ps.executeUpdate();
			jdbc.close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Invalid values", e);
		} finally {
			jdbc.close(ps);
			jdbc.close(c);
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @param nuevo_password
	 */
	public void actualizarPassword(String id, String nuevo_password) {
		PreparedStatement ps = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("MODIFICAR_PASSWORD_BY_ID"));
			ps.setString(1, nuevo_password);
			ps.setString(2, id);
			ps.executeUpdate();
			jdbc.close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Invalid values", e);
		} finally {
			jdbc.close(ps);
			jdbc.close(c);
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @param idAlumno
	 * @param nota
	 * @return la nueva nota.
	 */
	public int actualizarNota(String idAsignatura, String idAlumno, int nota) {
		PreparedStatement ps = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("MODIFICAR_NOTA"));
			ps.setInt(1, nota);
			ps.setString(2, idAlumno);
			ps.setString(3, idAsignatura);
			ps.executeUpdate();
			return nota;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Invalid values", e);
		} finally {
			jdbc.close(ps);
			jdbc.close(c);
		}
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAlumno
	 * @return
	 */
	public List<Matricula> verExpediente(String idAlumno) {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = jdbc.createConnection();
			ps = c.prepareStatement(jdbc.getSql("GET_MATRICULAS_BY_USUARIO_ID"));
			ps.setString(1, idAlumno);
			rs = ps.executeQuery();
			while (rs.next()) {
				String idAsignatura = rs.getString("id_asignatura");
				Asignatura asignatura = getAsignaturaById(idAsignatura);
				Matricula matricula = new Matricula(getUsuarioById(idAlumno),
						asignatura, rs.getInt("calificacion"));
				matriculas.add(matricula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			jdbc.close(rs, ps);
			jdbc.close(c);
		}
		return matriculas;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return asignatura con ese id.
	 * @throws SQLException
	 *             en caso error en la consulta.
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
			List<Usuario> misProfesores = getProfesoresByAsignaturaId(idAsignatura);
			asignatura.setProfesores(misProfesores);
			return asignatura;
		}
		jdbc.close(rs, ps);
		jdbc.close(c);
		return null;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param idAsignatura
	 * @return lista de profesores de una asignatura.
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
	 * @return lista de usuarios activados.
	 */
	public List<Usuario> verUsuariosActivados() {
		List<Usuario> activados = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("GET_USUARIOS_ACTIVADOS"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario profesor = new Usuario(rs.getString("id"),
						rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("correo"), rs.getString("password"),
						rs.getBoolean("validado"), rs.getString("privilegios"));
				activados.add(profesor);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return activados;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @return lista de usuarios desactivados.
	 */
	public List<Usuario> verUsuariosDesactivados() {
		List<Usuario> desactivados = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("GET_USUARIOS_DESACTIVADOS"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario profesor = new Usuario(rs.getString("id"),
						rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("correo"), rs.getString("password"),
						rs.getBoolean("validado"), rs.getString("privilegios"));
				desactivados.add(profesor);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return desactivados;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @return usuario desactivado.
	 */
	public Usuario desactivarUsuario(String id) {
		Usuario desactivado = null;
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("MODIFICAR_ACTIVACION"));
			ps.setBoolean(1, false);
			ps.setString(2, id);
			ps.executeUpdate();
			desactivado = getUsuarioById(id);
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return desactivado;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param id
	 * @return usuario activado.
	 */
	public Usuario activarUsuario(String id) {
		Usuario activado = null;
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("MODIFICAR_ACTIVACION"));
			ps.setBoolean(1, true);
			ps.setString(2, id);
			ps.executeUpdate();
			activado = getUsuarioById(id);
			jdbc.close(ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return activado;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param criterio_buscado
	 * @return listado de profesores con ese nombre o apellido.
	 */
	public List<Usuario> buscarProfesores(String criterio_buscado) {
		List<Usuario> profesores = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("BUSCAR_PROFESORES"));
			ps.setString(1, criterio_buscado);
			ps.setString(2, criterio_buscado);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				Usuario profesor = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				List<Asignatura> misAsignaturas = getAsignaturasByProfesorId(id);
				profesor.setAsignaturas(misAsignaturas);
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
	 * @param criterio_buscado
	 * @return listado de usuarios activados con ese nombre o apellido.
	 */
	public List<Usuario> buscarUsuariosActivados(String criterio_buscado) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("BUSCAR_USUARIOS_ACTIVADOS"));
			ps.setString(1, criterio_buscado);
			ps.setString(2, criterio_buscado);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				Usuario usuario = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				usuarios.add(usuario);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return usuarios;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @param criterio_buscado
	 * @return listado de usuarios desactivados con ese nombre o apellido.
	 */
	public List<Usuario> buscarUsuariosDesctivados(String criterio_buscado) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			c = jdbc.createConnection();
			PreparedStatement ps = c.prepareStatement(jdbc
					.getSql("BUSCAR_USUARIOS_DESACTIVADOS"));
			ps.setString(1, criterio_buscado);
			ps.setString(2, criterio_buscado);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				Usuario usuario = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				usuarios.add(usuario);
			}
			jdbc.close(rs, ps);
			jdbc.close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		return usuarios;
	}

	/**
	 * Establece la conexion con la bbdd y realiza la consulta.
	 * 
	 * @return listado de alumnos.
	 */
	public List<Usuario> getAlumnos() {
		List<Usuario> alumnos = new ArrayList<Usuario>();
		Statement st = null;
		ResultSet rs = null;

		try {
			c = jdbc.createConnection();
			st = c.createStatement();
			rs = st.executeQuery(jdbc.getSql("LISTAR_ALUMNOS"));
			while (rs.next()) {
				String id = rs.getString("id");
				Usuario alumno = new Usuario(id, rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("correo"),
						rs.getString("password"), rs.getBoolean("validado"),
						rs.getString("privilegios"));
				alumnos.add(alumno);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		} finally {
			jdbc.close(rs, st);
			jdbc.close(c);
		}

		return alumnos;
	}

}
