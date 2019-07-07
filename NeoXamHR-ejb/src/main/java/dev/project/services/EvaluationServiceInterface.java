package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;

@Remote
public interface EvaluationServiceInterface {

	Evaluation getEvalByDate(Date d);

	List<Evaluation> getAllEval();

	Evaluation getEvalById(EvaluationPK epk);

	boolean UpdateEval(EvaluationPK Id, Evaluation E);

	boolean DeleteEval(EvaluationPK epk);

	boolean AddEval(Evaluation e);

	List<Evaluation> getEvalByEmp(long id);

	List<Evaluation> getEvalByRisk(String ris);

}
