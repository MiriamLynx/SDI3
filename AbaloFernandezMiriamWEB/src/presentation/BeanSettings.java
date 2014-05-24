package presentation;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Bean para las acciones realizadas sobre el idioma.
 * 
 * @author UO217345.
 * 
 */
@ManagedBean(name = "controllerSettings")
@SessionScoped
public class BeanSettings implements Serializable {

	private static final long serialVersionUID = -818367645190405771L;

	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");

	private String titulo1 = "/AbaloFernandezMiriamWEB/img/titulo1.png";
	private String titulo2 = "/AbaloFernandezMiriamWEB/img/titulo2.png";
	private String titulo3 = "/AbaloFernandezMiriamWEB/img/titulo3.png";
	private String usuarios = "/AbaloFernandezMiriamWEB/img/usuarios.png";
	private String alumnos = "/AbaloFernandezMiriamWEB/img/alumnos.png";
	private String asignacion = "/AbaloFernandezMiriamWEB/img/asignacion.png";
	private String asignaturas = "/AbaloFernandezMiriamWEB/img/asignaturas.png";
	private String editarAsignatura = "/AbaloFernandezMiriamWEB/img/editarAsignatura.png";
	private String expediente = "/AbaloFernandezMiriamWEB/img/expediente.png";
	private String nuevaAsignatura = "/AbaloFernandezMiriamWEB/img/nuevaAsignatura.png";
	private String profesores = "/AbaloFernandezMiriamWEB/img/profesores.png";

	private Locale locale = SPANISH;

	public Locale getLocale() {
		return locale;
	}

	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		titulo1 = "/AbaloFernandezMiriamWEB/img/titulo1.png";
		setTitulo2("/AbaloFernandezMiriamWEB/img/titulo2.png");
		titulo3 = "/AbaloFernandezMiriamWEB/img/titulo3.png";
		usuarios = "/AbaloFernandezMiriamWEB/img/usuarios.png";
		alumnos = "/AbaloFernandezMiriamWEB/img/alumnos.png";
		asignacion = "/AbaloFernandezMiriamWEB/img/asignacion.png";
		asignaturas = "/AbaloFernandezMiriamWEB/img/asignaturas.png";
		editarAsignatura = "/AbaloFernandezMiriamWEB/img/editarAsignatura.png";
		expediente = "/AbaloFernandezMiriamWEB/img/expediente.png";
		nuevaAsignatura = "/AbaloFernandezMiriamWEB/img/nuevaAsignatura.png";
		profesores = "/AbaloFernandezMiriamWEB/img/profesores.png";
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		titulo1 = "/AbaloFernandezMiriamWEB/img/titulo1_en.png";
		setTitulo2("/AbaloFernandezMiriamWEB/img/titulo2_en.png");
		titulo3 = "/AbaloFernandezMiriamWEB/img/titulo3_en.png";
		usuarios = "/AbaloFernandezMiriamWEB/img/usuarios_en.png";
		alumnos = "/AbaloFernandezMiriamWEB/img/alumnos_en.png";
		asignacion = "/AbaloFernandezMiriamWEB/img/asignacion_en.png";
		asignaturas = "/AbaloFernandezMiriamWEB/img/asignaturas_en.png";
		editarAsignatura = "/AbaloFernandezMiriamWEB/img/editarAsignatura_en.png";
		expediente = "/AbaloFernandezMiriamWEB/img/expediente_en.png";
		nuevaAsignatura = "/AbaloFernandezMiriamWEB/img/nuevaAsignatura_en.png";
		profesores = "/AbaloFernandezMiriamWEB/img/profesores_en.png";
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public String getTitulo1() {
		return titulo1;
	}

	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}

	public String getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}

	public String getTitulo3() {
		return titulo3;
	}

	public void setTitulo3(String titulo3) {
		this.titulo3 = titulo3;
	}

	public String getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}

	public String getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(String alumnos) {
		this.alumnos = alumnos;
	}

	public String getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	public String getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getEditarAsignatura() {
		return editarAsignatura;
	}

	public void setEditarAsignatura(String editarAsignatura) {
		this.editarAsignatura = editarAsignatura;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getNuevaAsignatura() {
		return nuevaAsignatura;
	}

	public void setNuevaAsignatura(String nuevaAsignatura) {
		this.nuevaAsignatura = nuevaAsignatura;
	}

	public String getProfesores() {
		return profesores;
	}

	public void setProfesores(String profesores) {
		this.profesores = profesores;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
