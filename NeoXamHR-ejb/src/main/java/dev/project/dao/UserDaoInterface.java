package dev.project.dao;

import java.util.List;

import javax.ejb.Local;
import dev.project.entities.User;

@Local
public interface UserDaoInterface extends GenericCRUD<User>{
	
	public List<User> GetByKeyWord(String keyWord);
	public void UpdateImage(int Id, String ImageName);
	public User Login(String Login, String Password);

}
