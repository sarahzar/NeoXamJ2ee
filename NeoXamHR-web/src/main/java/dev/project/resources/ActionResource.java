package dev.project.resources;

import java.util.Date;
import java.util.List;

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
import dev.project.entities.Action;
import dev.project.services.ActionServiceInterface;

@Path("/action")
public class ActionResource {
	
	@EJB
	ActionServiceInterface mod ;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAction(Action A) {
		if (mod.AddAction(A)) {
			return Response.status(Status.CREATED).entity("l'action est créee ").build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateAction(@PathParam(value = "id") String id, Action act) {
		if (mod.UpdateAction(id, act)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteAct(@PathParam(value="id")String id ) {
		
				
			if (mod.DeleteAction(id)) {
				return Response.status(Status.OK).build();
			}
			return Response.status(Status.NOT_FOUND).build();

		}
		

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "id") String id) {
		Action AA=mod.GetActionByCode(id);
		if (AA != null) {
			return Response.status(Status.OK).entity(mod.GetActionByCode(id))
					.build();
		}
		return Response.status(Status.OK).entity(mod.getAllActions()).build();

	}
	
	@GET
	@Path("{date}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByDate(@PathParam(value = "date") Date dd) {
		Action AA=mod.getActionByDate(dd);
		if (AA != null) {
			return Response.status(Status.OK).entity(mod.getActionByDate(dd))
					.build();
		}
		return Response.status(Status.OK).entity(mod.getAllActions()).build();

	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {
		List<Action> action = mod.getAllActions();
		if (action.isEmpty()==false) {
			return Response.status(Status.OK).entity( mod.getAllActions()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
}
