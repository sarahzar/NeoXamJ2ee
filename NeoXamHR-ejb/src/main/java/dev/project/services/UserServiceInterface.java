package dev.project.services;

import java.util.List;

import javax.ejb.Remote;

import dev.project.entities.User;
@Remote
public interface UserServiceInterface {



// 

User GetById(int Id);

List<User> GetByKeyWord(String keyWord);

List<User> GetAll();

Boolean addUser(User User);

void DeleteUser(int Id);

void Update(User user) throws Exception;

void UpdateImage(int Id, String ImageName);

User Login(String Login,String Password) throws Exception;


}
