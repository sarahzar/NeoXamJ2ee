package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

import dev.project.entities.Diploma;
import dev.project.entities.Language;
@Stateless
public class DiplomaServiceImpl implements DiplomaServiceInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	@Override
	public List<Diploma> GetByUser(int IdUser) {
		return em.createQuery("select l  from diploma l where l.iduser = :iduser", Diploma.class)
				.setParameter("iduser", IdUser).getResultList();
	}

	@Override
	public Diploma Get(int Id) {
		
		Diploma diplome = em.find(Diploma.class, Id);
		if (diplome == null) {
			throw new NotFoundException("le diplome est introuvable");
		}
		return diplome;
	}

	@Override
	public void Add(Diploma diplome) {
		
		try {
			em.persist(diplome);
		}
		catch (Exception ex){
			throw ex;
		}

	}

	@Override
	public void Delete(int Id) {
		
		try {
			Diploma diplome = em.find(Diploma.class, Id);
			if (diplome != null)
				em.remove(diplome);
			
		}
		catch(Exception ex) {
			throw ex;
		}
		

	}

	@Override
	public void Upadate(Diploma diplome) {
		  try {
	    	  Diploma oldDiplome = em.find(Diploma.class, diplome.getId());
	    	  if (oldDiplome == null)
	    		  throw new NotFoundException("La langue n'existe pas dans la base de données");
	    	  oldDiplome = diplome;
	    	  
	    	  
	      }catch (Exception ex) {
	    	  throw ex;
	      }

	}

}
