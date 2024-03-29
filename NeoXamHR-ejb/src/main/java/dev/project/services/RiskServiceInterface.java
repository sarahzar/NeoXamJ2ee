package dev.project.services;

import java.util.List;

import javax.ejb.Local;
import dev.project.dao.RiskDaoInterface;
import dev.project.entities.Risk;

@Local
public interface RiskServiceInterface extends RiskDaoInterface {



	public List<Risk> getRiskByConsAct(long IdCAct);

	public List<Risk> getRiskByPrevAct(long IdPrAct);


	public Risk findRisk(String code);

	public void updateRisk(String code, Risk R);



}
