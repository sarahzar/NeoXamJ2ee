package dev.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Employee;
import dev.project.entities.Project;

@Stateless
public class ProjetDaoImpl implements ProjetDaoInterface {
	
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public void add(Project t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id,Project p) {
		Project proj=em.find(Project.class, id);
		proj.setAvancement(p.getAvancement());
		proj.setDateDeb(p.getDateDeb());
		proj.setDateFin(p.getDateFin());
		proj.setDesignation(p.getDesignation());
		proj.setChefDeProjet(p.getChefDeProjet());
		proj.setEmployeeAparticiper(p.getEmployeeAparticiper());
		em.merge(proj);
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

	@Override
	public void addProjectDirector(long idProj, long idDir) {
		Project proj=em.find(Project.class, idProj);
		Employee directeur=em.find(Employee.class, idDir);
		proj.setChefDeProjet(directeur);
		update(idProj, proj);		
	}

}
