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
import dev.project.services.EvaluationServiceImpl;
import dev.project.services.EvaluationServiceInterface;

@Path("evaluation")
@Stateless
@LocalBean
public class EvaluationResource {

	@EJB
	 EvaluationServiceInterface EvalBus ;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEval(Evaluation e) {
		
		    EvalBus.add(e);
			return Response.status(Status.CREATED).entity("Evaluation is created").build();
		
		

	}

	/*@PUT
	@Path("{EvaluationPK}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateEval(@PathParam(value = "EvaluationPK") EvaluationPK code, Evaluation E) {
		if (EvalBus.UpdateEval(code, E)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}*/

	/*@DELETE
	@Path("{EvaluationPK}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteEval(@PathParam(value = "id") EvaluationPK id) {

		if (EvalBus.DeleteEval(id)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}*/

	/*@GET
	@Path("{EvaluationPK}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "EvaluationPK") EvaluationPK id) {
		Evaluation eval=EvalBus.getEvalById(id);
		if (eval != null) {
			return Response.status(Status.OK).entity(EvalBus.getEvalById(id)).build();
		}
		return Response.status(Status.OK).entity(EvalBus.getEvalById(id)).build();

	}*/

	@GET
	@Path("{risqueId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByActCons(@PathParam(value = "risqueId") String cod) {
		List<Evaluation> EV=EvalBus.getEvalByRisk(cod);
		if (EV.isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getEvalByRisk(cod)).build();
		}
		return Response.status(Status.OK).entity(EvalBus.getEvalByRisk(cod)).build();

	}
	
	@GET
	@Path("{empId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByPrevCons(@PathParam(value = "empId") Long cod) {
		List<Evaluation> EV=EvalBus.getEvalByEmp(cod);
		if (EV.isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getEvalByEmp(cod)).build();
		}
		return Response.status(Status.OK).entity(EvalBus.getEvalByEmp(cod)).build();

	}
	
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {
		
		
		if (EvalBus.getAll().isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getAll()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
}
