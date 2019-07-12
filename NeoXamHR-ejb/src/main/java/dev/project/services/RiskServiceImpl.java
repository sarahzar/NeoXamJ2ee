package dev.project.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dev.project.dao.RiskDaoInterface;
import dev.project.entities.Risk;

@Stateless
@LocalBean
public class RiskServiceImpl implements RiskServiceInterface {

	@EJB
	RiskDaoInterface dao;

	@Override
	public void add(Risk t) {
		dao.add(t);
		
	}

	@Override
	public void update(long id, Risk t) {
		dao.update(id, t);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public Risk findRisk(String code) {
		
		return dao.findRisk(code);
	}

	@Override
	public List<Risk> getAll() {
		
		return dao.getAll();
	}

	@Override
	public void updateRisk(String code, Risk r) {
		dao.updateRisk(code, r);
		
	}

	@Override
	public Risk findById(long id) {
		return dao.findById(id);
	}

	@Override
	public List<Risk> getRiskByConsAct(Long IdCAct) {
		return dao.getRiskByConsAct(IdCAct);
	}

	@Override
	public List<Risk> getRiskByPrevAct(Long IdPrAct) {
		return dao.getRiskByPrevAct(IdPrAct);
	}

	



}
