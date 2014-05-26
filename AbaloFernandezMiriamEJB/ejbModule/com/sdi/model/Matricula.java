package com.sdi.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que modela la tabla Tmatriculas.
 * 
 * @author UO217345
 * 
 */
@XmlRootElement(name = "matricula")
public class Matricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6754294953003469735L;
	private Usuario alumno;
	private Asignatura asignatura;
	private int calificacion;

	public Matricula(Usuario alumno, Asignatura asignatura, int calificacion) {
		this.setAlumno(alumno);
		this.setAsignatura(asignatura);
		this.setCalificacion(calificacion);
	}

	public Matricula() {

	}

	@XmlElement
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@XmlElement
	public Usuario getAlumno() {
		return alumno;
	}

	public void setAlumno(Usuario alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Matricula [id_alumno=" + alumno + ", id_asignatura="
				+ asignatura + "]";
	}

	@XmlElement
	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}
