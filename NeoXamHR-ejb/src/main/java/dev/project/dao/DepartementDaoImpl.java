package dev.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Departement;

@Stateless
public class DepartementDaoImpl implements DepartementDaoInterface {
	
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public void add(Departement t) {
		em.persist(t);
	//	System.out.println("dep code"+t.getCode());
	}

	@Override
	public void update(long id, Departement t) {
		Departement depOld=em.find(Departement.class, id);
		if (depOld != null) {
			depOld.setDirecteur(t.getDirecteur());
			depOld.setLibelle(t.getLibelle());	
			
		}
		
	}

	@Override
	public void delete(long id) {
		Departement depOld=em.find(Departement.class, id);
		em.remove(depOld);
		
	}

	@Override
	public Departement findById(long id) {
		
		return em.find(Departement.class, id);
	}

	@Override
	public List<Departement> getAll() {
		
		return em.createQuery("select d from Departement d", Departement.class).getResultList();
	}

}
