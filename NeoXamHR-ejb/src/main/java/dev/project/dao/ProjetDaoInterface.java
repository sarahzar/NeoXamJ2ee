package dev.project.dao;

import javax.ejb.Local;

import dev.project.entities.Project;
@Local
public interface ProjetDaoInterface extends GenericCRUD<Project> {
	public void addProjectDirector(long idProj, long idDir);
}
