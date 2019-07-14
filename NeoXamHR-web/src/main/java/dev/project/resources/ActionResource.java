package dev.project.resources;

import java.util.Date;
import java.util.List;

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
import dev.project.entities.Action;
import dev.project.services.ActionServiceInterface;

@Path("/action")
@Stateless
@LocalBean
public class ActionResource {

	@EJB
	ActionServiceInterface mod;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAction(Action A) {
		mod.add(A);
		return Response.status(Status.CREATED).entity("l'action est créee ").build();

	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateAction(@PathParam(value = "id") long id, Action act) {

		mod.update(id, act);
		return Response.status(Status.OK).entity("l'action est updated ").build();

	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteAct(@PathParam(value = "id") long id) {
		mod.delete(id);
		return Response.status(Status.OK).entity("l'action est deleted ").build();

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "id") long id) {
	Action AA=mod.findById(id);
		if (AA != null) {
			return Response.status(Status.OK).entity(AA).build();
		}
		return Response.status(Status.OK).entity(mod.getAll()).build();

	}

	@GET
	@Path("/date/{date}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByDate(@PathParam(value = "date") Date dd) {
//		Action AA=mod.getActionByDate(dd);
//		if (AA != null) {
//			return Response.status(Status.OK).entity(mod.getActionByDate(dd))
//					.build();
//		}
		return Response.status(Status.OK).entity(mod.getAll()).build();

	}

	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {

		if (!mod.getAll().isEmpty()) {
			return Response.status(Status.OK).entity(mod.getAll()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
}
