package dev.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;
@Local
public interface EvaluationDaoInterface  {
	Evaluation getEvalByDate(Date d);
	List<Evaluation> getEvalByEmp(long id);
	List<Evaluation> getEvalByRisk(long ris);
	public void addEvaluation(long codeRisk,long idEmp,Evaluation e);
	public void updateEvaluation(long codeRisk,long idEmp,Evaluation e);
	public void deleteEvaluation(long codeRisk,long idEmp);
	public List<Evaluation> getAllEvaluations();
	public Evaluation findEvaluation(long idEmp,long riskCode);
	public Evaluation findEvaluationPK(EvaluationPK pk);

}
