package dev.project.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.entities.*;

@Local
public interface DiplomaServiceInterface {

	List<Diploma> GetByUser(int IdUser);
	Diploma Get(int Id);
	void Add(Diploma diplome);
	void Delete(int Id);
	void Upadate(Diploma diplome);
}
