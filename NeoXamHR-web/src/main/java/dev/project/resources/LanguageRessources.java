package dev.project.resources;

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

import dev.project.entities.Departement;
import dev.project.entities.Language;
import dev.project.services.LanguageServiceInterface;

@Path("/language")
@Stateless
@LocalBean
public class LanguageRessources {
	
	@EJB
	LanguageServiceInterface metier;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLanguage(Language l) {
		metier.Add(l);
			return Response.status(Status.CREATED).build();		
	}
	
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "id") int id) {
	Language lang=metier.Get(id);	
		if (lang != null) {
			return Response.status(Status.OK).entity(lang).build();
		}
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Path("/byUser/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response GetByUser(@PathParam(value = "id") int id) {
	List<Language> langs=metier.GetByUser(id);
		if (langs != null) {
			return Response.status(Status.OK).entity(langs).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Delete(@PathParam(value = "id") int id) {
		metier.Delete(id);
		return Response.status(Status.OK).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam(value="id") int id, Language lang) {
		
		metier.Upadate(lang);
			return Response.status(Status.OK).build();		
	}
}
