package dev.project.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dev.project.dao.ProjetDaoInterface;
import dev.project.entities.Project;

@Stateless
@LocalBean
public class ProjectServiceImpl implements ProjectServiceInterface{
	
	@EJB
	private ProjetDaoInterface dao;

	@Override
	public void addProjectDirector(long idProj, long idDir) {
		dao.addProjectDirector(idProj, idDir);

	}

	@Override
	public void add(Project t) {
		dao.add(t);

	}

	@Override
	public void update(long id, Project t) {
		dao.update(id, t);

	}

	@Override
	public void delete(long id) {
		dao.delete(id);

	}

	@Override
	public Project findById(long id) {

		return dao.findById(id);
	}

	@Override
	public List<Project> getAll() {

		return dao.getAll();
	}
	
	

	
}
