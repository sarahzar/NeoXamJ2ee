package dev.project.services;

import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.Risk;
@Remote
public interface RiskServiceInterface {

	Risk getRiskById(String code);

	boolean AddRisk(Risk r);

	List<Risk> getRiskByConsAct(String IdCAct);

	List<Risk> getRiskByPrevAct(String IdPrAct);

	Risk GetRiskByCode(String code);

	List<Risk> getAllRisks();

	boolean UpdateRisk(String Id, Risk R);

	boolean DeleteRisk(String Id);

}
