package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.dao.ActionDaoInterface;
import dev.project.entities.Action;

@Stateless
@LocalBean
public class ActionServiceImpl implements ActionServiceInterface {
	
	@EJB
	private ActionDaoInterface dao;

	@Override
	public Action GetActionByCode(String code) {
		
		return dao.GetActionByCode(code);
	}

	@Override
	public Action getActionByDate(Date d) {
		
		return dao.getActionByDate(d);
	}

	@Override
	public void add(Action t) {
		dao.add(t);
		
	}

	@Override
	public void update(long id, Action t) {
		dao.update(id, t);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public Action findById(long id) {
	
		return dao.findById(id);
	}

	@Override
	public List<Action> getAll() {
		
		return dao.getAll();
	}

	
}
