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

import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;
import dev.project.services.EvaluationServiceInterface;

@Path("/evaluation")
@Stateless
@LocalBean
public class EvaluationResource {

	@EJB
	EvaluationServiceInterface EvalBus;

	@POST
	@Path("add/{empID}/{risqueID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEval(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") long IdR,
			Evaluation e) {

		EvalBus.addEvaluation(IdR, IdE, e);
		return Response.status(Status.CREATED).entity("Evaluation is created").build();

	}

	@PUT
	@Path("{empID}/{risqueID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateEval(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") long IdR,
			Evaluation E) {

		EvalBus.updateEvaluation(IdR, IdE, E);
		return Response.status(Status.OK).entity("Evaluation is updated").build();

	}

	@DELETE
	@Path("{empID}/{risqueID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteEval(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") long IdR) {

		EvalBus.deleteEvaluation(IdR, IdE);
	return Response.status(Status.OK).entity("Evaluation is deleted").build();

		//return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Path("{empID}/{risqueID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") long IdR) {

	Evaluation eval=EvalBus.findEvaluation(IdE, IdR);
		if (eval != null) {
			return Response.status(Status.OK).entity(eval).build();
		}
		 return Response.status(Status.OK).entity(EvalBus.getAllEvaluations()).build();
		
	}

	@GET
	@Path("/rs/{risqueId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByActCons(@PathParam(value = "risqueId") long cod) {
		List<Evaluation> EV=EvalBus.getEvalByRisk(cod);
		if (EV.isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getEvalByRisk(cod)).build();
		}
		return Response.status(Status.OK).entity(EvalBus.getAllEvaluations()).build();
		
	}

	@GET
	@Path("/emp/{empId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByPrevCons(@PathParam(value = "empId") Long cod) {
		List<Evaluation> EV=EvalBus.getEvalByEmp(cod);
		if (EV.isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getEvalByEmp(cod)).build();
		}
		return Response.status(Status.OK).entity(EvalBus.getAllEvaluations()).build();
		
	}

	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {

		if (EvalBus.getAllEvaluations().isEmpty() == false) {
			return Response.status(Status.OK).entity(EvalBus.getAllEvaluations()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
}
