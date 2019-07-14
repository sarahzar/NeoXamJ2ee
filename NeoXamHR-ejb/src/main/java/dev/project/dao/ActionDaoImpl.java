package dev.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Action;

@Stateless
public class ActionDaoImpl implements ActionDaoInterface {
	
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public void add(Action t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id, Action t) {
		Action OldOne = em.find(Action.class, id);
		if (OldOne != null) {

			OldOne.setDate(t.getDate());
			OldOne.setLabel(t.getLabel());

		}
	}

	@Override
	public void delete(long id) {
		Action OldOne = em.find(Action.class, id);
		em.remove(OldOne);
		
	}

	@Override
	public Action findById(long id) {
	
		return em.find(Action.class, id);
	}

	@Override
	public List<Action> getAll() {
		
		return em.createQuery("select a from Action a",Action.class).getResultList();
	}

	@Override
	public Action GetActionByCode(String code) {
		
		return   em.find(Action.class, code);
	}

	@Override
	public Action getActionByDate(Date d) {
		
		return  (Action) em.createQuery("from Action a where a.date=:d", Action.class).setParameter("d", d);
	}

}
