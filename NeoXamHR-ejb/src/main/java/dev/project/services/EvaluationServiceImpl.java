package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;

@Stateless
public class EvaluationServiceImpl implements EvaluationServiceInterface {

	@PersistenceContext(unitName = "neo")
	EntityManager em;

	// method to get evaluation by its employee Id

	@Override
	public Evaluation getEvalById(EvaluationPK epk) {
		return em.find(Evaluation.class, epk);
	}

	// method to add new evaluation
	@Override
	public boolean AddEval(Evaluation e) {
		if (this.getEvalById(e.getId()) == null) {
			em.persist(e);
			return true;
		}
		return false;
	}

	// method to get Evaluation by its Date
	@Override
	public Evaluation getEvalByDate(Date d) {
		return em.find(Evaluation.class, d);
	}

	// method to get all evaluations in list format
	@Override
	public List<Evaluation> getAllEval() {
		return em.createQuery("select e.* from evaluation e", Evaluation.class).getResultList();
	}

	// method to update evaluation
	@Override
	public boolean UpdateEval(EvaluationPK Id, Evaluation E) {
		Evaluation OldOne = this.getEvalById(Id);
		if (OldOne != null) {
			OldOne.setId(E.getId());
			OldOne.setDate(E.getDate());
			OldOne.setRisqueGlobal(E.getRisqueGlobal());
			return true;
		}

		return false;
	}

	// method to Delete Evaluation
	@Override
	public boolean DeleteEval(EvaluationPK epk) {
		Evaluation OldOne = this.getEvalById(epk);
		if (OldOne != null) {
			em.remove(OldOne);

			return true;
		}

		return false;
	}

	@Override
	public List<Evaluation> getEvalByEmp(long empId) {
	
		return em.createQuery("SELECT * FROM evaluation e WHERE e.empId="+empId+'"', Evaluation.class).getResultList();
		
	}

	@Override
	public List<Evaluation> getEvalByRisk(String ris) {
	
		return em.createQuery("SELECT * FROM evaluation e WHERE e.empId="+ris+'"', Evaluation.class).getResultList();
		
	}



}
