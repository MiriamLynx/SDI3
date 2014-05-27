package com.sdi.business.resteasy;

import impl.sdi.business.classes.asignaturas.AsignaturasListado;
import impl.sdi.business.classes.asignaturas.VerAlumnosMatriculados;
import impl.sdi.business.classes.usuarios.AlumnosListado;
import impl.sdi.business.classes.usuarios.VerExpediente;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

public class ServiceRsImpl implements ServiceRs {

	@Override
	public List<Asignatura> getAsignaturas() {
		return new AsignaturasListado().getAsignaturas();
	}

	@Override
	public List<Usuario> getAlumnos(String idAsignatura) {
		return new VerAlumnosMatriculados().getAlumnos(idAsignatura);
	}

	@Override
	public List<Usuario> getAlumnos() {
		return new AlumnosListado().getAlumnos();
	}

	@Override
	public List<Matricula> verExpediente(String idAlumno) {
		return new VerExpediente().verExpediente(idAlumno);
	}

}
