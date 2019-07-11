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

@Path("evaluation")
@Stateless
@LocalBean
public class EvaluationResource {
	
	

	@EJB
	 EvaluationServiceInterface EvalBus ;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEval(Evaluation e) {
		
//		    EvalBus.add(e);
			return Response.status(Status.CREATED).entity("Evaluation is created").build();
		
		

	}
	


	@PUT
	@Path("{empID}/{risqueID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateEval(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") String IdR,Evaluation E)
		{
//		EvaluationPK evpk = new EvaluationPK();
//		evpk.setEmpId(IdE);
//		evpk.setRisqueId(IdR);
//		if (EvalBus.UpdateEval(evpk, E)) {
//			return Response.status(Status.OK).build();
//		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@DELETE
		@Path("{empID}/{risqueID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteEval(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") String IdR) {
//EvaluationPK evpk = new EvaluationPK();
//		evpk.setEmpId(IdE);
//		evpk.setRisqueId(IdR);
//		if (EvalBus.DeleteEval(evpk)) {
//			return Response.status(Status.OK).build();
//		}
		return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Path("{empID}/{risqueID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByID(@PathParam(value = "empID") long IdE, @PathParam(value = "risqueID") String IdR) {
//	EvaluationPK evpk = new EvaluationPK();
//		evpk.setEmpId(IdE);
//		evpk.setRisqueId(IdR);
//		Evaluation eval=EvalBus.getEvalById(evpk);
//		if (eval != null) {
//			return Response.status(Status.OK).entity(EvalBus.getEvalById(evpk)).build();
//		}
	//	return Response.status(Status.OK).entity(EvalBus.getEvalById(evpk)).build();
return null;
	}

	@GET
	@Path("{risqueId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByActCons(@PathParam(value = "risqueId") String cod) {
//		List<Evaluation> EV=EvalBus.getEvalByRisk(cod);
//		if (EV.isEmpty()==false) {
//			return Response.status(Status.OK).entity(EvalBus.getEvalByRisk(cod)).build();
//		}
//		return Response.status(Status.OK).entity(EvalBus.getEvalByRisk(cod)).build();
return null;
	}
	
	@GET
	@Path("{empId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByPrevCons(@PathParam(value = "empId") Long cod) {
//		List<Evaluation> EV=EvalBus.getEvalByEmp(cod);
//		if (EV.isEmpty()==false) {
//			return Response.status(Status.OK).entity(EvalBus.getEvalByEmp(cod)).build();
//		}
//		return Response.status(Status.OK).entity(EvalBus.getEvalByEmp(cod)).build();
return null;
	}
	
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response ShowAll() {
		
		
		if (EvalBus.getAllEvaluations().isEmpty()==false) {
			return Response.status(Status.OK).entity(EvalBus.getAllEvaluations()).build();
		}
		return Response.status(Status.NOT_FOUND).build();

	}
}
