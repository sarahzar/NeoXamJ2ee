package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

import dev.project.entities.Diploma;
import dev.project.entities.Language;
@Stateless
public class LanguageServiceImpl implements LanguageServiceInterface {
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	
	@Override
	public List<Language> GetByUser(int IdUser) {
		return em.createQuery("select l from language l where l.iduser = :iduser", Language.class)
				.setParameter("iduser", IdUser).getResultList();
	}

	@Override
	public Language Get(int Id) {
		Language langue = em.find(Language.class, Id);
		if (langue == null) {
			throw new NotFoundException("la langue est introuvable");
		}
		return langue;
	}

	@Override
	public void Add(Language Language) {
		
		try {
			if (Language != null) {
				em.persist(Language);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		

	}

	@Override
	public void Delete(int Id) {
		try {
			Language language = em.find(Language.class, Id);
			if (language != null) {
				em.remove(language);
			}
		}
		catch(Exception ex) {
			throw ex;
		}

	}

	@Override
	public void Upadate(Language language) {
      try {
    	  Language oldLanguage = em.find(Language.class, language.getId());
    	  if (oldLanguage == null)
    		  throw new NotFoundException("La langue n'existe pas dans la base de données");
    	  oldLanguage = language;
    	  
      }catch (Exception ex) {
    	  throw ex;
      }
	}

}
