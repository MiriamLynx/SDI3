package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import uo.sdi.util.filtros.Check;

import com.sdi.business.UsuariosService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

/**
 * Bean para las acciones realizadas sobre los usuarios.
 * 
 * @author UO217345.
 * 
 */
@ManagedBean(name = "controllerUsuarios")
@SessionScoped
public class BeanUsuarios implements Serializable {

	private static final long serialVersionUID = 2220767639613106740L;

	// Listado de profesores
	private List<Usuario> profesores = null;

	// Campos de un nuevo usuario registrandose
	private String nuevo_id;
	private String nuevo_nombre;
	private String nuevo_apellidos;
	private String nuevo_correo;
	private boolean nuevo_validado;
	private String nuevo_password;
	private String nuevo_privilegios;
	private String nuevo_repetir_password;

	// Error durante el registro
	private boolean registro_incorrecto;

	// Matriculas de un alumno
	private Matricula[] matriculas;

	// Usuarios activados
	private List<Usuario> activados;
	// Usuarios desactivados
	private List<Usuario> desactivados;

	// Error contraseñas que no coinciden
	private boolean nomatch;

	// Error datos introducidos no validos
	private boolean invalido;

	// Criterio introducido en el campo de busqueda
	private String criterio_buscado;

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String buscar() {
		UsuariosService service;
		try {
			if (this.criterio_buscado == null) {
				this.criterio_buscado = " ";
			}
			service = Factories.services.createUsuariosService();
			profesores = service.buscarProfesores(criterio_buscado);
			this.criterio_buscado = null;
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String actualizarPerfil() {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			Usuario usuario = new Usuario(nuevo_id, nuevo_nombre,
					nuevo_apellidos, nuevo_correo);
			service.actualizarPerfil(usuario);
			setActivados(service.verUsuariosActivados());
			setDesactivados(service.verUsuariosDesactivados());
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			setInvalido(true);
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String actualizarPassword() {
		UsuariosService service;
		try {
			Check.validPassword(nuevo_password, nuevo_repetir_password);
			service = Factories.services.createUsuariosService();
			service.actualizarPassword(nuevo_id, nuevo_password);
			return "exito";
		} catch (BusinessException e) {
			setNomatch(true);
			e.printStackTrace();
			return "nomatch";
		}
	}

	public String cargarUsuario(String id, String nombre, String apellidos,
			String correo) {
		this.nuevo_id = id;
		this.nuevo_nombre = nombre;
		this.nuevo_apellidos = apellidos;
		this.nuevo_correo = correo;
		return "editar";
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String activarUsuario(String id) {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			Usuario activado = service.activarUsuario(id);
			desactivados.remove(activado);
			activados.add(activado);
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String desactivarUsuario(String id) {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			Usuario desactivado = service.desactivarUsuario(id);
			activados.remove(desactivado);
			desactivados.add(desactivado);
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String buscarUsuarios() {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			setActivados(service.buscarUsuariosActivados(criterio_buscado));
			setDesactivados(service
					.buscarUsuariosDesactivados(criterio_buscado));
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String gestionarUsuarios() {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			setActivados(service.verUsuariosActivados());
			setDesactivados(service.verUsuariosDesactivados());
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String verExpediente(String idAlumno) {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			setMatriculas((Matricula[]) service.verExpediente(idAlumno)
					.toArray(new Matricula[0]));
			return "exito listado";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String actualizarNota(Usuario alumno, String idAsignatura) {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			service.actualizarNota(idAsignatura, alumno.getId(),
					alumno.getNota());
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String listadoProfesores() {
		UsuariosService service;
		try {
			service = Factories.services.createUsuariosService();
			profesores = service.getProfesores();
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String registro() {
		UsuariosService service;
		try {
			Check.validPassword(nuevo_password, nuevo_repetir_password);
			service = Factories.services.createUsuariosService();
			service.insertarUsuario(nuevo_id, nuevo_nombre, nuevo_apellidos,
					nuevo_correo, nuevo_validado, nuevo_password,
					nuevo_privilegios);
			setRegistro_incorrecto(false);
			return "exito";

		} catch (BusinessException e) {
			setRegistro_incorrecto(true);
			e.printStackTrace();
			return "incorrecto";
		}
	}

	/**
	 * Metodo que comprueba el valor de las notas y los convierte segun el caso.
	 * 
	 * @param nota
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String traducirNota(int nota) {
		if (nota == 11) {
			return "No presentado";
		} else if (nota == 12) {
			return "Sin calificar";
		} else {
			return "" + nota;
		}
	}

	public List<Usuario> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Usuario> profesores) {
		this.profesores = profesores;
	}

	public String getNuevo_id() {
		return nuevo_id;
	}

	public void setNuevo_id(String nuevo_id) {
		this.nuevo_id = nuevo_id;
	}

	public String getNuevo_nombre() {
		return nuevo_nombre;
	}

	public void setNuevo_nombre(String nuevo_nombre) {
		this.nuevo_nombre = nuevo_nombre;
	}

	public String getNuevo_apellidos() {
		return nuevo_apellidos;
	}

	public void setNuevo_apellidos(String nuevo_apellidos) {
		this.nuevo_apellidos = nuevo_apellidos;
	}

	public String getNuevo_correo() {
		return nuevo_correo;
	}

	public void setNuevo_correo(String nuevo_correo) {
		this.nuevo_correo = nuevo_correo;
	}

	public boolean isNuevo_validado() {
		return nuevo_validado;
	}

	public void setNuevo_validado(boolean nuevo_validado) {
		this.nuevo_validado = nuevo_validado;
	}

	public String getNuevo_password() {
		return nuevo_password;
	}

	public void setNuevo_password(String nuevo_password) {
		this.nuevo_password = nuevo_password;
	}

	public String getNuevo_privilegios() {
		return nuevo_privilegios;
	}

	public void setNuevo_privilegios(String nuevo_privilegios) {
		this.nuevo_privilegios = nuevo_privilegios;
	}

	public String getNuevo_repetir_password() {
		return nuevo_repetir_password;
	}

	public void setNuevo_repetir_password(String nuevo_repetir_password) {
		this.nuevo_repetir_password = nuevo_repetir_password;
	}

	public boolean isRegistro_incorrecto() {
		return registro_incorrecto;
	}

	public void setRegistro_incorrecto(boolean registro_incorrecto) {
		this.registro_incorrecto = registro_incorrecto;
	}

	public Matricula[] getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Matricula[] matriculas) {
		this.matriculas = matriculas;
	}

	public List<Usuario> getActivados() {
		return activados;
	}

	public void setActivados(List<Usuario> activados) {
		this.activados = activados;
	}

	public List<Usuario> getDesactivados() {
		return desactivados;
	}

	public void setDesactivados(List<Usuario> desactivados) {
		this.desactivados = desactivados;
	}

	public boolean isNomatch() {
		return nomatch;
	}

	public void setNomatch(boolean nomatch) {
		this.nomatch = nomatch;
	}

	public boolean isInvalido() {
		return invalido;
	}

	public void setInvalido(boolean invalido) {
		this.invalido = invalido;
	}

	public String getCriterio_buscado() {
		return criterio_buscado;
	}

	public void setCriterio_buscado(String criterio_buscado) {
		this.criterio_buscado = criterio_buscado;
	}

}
