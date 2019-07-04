package dev.project.services;

import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.Departement;

@Remote
public interface DepartementServiceInterface {

	boolean addDepartment(Departement d);
	Departement getDepartementById (int id);	
	List<Departement> getAllDepartements ();
	boolean deleteDepartement(int id);
	boolean updateDepartement(int id, Departement d);
}
