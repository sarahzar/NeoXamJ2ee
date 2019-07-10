package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.dao.EvaluationDaoInterface;
import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;

@Stateless
@LocalBean
public class EvaluationServiceImpl implements EvaluationServiceInterface {

	@EJB
	EvaluationDaoInterface dao;

	@Override
	public Evaluation getEvalByDate(Date d) {
		
		return dao.getEvalByDate(d);
	}

	@Override
	public List<Evaluation> getEvalByEmp(long id) {
		
		return dao.getEvalByEmp(id);
	}

	@Override
	public List<Evaluation> getEvalByRisk(String ris) {
		
		return dao.getEvalByRisk(ris);
	}

	@Override
	public void add(Evaluation t) {
		
		dao.add(t);
	}

	@Override
	public void update(long id, Evaluation t) {
		dao.update(id, t);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public Evaluation findById(long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Evaluation> getAll() {
		
		return dao.getAll();
	}
	
	
}
