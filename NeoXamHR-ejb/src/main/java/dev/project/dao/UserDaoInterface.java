package dev.project.dao;

import javax.ejb.Remote;

import dev.project.entities.User;

@Remote
public interface UserDaoInterface extends GenericCRUD<User>{

}
