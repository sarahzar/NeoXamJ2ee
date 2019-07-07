package dev.project.services;

import javax.ejb.Remote;

import dev.project.entities.Project;

@Remote
public interface ProjectServiceInterface extends GenericCRUD<Project> {

}
