package dev.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.common.StringCrypter;
import dev.project.entities.User;

@Stateless
public class UserDaoImpl implements UserDaoInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	
	@Override
	public void add(User t) {
		try {
			t.setPassword(StringCrypter.encrypt(t.getPassword()));
			em.persist(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(long id, User t) {
		
		
		try {
			
			User u = em.find(User.class, id);
			System.out.println("old user: " + u);
			if (t.getAdresse() != null) {
				u.setAdresse(t.getAdresse());
			}
			
			u.setCompleted(t.isCompleted());
			
			u.setDiplomes(t.getDiplomes());
			u.setExperiences(t.getExperiences());
			u.setLangues(t.getLangues());
			u.setTrainnings(t.getTrainnings());
			u.setEmail(t.getEmail());
			u.setNom(t.getNom());
			u.setPrenom(t.getPrenom());
			u.setPhoto(t.getPhoto());		
			em.merge(u);
			u.setPassword(StringCrypter.encrypt(t.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		User u=em.find(User.class, id);
		em.remove(u);
		
	}

	@Override
	public User findById(long id) {
		
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAll() {
		
		return em.createQuery("from User",User.class).getResultList();
	}

	@Override
	public List<User> GetByKeyWord(String keyWord) {
		List<User> results = em.createQuery("SELECT t FROM User t where t.email=:key or t.nom=:key or t.prenom=:key",User.class)
                .setParameter("key", keyWord).getResultList();
		return results;
	}

	@Override
	public void UpdateImage(int Id, String ImageName) {
		
			User userOld = em.find(User.class, Id);
			userOld.setPhoto(ImageName);
			em.merge(userOld);	
	}

	@Override
	public User Login(String Login, String Password)  {
		

		List<User> users = em.createQuery("SELECT t FROM User t where t.email=:email", User.class)
				.setParameter("email", Login).getResultList();
		if (!users.isEmpty()) {

			return users.get(0);
		}
		return null;
	}

}
