package dev.project.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.dao.DepartementDaoInterface;
import dev.project.entities.Departement;

@Local
public interface DepartementServiceInterface extends DepartementDaoInterface{

	
}
