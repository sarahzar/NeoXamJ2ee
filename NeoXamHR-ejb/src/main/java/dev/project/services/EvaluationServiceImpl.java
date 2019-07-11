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
	public void addEvaluation(String codeRisk, long idEmp, Date d) {
		dao.addEvaluation(codeRisk, idEmp, d);
		
	}

	@Override
	public void updateEvaluation(String codeRisk, long idEmp, Evaluation e) {
		dao.updateEvaluation(codeRisk, idEmp, e);
		
	}

	@Override
	public void deleteEvaluation(String codeRisk, long idEmp, Evaluation e) {
		dao.deleteEvaluation(codeRisk, idEmp, e);
		
	}

	@Override
	public List<Evaluation> getAllEvaluations() {
		
		return dao.getAllEvaluations();
	}

	@Override
	public Evaluation findEvaluation(long idEmp, String riskCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluation findEvaluation(EvaluationPK pk) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
