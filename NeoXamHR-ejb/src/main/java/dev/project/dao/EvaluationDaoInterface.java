package dev.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import dev.project.entities.Evaluation;
@Local
public interface EvaluationDaoInterface extends GenericCRUD<Evaluation> {
	Evaluation getEvalByDate(Date d);
	List<Evaluation> getEvalByEmp(long id);

	List<Evaluation> getEvalByRisk(String ris);

}
