package dev.project.resources;

import javax.ejb.EJB;
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
import dev.project.entities.User;
import dev.project.services.DepartementServiceImpl;
import dev.project.services.DepartementServiceInterface;
import dev.project.services.UserServiceImpl;
import dev.project.services.UserServiceInterface;

@Path("/user")
public class UserRessource {
	
	@EJB
	UserServiceInterface service ;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		if (service.addUser(user)) {
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {
		if(service.GetAll().isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(service.GetAll()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam(value="id") int Id) {
		User user= service.GetById(Id);
		if( user== null ) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(user).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam(value="id") int id) {
	
		try	{
			service.DeleteUser(id);
			return Response.status(Status.OK).build();
		}catch (Exception ex) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser( User user) {
		try {
			service.Update(user);
			return Response.status(Status.OK).entity(user).build();
		}catch(Exception ex) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login( User user) {
		try {
		User user1 =	service.Login(user.getEmail(), user.getPassword());
		if (user != null) {
			return Response.status(Status.OK).entity(user1).build();
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		}catch(Exception ex) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
	}
}
