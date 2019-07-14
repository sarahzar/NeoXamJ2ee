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
import dev.project.entities.Employee;
import dev.project.services.DepartementServiceInterface;
import dev.project.services.EmployeesServiceInterface;

@Path("/employee")
@Stateless
@LocalBean
public class EmployeeResource {
	
	@EJB
	EmployeesServiceInterface metier ;
	
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee e) {
		metier.add(e);
		if(e.getId()!=0) {
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
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
	public Response deleteEmployee(@PathParam(value = "id") int id) {
		metier.delete(id);
		return Response.status(Status.OK).build();

	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam(value="id") int id,Employee e) {
		
		    metier.update(id,e);
			return Response.status(Status.OK).build();
			
		
	}
	
	@PUT
	@Path("/affecter/{idemp}/{idproj}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response AffecterEmployee(@PathParam(value="idemp") int idemp,@PathParam(value="idemp") int idproj) {
		
		    metier.affecterEmpProj(idemp, idproj);
			return Response.status(Status.OK).build();
			
		
	}
}
