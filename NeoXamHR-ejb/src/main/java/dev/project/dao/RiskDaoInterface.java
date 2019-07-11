package dev.project.dao;

import javax.ejb.Local;

import dev.project.entities.Risk;
@Local
public interface RiskDaoInterface extends GenericCRUD<Risk> {
  public void updateRisk(String code,Risk r);
  public Risk findRisk(String code);
}
