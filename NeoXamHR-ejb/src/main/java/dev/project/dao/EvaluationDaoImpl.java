package dev.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Evaluation;

@Stateless
public class EvaluationDaoImpl implements EvaluationDaoInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	
	
	@Override
	public void add(Evaluation t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id, Evaluation t) {
		Evaluation OldOne = em.find(Evaluation.class, id);
		
			OldOne.setId(t.getId());
			OldOne.setDate(t.getDate());
			OldOne.setRisqueGlobal(t.getRisqueGlobal());
			em.merge(OldOne);
		
	}

	@Override
	public void delete(long id) {
		Evaluation OldOne = em.find(Evaluation.class, id);
		em.remove(OldOne);
		
	}

	@Override
	public Evaluation findById(long id) {
		
		return em.find(Evaluation.class, id);
	}

	@Override
	public List<Evaluation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluation getEvalByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getEvalByEmp(long id) {
		
		return em.createQuery("from Evaluation e WHERE e.empId=:idemp", Evaluation.class).setParameter("idemp", id).getResultList();
	}

	@Override
	public List<Evaluation> getEvalByRisk(String ris) {
		
		return em.createQuery("from Evaluation e WHERE e.risque.code=:riscode", Evaluation.class).setParameter("riscode", ris).getResultList();
	}

}
