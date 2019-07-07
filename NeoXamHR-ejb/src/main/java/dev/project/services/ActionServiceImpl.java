package dev.project.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Action;

@Stateless
public class ActionServiceImpl implements ActionServiceInterface {

	@PersistenceContext(unitName = "neo")
	EntityManager em;

	// method to get action by its Id

	@Override
	public Action getActionById(String id) {
		return em.find(Action.class, id);
	}

	// method to add new action
	@Override
	public boolean AddAction(Action act) {
		if (this.getActionById(act.getCode()) == null) {
			em.persist(act);
			return true;
		}
		return false;
	}

	// method to get action by its Date
	@Override
	public Action getActionByDate(Date d) {
		return em.find(Action.class, d);
	}

	// method to get action by its Id using query
	@Override
	public Action GetActionByCode(String code) {
		return (Action) em.createQuery("select a.* from Action a where a.code=" + code + '"', Action.class);
	}

	// method to get all actions in list format
	@Override
	public List<Action> getAllActions() {
		/*Action action1 = new Action();
		action1.setCode("52");
		action1.setDate(new Date());
		action1.setLabel("sddsds");
		Action action2 = new Action();
		action2.setCode("52");
		action2.setDate(new Date());
		action2.setLabel("sddsds");
		List<Action> listcc = Arrays.asList(action1, action2);*/
		System.out.println("ttttttttttt"+em);
		
		return em.createQuery("select * from action",Action.class).getResultList();
	}

	// method to update action
	@Override
	public boolean UpdateAction(String Id, Action A) {
		Action OldOne = this.GetActionByCode(Id);
		if (this.GetActionByCode(Id) != null) {

			OldOne.setDate(A.getDate());
			OldOne.setLabel(A.getLabel());
			return true;
		}

		return false;
	}

	// method to Delete action
	@Override
	public boolean DeleteAction(String Id) {
		Action OldOne = this.GetActionByCode(Id);
		if (this.GetActionByCode(Id) != null) {
			em.remove(OldOne);

			return true;
		}

		return false;
	}
}
