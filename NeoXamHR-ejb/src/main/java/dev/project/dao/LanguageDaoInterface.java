package dev.project.dao;

import javax.ejb.Local;

import dev.project.entities.Language;
@Local
public interface LanguageDaoInterface extends GenericCRUD<Language> {

}
