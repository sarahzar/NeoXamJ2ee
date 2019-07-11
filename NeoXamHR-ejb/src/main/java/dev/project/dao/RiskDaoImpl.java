package dev.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Action;
import dev.project.entities.Risk;

@Stateless
public class RiskDaoImpl implements RiskDaoInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	
	@Override
	public void add(Risk t) {
	em.persist(t);
		
	}

	@Override
	public void updateRisk(String code, Risk t) {
		Risk OldOne = em.find(Risk.class, code);
		if (OldOne != null) {

			OldOne.setActionConsecutive(t.getActionConsecutive());
			OldOne.setActionPreventive(t.getActionPreventive());
			OldOne.setDescription(t.getDescription());
			OldOne.setFait(t.getFait());
			
		}
	}

	@Override
	public void delete(long id) {
		
	Risk r=	this.findById(id);
		 em.remove(r);
		
	}

	@Override
	public Risk findRisk(String id) {
		
		return em.find(Risk.class, id);
	}

	@Override
	public List<Risk> getAll() {
		
		return em.createQuery("from Risk",Risk.class).getResultList();
	}

	@Override
	public void update(long id, Risk r) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Risk findById(long id ) {
		return null;
		
	}

}
