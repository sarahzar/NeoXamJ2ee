package dev.project.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.dao.DepartementDaoInterface;
import dev.project.entities.Departement;

@Stateless
@LocalBean
public class DepartementServiceImpl implements DepartementServiceInterface {
	
	@EJB
	DepartementDaoInterface dao;

	@Override
	public void add(Departement t) {
		dao.add(t);
		
	}

	@Override
	public void update(long id, Departement t) {
		dao.update(id, t);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public Departement findById(long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Departement> getAll() {
		
		return dao.getAll();
	}

	
}
