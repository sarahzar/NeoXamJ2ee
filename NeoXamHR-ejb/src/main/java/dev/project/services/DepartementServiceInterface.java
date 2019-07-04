package dev.project.services;

import java.util.List;

import dev.project.entities.Departement;

public interface DepartementServiceInterface {

	boolean addDepartment(Departement d);
	Departement getDepartementById (int id);	
	List<Departement> getAllDepartements ();
}
