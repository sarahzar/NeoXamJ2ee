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
import dev.project.entities.User;
import dev.project.services.DepartementServiceImpl;
import dev.project.services.DepartementServiceInterface;
import dev.project.services.UserServiceImpl;
import dev.project.services.UserServiceInterface;

@Path("/user")
@Stateless
@LocalBean
public class UserRessource {
	
	@EJB
	UserServiceInterface service ;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		service.add(user);
			return Response.status(Status.CREATED).build();
		
		
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {
		if(service.getAll().isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}		
		return Response.status(Status.OK).entity(service.getAll()).build();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam(value="id") int Id) {
		User user= service.findById(Id);
//		if( user== null ) {
//			return Response.status(Status.NOT_FOUND).build();
//		}		
		return Response.status(Status.OK).entity(user).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam(value="id") int id) {
	
		
			service.delete(id);
			return Response.status(Status.OK).build();
	
		
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{id}")
	public Response updateUser(@PathParam("id") long id, User user) {
		
			service.update(id, user);
			return Response.status(Status.OK).entity(user).build();
		
		
		
	}
	
	@POST
	@Path("/login/{login}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("login") String login,@PathParam("password") String password) {
		User user1 =	service.Login(login, password);	
	    return Response.status(Status.OK).entity(user1).build();
}
}
