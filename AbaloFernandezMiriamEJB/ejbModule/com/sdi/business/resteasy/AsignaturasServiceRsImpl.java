package com.sdi.business.resteasy;

import impl.sdi.business.classes.asignaturas.AsignarAlumno;
import impl.sdi.business.classes.asignaturas.AsignarProfesor;
import impl.sdi.business.classes.asignaturas.AsignaturasListado;
import impl.sdi.business.classes.asignaturas.BuscarAsignatura;
import impl.sdi.business.classes.asignaturas.EliminarAsignatura;
import impl.sdi.business.classes.asignaturas.NuevaAsignatura;
import impl.sdi.business.classes.asignaturas.VerAlumnosMatriculados;
import impl.sdi.business.classes.asignaturas.VerMatriculasByAsignaturaId;
import impl.sdi.business.classes.usuarios.VerAsignaturasImpartidas;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

public class AsignaturasServiceRsImpl implements AsignaturasServiceRs {

	@Override
	public List<Asignatura> getAsignaturas() {
		return new AsignaturasListado().getAsignaturas();
	}

	@Override
	public List<Asignatura> getAsignaturasByProfesorId(String id) {
		return new VerAsignaturasImpartidas().getAsignaturas(id);
	}

	@Override
	public List<Usuario> getAlumnos(String idAsignatura) {
		return new VerAlumnosMatriculados().getAlumnos(idAsignatura);
	}

	@Override
	public Asignatura eliminarAsignaturas(String idAsignatura) {
		return new EliminarAsignatura().eliminarAsignatura(idAsignatura);
	}

	@Override
	public Asignatura nuevaAsignatura(String nuevo_codigo, String nuevo_nombre,
			String nuevo_curso, int nuevo_creditos) {
		return new NuevaAsignatura().nuevaAsignatura(nuevo_codigo,
				nuevo_nombre, nuevo_curso, nuevo_creditos);
	}

	@Override
	public void asignarAlumno(String idAlumno, String idAsignatura) {
		new AsignarAlumno(idAlumno, idAsignatura);
	}

	@Override
	public void asignarProfesor(String idProfesor, String idAsignatura) {
		new AsignarProfesor(idProfesor, idAsignatura);
	}

	@Override
	public List<Asignatura> buscarAsignaturas(String nombre_buscado) {
		return new BuscarAsignatura().buscar(nombre_buscado);
	}

	@Override
	public List<Matricula> getMatriculasByAsignaturaId(String idasignatura) {
		return new VerMatriculasByAsignaturaId()
				.getMatriculasByAsignaturaId(idasignatura);
	}

}
