package dev.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Employee;
import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;
import dev.project.entities.Risk;

@Stateless
public class EvaluationDaoImpl implements EvaluationDaoInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	

	@Override
	public Evaluation getEvalByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getEvalByEmp(long id) {
		
		return em.createQuery("from Evaluation e WHERE e.id.empId=:idemp", Evaluation.class).setParameter("idemp", id).getResultList();
	}

	@Override
	public List<Evaluation> getEvalByRisk(long ris) {
		
		return em.createQuery("from Evaluation e WHERE e.id.risqueId=:riscode", Evaluation.class).setParameter("riscode", ris).getResultList();
	}

	@Override
	public void addEvaluation(long codeRisk, long idEmp, Evaluation e) {
		
		//Evaluation e=new Evaluation();
		//e.setDate(d);
		Risk risk=em.find(Risk.class, codeRisk);
		Employee emp=em.find(Employee.class, idEmp);
	    if(risk.getCode()!=0 && emp.getId()!=0) {
	    	EvaluationPK pk=new EvaluationPK();
	    	pk.setEmpId(idEmp);
	    	pk.setRisqueId(codeRisk);
	    	e.setId(pk);
	    	
	    	em.persist(e);
	    }
		
	}

	@Override
	public void updateEvaluation(long codeRisk, long idEmp, Evaluation e) {
		
		Evaluation oldEval = findEvaluation(idEmp, codeRisk);
		if (oldEval != null) {
			oldEval.setDate(e.getDate());
			oldEval.setRisqueGlobal(e.getRisqueGlobal());
//			em.merge(oldEval);
	}
		
	}

	@Override
	public void deleteEvaluation(long codeRisk, long idEmp) {
		// TODO Auto-generated method stub
		Evaluation oldEval = findEvaluation(idEmp, codeRisk);
		if (oldEval != null) {
			em.remove(oldEval);
		}
	}

	@Override
	public List<Evaluation> getAllEvaluations() {
		
		return em.createQuery("from Evaluation e ",Evaluation.class).getResultList();
	}

	@Override
	public Evaluation findEvaluation(long idEmp, long riskCode) {

		return em.createQuery("from Evaluation e where e.id.empId=:idEmp and e.id.risqueId =: riskCode", Evaluation.class)
		.setParameter("idEmp", idEmp).setParameter("riskCode", riskCode).getSingleResult();
				
		
	}

	@Override
	public Evaluation findEvaluationPK(EvaluationPK pk) {
		// TODO Auto-generated method stub
		return em.find(Evaluation.class, pk);
	}

}
