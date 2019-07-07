package dev.project.services;

import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.*;

@Remote
public interface DiplomaServiceInterface {

	List<Diploma> GetByUser(int IdUser);
	Diploma Get(int Id);
	void Add(Diploma diplome);
	void Delete(int Id);
	void Upadate(Diploma diplome);
}
