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

@Path("risk")
@Stateless
@LocalBean
public class RiskResource {

	@EJB
	 RiskServiceInterface RiskBus;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRisk(Risk R) {
		if (RiskBus.AddRisk(R)) {
			return Response.status(Status.CREATED).entity("Risk is created").build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}

	@PUT
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateRisk(@PathParam(value = "code") String code, Risk R) {
		if (RiskBus.UpdateRisk(code, R)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}

	@DELETE
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteRisk(@PathParam(value = "id") String id) {

		if (RiskBus.DeleteRisk(id)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "id") String id) {
		Risk Ris = RiskBus.getRiskById(id);
		if (Ris != null) {
			return Response.status(Status.OK).entity(RiskBus.getRiskById(id)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getAllRisks()).build();

	}

	@GET
	@Path("{actionConsecutive_code}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByActCons(@PathParam(value = "actionConsecutive_code") String cod) {
		List<Risk> AA = RiskBus.getRiskByConsAct(cod);
		
		if (AA.isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getRiskByConsAct(cod)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getRiskByConsAct(cod)).build();

	}
	
	@GET
	@Path("{actionPreventive_code}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByPrevCons(@PathParam(value = "actionPreventive_code") String cod) {
		List<Risk> AA = RiskBus.getRiskByPrevAct(cod);
		
		if (AA.isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getRiskByPrevAct(cod)).build();
		}
		return Response.status(Status.OK).entity(RiskBus.getRiskByPrevAct(cod)).build();

	}
	
	
	@GET
	
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {
		List<Risk> Ris = RiskBus.getAllRisks();
		if (Ris.isEmpty()==false) {
			return Response.status(Status.OK).entity(RiskBus.getAllRisks()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}

}
