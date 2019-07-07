package dev.project.services;

import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.*;

@Remote
public interface LanguageServiceInterface {

	List<Language> GetByUser(int IdUser);
	Language Get(int Id);
	void Add(Language Language);
	void Delete(int Id);
	void Upadate(Language Language);
}
