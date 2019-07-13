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

import dev.project.entities.Risk;
import dev.project.services.RiskServiceInterface;

@Path("/risk")
@Stateless
@LocalBean
public class RiskResource {

	@EJB
	 RiskServiceInterface RiskBus;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRisk(Risk R) {
		RiskBus.add(R);
			return Response.status(Status.CREATED).entity("Risk is created").build();
		
		
	}

	@PUT
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateRisk(@PathParam(value = "code") long code, Risk R) {
		//RiskBus.updateRisk(code, R);
		RiskBus.update(code, R);
			return Response.status(Status.OK).build();
		

	}

	@DELETE
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteRisk(@PathParam(value = "id") long id) {

		RiskBus.delete(id);
			return Response.status(Status.OK).build();
		

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "id") long id) {
	
		Risk Ris = RiskBus.findById(id);
		if (Ris != null) {
			return Response.status(Status.OK).entity(RiskBus.findById(id)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getAll()).build();

	}

	@GET
	@Path("{actionConsecutive_code}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByActCons(@PathParam(value = "actionConsecutive_code") long cod) {
		List<Risk> AA = RiskBus.getRiskByConsAct(cod);
		
		if (AA.isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getRiskByConsAct(cod)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getRiskByConsAct(cod)).build();

	}
	
	@GET
	@Path("{actionPreventive_code}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByPrevCons(@PathParam(value = "actionPreventive_code") long cod) {
		List<Risk> AA = RiskBus.getRiskByPrevAct(cod);
		
		if (AA.isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getRiskByPrevAct(cod)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getRiskByPrevAct(cod)).build();
	
	}
	
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {
		
		if (RiskBus.getAll().isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getAll()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}

}
