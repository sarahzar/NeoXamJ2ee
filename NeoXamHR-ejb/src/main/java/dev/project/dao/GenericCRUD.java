package dev.project.dao;

import java.util.List;

import dev.project.entities.Employee;

public interface GenericCRUD<T> {
	
	public void add(T t);
	public void update(long id,T t);
	public void delete(long id);
	public T findById(long id);
	public List<T> getAll();

}
