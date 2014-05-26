package com.sdi.business.resteasy;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sdi.business.AsignaturasService;
import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

@Stateless
@Path("/AsignaturasServiceRs")
public interface AsignaturasServiceRs extends AsignaturasService {

	@GET
	@Path("alumnos/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Usuario> getAlumnos(String idAsignatura);

	@GET
	@Path("asignaturas/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Matricula> getMatriculasByAsignaturaId(String idasignatura);

	@GET
	@Path("asignaturas")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Asignatura> getAsignaturas();
}
