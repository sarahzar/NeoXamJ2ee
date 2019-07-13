package dev.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		Risk OldOne = em.find(Risk.class, id);
		if (OldOne != null) {

			OldOne.setActionConsecutive(r.getActionConsecutive());
			OldOne.setActionPreventive(r.getActionPreventive());
			OldOne.setDescription(r.getDescription());
			OldOne.setFait(r.getFait());
		
		}
		
	}


	@Override
	public Risk findById(long id ) {
		return em.find(Risk.class, id);
		
	}

	@Override
	public List<Risk> getRiskByConsAct(long IdCAct) {
		
		 return em.createQuery("from Risk r where r.actionConsecutive =: IdCA",Risk.class).
				 setParameter("IdCA", IdCAct).getResultList();
	}

	@Override
	public List<Risk> getRiskByPrevAct(long IdPrAct) {
		 return em.createQuery("from Risk r where r.actionPreventive  =: IdPA",Risk.class).
				 setParameter("IdPA", IdPrAct).getResultList();
	}

}
