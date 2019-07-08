package dev.project.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Departement;

@Stateless
public class DepartementServiceImpl implements DepartementServiceInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public boolean addDepartment(Departement d) {
		em.persist(d);
		if ((em.find(Departement.class, d.getCode())!= null)) {
			return true;
		}
		return false;
	}

	@Override
	public Departement getDepartementById(int id) {
		return em.find(Departement.class, id);
	}

	@Override
	public List<Departement> getAllDepartements() {
		return em.createQuery("select d from Departement d", Departement.class).getResultList();
	}

	@Override
	public boolean deleteDepartement(int id) {
		Departement d = em.find(Departement.class, id);
		if (d != null) {
			em.remove(d);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateDepartement(int id, Departement d) {
		Departement depOld=em.find(Departement.class, id);
		if (depOld != null) {
			depOld.setDirecteur(d.getDirecteur());
			depOld.setEquipe(d.getEquipe());
			depOld.setLibelle(d.getLibelle());	
			return true;
		}
		return false;
	}

}
