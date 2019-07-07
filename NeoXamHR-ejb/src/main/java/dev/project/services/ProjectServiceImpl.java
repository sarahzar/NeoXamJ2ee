package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dev.project.entities.Project;

@Stateless
public class ProjectServiceImpl implements ProjectServiceInterface{
	
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public void add(Project t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id) {
		Project p=em.find(Project.class, id);
		em.merge(p);
	}

	@Override
	public void delete(long id) {
		Project p=em.find(Project.class, id);
		em.remove(p);		
	}

	@Override
	public List<Project> getAll() {
		return em.createQuery("from Project p",Project.class).getResultList();
	}

	@Override
	public Project findById(long id) {
		return em.find(Project.class, id);
	}

}
