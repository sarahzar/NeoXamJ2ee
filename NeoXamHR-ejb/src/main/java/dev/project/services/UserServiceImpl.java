package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

import dev.project.entities.User;
@Stateless
public class UserServiceImpl implements UserServiceInterface {
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	
	@Override
	public User GetById(int Id) {
		// TODO Auto-generated method stub
		
			User user = em.find(User.class, Id) ;
			if (user == null)
				throw new NotFoundException("Utilisateur introuvable dans la base de donnés");
			return  user;
		
	}

	@Override
	public List<User> GetByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		List<User> results = em.createQuery("SELECT t FROM User t where t.value = :value1")
                .setParameter("value1", "some value").getResultList();
		return results;
		
	}

	@Override
	public List<User> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User User) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteUser(int Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateImage(int Id, String ImageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public User Login(String Login, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

}
