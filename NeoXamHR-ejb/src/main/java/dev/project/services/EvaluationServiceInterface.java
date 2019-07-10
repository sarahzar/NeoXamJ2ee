package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.dao.EvaluationDaoInterface;
import dev.project.entities.Evaluation;
import dev.project.entities.EvaluationPK;

@Local
public interface EvaluationServiceInterface extends EvaluationDaoInterface {



}
