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

import dev.project.entities.Employee;
import dev.project.entities.Project;
import dev.project.services.ProjectServiceInterface;

@Path("/projet")
@Stateless
@LocalBean
public class ProjectResource {
	
	@EJB
	private ProjectServiceInterface metier;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(Project p) {
		metier.add(p);
		if(p.getId()!=0) {
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProjects() {
		if(metier.getAll().isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(metier.getAll()).build();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam(value = "id") int id) {
		if(metier.findById(id)==null) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(metier.findById(id)).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProjects(@PathParam(value = "id") int id) {
		metier.delete(id);
		return Response.status(Status.OK).build();

	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProject(@PathParam(value="id") int id,Project p) {
		
		     metier.update(id,p);
			return Response.status(Status.OK).build();
			
		
	}

}
