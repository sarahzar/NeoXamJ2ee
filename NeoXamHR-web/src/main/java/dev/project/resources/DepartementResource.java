package dev.project.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dev.project.entities.Departement;
import dev.project.services.DepartementServiceImpl;
import dev.project.services.DepartementServiceInterface;

@Path("/departement")
public class DepartementResource {

	DepartementServiceInterface metier = new DepartementServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDepartement(Departement d) {
		if (metier.addDepartment(d)) {
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDepartement() {
		if(metier.getAllDepartements().isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(metier.getAllDepartements()).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDepartement(@PathParam(value="id") int id) {
		if(metier.deleteDepartement(id)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDepartement(@PathParam(value="id") int id, Departement d) {
		
		if(metier.updateDepartement(id, d)) {
			return Response.status(Status.OK).build();
			
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
