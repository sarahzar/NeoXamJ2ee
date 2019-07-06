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

void addUser(User User);

void DeleteUser(int Id);

void Update();

void UpdateImage(int Id, String ImageName);

User Login(String Login,String Password);


}
