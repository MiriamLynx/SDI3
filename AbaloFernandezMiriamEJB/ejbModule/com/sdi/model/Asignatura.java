package com.sdi.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que modela la tabla Tasignaturas.
 * 
 * @author UO217345
 * 
 */
@XmlRootElement(name = "asignatura")
public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7894970057914859416L;
	private String id;
	private String nombre;
	private int creditos;
	private String curso;

	// Profesores que imparten una asignatura
	private List<Usuario> profesores;

	// Matriculas de la asignatura.
	private List<Matricula> matriculas;

	public Asignatura(String id, String nombre, int creditos, String curso) {
		this.setId(id);
		this.setCreditos(creditos);
		this.setNombre(nombre);
		this.setCurso(curso);
	}

	public Asignatura() {
	}

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProfesores(List<Usuario> profesores) {
		this.profesores = profesores;
	}

	@XmlElement
	public List<Usuario> getProfesores() {
		return profesores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		if (nombre != null)
			builder.append(nombre);
		builder.append(" ");
		return builder.toString();
	}

	@XmlElement
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@XmlElement
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
