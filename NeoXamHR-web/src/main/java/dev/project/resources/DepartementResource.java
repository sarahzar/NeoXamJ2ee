package dev.project.resources;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
@Stateless
@LocalBean
public class DepartementResource {
    @EJB
	DepartementServiceInterface metier ;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDepartement(Departement d) {
		metier.add(d);
			return Response.status(Status.CREATED).build();
		
		
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDepartement() {
		if(metier.getAll().isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(metier.getAll()).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDepartement(@PathParam(value="id") int id) {
		metier.delete(id);
			return Response.status(Status.OK).build();
		
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDepartement(@PathParam(value="id") int id, Departement d) {
		
		metier.update(id, d);
			return Response.status(Status.OK).build();
			
		
	}
}
