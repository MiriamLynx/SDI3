package com.sdi.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que modela la tabla Tusuarios.
 * 
 * @author UO217345
 * 
 */
@XmlRootElement(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6732020753689051277L;
	private String id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private boolean activado;
	private String privilegios;
	private int nota;
	private int counter;

	// Asignaturas de un profesor
	private List<Asignatura> asignaturas;

	public Usuario(String id, String nombre, String apellidos, String email,
			String password, boolean activado, String privilegios) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.activado = activado;
		this.privilegios = privilegios;
	}

	public Usuario() {
	}

	public Usuario(String nuevo_id, String nuevo_nombre,
			String nuevo_apellidos, String nuevo_correo) {
		this.id = nuevo_id;
		this.nombre = nuevo_nombre;
		this.apellidos = nuevo_apellidos;
		this.email = nuevo_correo;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getId() {
		return id;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement
	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	@XmlElement
	public String getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(String privilegios) {
		this.privilegios = privilegios;
	}

	@XmlElement
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		if (nombre != null)
			builder.append(nombre).append(" ");
		if (apellidos != null)
			builder.append(apellidos);
		builder.append(" ");
		return builder.toString();
	}

	@XmlElement
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@XmlElement
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
