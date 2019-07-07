package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

import dev.project.common.StringCrypter;
import dev.project.entities.Departement;
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
		List<User> results = em.createQuery("SELECT t FROM User t where t.email = :key or t.nom = :key or t.prenom = :key",User.class)
                .setParameter("key", keyWord).getResultList();
		return results;
		
	}

	@Override
	public List<User> GetAll() {
	List<User> users =	 em.createQuery("select u from user u", User.class).getResultList();
	return users;
	}

	@Override
	public Boolean addUser(User User) {
	
		try {
			User UserDb = 	 em.createQuery("select u from user u where u.email = :email", User.class)
					.setParameter("email", User.getEmail())
					.getSingleResult();
			if (UserDb == null)
				return false;
			
			String cryptedPassword =StringCrypter.encrypt(User.getPassword()) ;
				User.setPassword(cryptedPassword);
				em.persist(User);
				return true;
		} catch (Exception e) {
		return false;
		
		}
		

	}
	
	

	@Override
	public void DeleteUser(int Id) {
		try {
			User user = em.find(User.class, Id);
			if (user!=null)
				em.remove(user);
		}catch(Exception ex) {
			throw ex;
		}
		
	}

	@Override
	public void Update(User user) throws Exception {
		
		try {
			User userOld = em.find(User.class, user.getId());
			
			if (userOld == null) {
				throw new NotFoundException("L'utilisateur n'existe pas dans la base de données");
			}
			
			userOld = user;
			userOld.setPassword(StringCrypter.encrypt(user.getPassword()));
			
			em.merge(userOld);
		}catch(Exception ex) {
			
				throw ex;
			
		}
		

	}

	@Override
	public void UpdateImage(int Id, String ImageName) {
		try {
			User userOld = em.find(User.class, Id);
			
			if (userOld == null) {
				throw new NotFoundException("L'utilisateur n'existe pas dans la base de données");
			}
			
			userOld.setPhoto(ImageName);
			em.merge(userOld);
			
		}catch(Exception ex) {
			throw ex;
		}

	}

	@Override
	public User Login(String Login, String Password) throws Exception {
		String cryptedPassword = StringCrypter.encrypt(Password);
		User user = em.createQuery("SELECT t FROM User t where t.value = :key",User.class)
                .setParameter("Email", Login)
                .setParameter("Password", cryptedPassword)
                .getSingleResult();
		return user;
	}
	
	

}
