package dev.project.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotFoundException;

import dev.project.common.StringCrypter;
import dev.project.dao.UserDaoInterface;
import dev.project.entities.Departement;
import dev.project.entities.User;
@Stateless
@LocalBean
public class UserServiceImpl implements UserServiceInterface {
	
	@EJB
    UserDaoInterface dao;
	
	
	@Override
	public List<User> GetByKeyWord(String keyWord) {
		
		return dao.GetByKeyWord(keyWord);
	}

	@Override
	public void UpdateImage(int Id, String ImageName) {
		dao.UpdateImage(Id, ImageName);
		
	}

	@Override
	public User Login(String Login, String Password) {
		
		return dao.Login(Login, Password);
	}

	@Override
	public void add(User t) {
		dao.add(t);
		
	}

	@Override
	public void update(long id, User t) {
		dao.update(id, t);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public User findById(long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<User> getAll() {
		
		return dao.getAll();
	}
	
	

}
