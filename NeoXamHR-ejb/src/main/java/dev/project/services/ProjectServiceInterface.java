package dev.project.services;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.dao.GenericCRUD;
import dev.project.entities.Project;

@Local
public interface ProjectServiceInterface extends GenericCRUD<Project> {

}
