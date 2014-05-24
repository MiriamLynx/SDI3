package presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sdi.business.AsignaturasService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Bean para las acciones realizadas sobre las asignaturas.
 * 
 * @author UO217345.
 * 
 */
@ManagedBean(name = "controllerAsignaturas")
@SessionScoped
public class BeanAsignaturas implements Serializable {

	private static final long serialVersionUID = 2426530828727040310L;

	// Listado de asignaturas
	private List<Asignatura> asignaturas = null;

	// Listado de alumnos matriculados
	private Usuario[] alumnos = null;

	// Asignatura de la que son los alumnos
	private String idAsignatura;

	// Error al eliminar
	private boolean errorDependencias;

	// Error al crear
	private boolean invalido;

	// Datos de una nueva asignatura
	private String nuevo_codigo;
	private String nuevo_nombre;
	private String nuevo_curso;
	private int nuevo_creditos;

	// Id del alumno a matricular
	private String idAlumno;

	// Id del profesor a asignar
	private String idProfesor;

	// Nombre introducido en el campo de busqueda
	private String nombre_buscado;

	public List<Asignatura> getAsignaturas() {
		return (asignaturas);
	}

	public void setAsignatura(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String buscar() {
		AsignaturasService service;
		try {
			if (this.nombre_buscado == null) {
				this.nombre_buscado = " ";
			}
			service = Factories.services.createAsignaturasService();
			asignaturas = service.buscarAsignaturas(nombre_buscado);
			this.nombre_buscado = null;
			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Guarda el id de la asignatura para luego poder asignarsela a un alumno.
	 * 
	 * @param idAsignatura
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String asignacionAlumno(String idAsignatura) {
		this.idAsignatura = idAsignatura;
		return "asignar alumno";
	}

	/**
	 * Guarda el id de la asignatura para luego poder asignarsela a un profesor.
	 * 
	 * @param idAsignatura
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String asignacionProfesor(String idAsignatura) {
		this.idAsignatura = idAsignatura;
		return "asignar profesor";
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String asignarAlumno() {
		AsignaturasService service;
		try {
			service = Factories.services.createAsignaturasService();
			service.asignarAlumno(idAlumno, idAsignatura);
			setInvalido(false);
			return "exito";
		} catch (BusinessException e) {
			e.printStackTrace();
			setInvalido(true);
			return "error business";
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
	public String asignarProfesor() {
		AsignaturasService service;
		try {
			service = Factories.services.createAsignaturasService();
			service.asignarProfesor(idProfesor, idAsignatura);
			setInvalido(false);
			return "exito";
		} catch (BusinessException e) {
			e.printStackTrace();
			setInvalido(true);
			return "error business";
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
	public String nuevaAsignatura() {
		AsignaturasService service;
		try {
			service = Factories.services.createAsignaturasService();
			Asignatura asignatura = service.nuevaAsignatura(nuevo_codigo,
					nuevo_nombre, nuevo_curso, nuevo_creditos);
			asignaturas.add(asignatura);
			setInvalido(false);
			return "exito";
		} catch (BusinessException e) {
			e.printStackTrace();
			setInvalido(true);
			return "error business";
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
	public String eliminarAsignatura(String idAsignatura) {
		AsignaturasService service;
		try {
			this.idAsignatura = idAsignatura;
			service = Factories.services.createAsignaturasService();
			Asignatura asignatura = service.eliminarAsignaturas(idAsignatura);
			System.out.println("ASIGNATURA" + asignatura);
			asignaturas.remove(asignatura);
			setErrorDependencias(false);
			return "exito";

		} catch (BusinessException e) {
			setErrorDependencias(true);
			e.printStackTrace();
			return "business error";
		}
	}

	/**
	 * Llama al service y al metodo correspondiente.
	 * 
	 * @return el string correspondiente al caso de navegacion.
	 */
	public String verAlumnosMatriculados(String idAsignatura) {
		AsignaturasService service;
		try {
			this.idAsignatura = idAsignatura;
			service = Factories.services.createAsignaturasService();
			alumnos = (Usuario[]) service.getAlumnos(idAsignatura).toArray(
					new Usuario[0]);

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
	public String listadoAsignaturas() {
		AsignaturasService service;
		try {
			service = Factories.services.createAsignaturasService();
			asignaturas = service.getAsignaturas();

			return "exito";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public Usuario[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Usuario[] alumnos) {
		this.alumnos = alumnos;
	}

	public String getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public boolean isErrorDependencias() {
		return errorDependencias;
	}

	public void setErrorDependencias(boolean errorDependencias) {
		this.errorDependencias = errorDependencias;
	}

	public String getNuevo_codigo() {
		return nuevo_codigo;
	}

	public void setNuevo_codigo(String nuevo_codigo) {
		this.nuevo_codigo = nuevo_codigo;
	}

	public String getNuevo_nombre() {
		return nuevo_nombre;
	}

	public void setNuevo_nombre(String nuevo_nombre) {
		this.nuevo_nombre = nuevo_nombre;
	}

	public String getNuevo_curso() {
		return nuevo_curso;
	}

	public void setNuevo_curso(String nuevo_curso) {
		this.nuevo_curso = nuevo_curso;
	}

	public int getNuevo_creditos() {
		return nuevo_creditos;
	}

	public void setNuevo_creditos(int nuevo_creditos) {
		this.nuevo_creditos = nuevo_creditos;
	}

	public boolean isInvalido() {
		return invalido;
	}

	public void setInvalido(boolean invalido) {
		this.invalido = invalido;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre_buscado() {
		return nombre_buscado;
	}

	public void setNombre_buscado(String nombre_buscado) {
		this.nombre_buscado = nombre_buscado;
	}

}
