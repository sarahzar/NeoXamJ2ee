package dev.project.dao;

import java.util.List;

import javax.ejb.Local;

import dev.project.entities.Risk;
@Local
public interface RiskDaoInterface extends GenericCRUD<Risk> {
  public void updateRisk(String code,Risk r);
  public Risk findRisk(String code);

public List<Risk> getRiskByPrevAct(Long IdPrAct);
List<Risk> getRiskByConsAct(Long IdCAct);
}
