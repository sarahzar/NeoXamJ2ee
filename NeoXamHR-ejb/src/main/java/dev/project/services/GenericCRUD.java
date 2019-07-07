package dev.project.services;

import java.util.List;

public interface GenericCRUD<T> {
	
	public void add(T t);
	public void update(long id);
	public void delete(long id);
	public T findById(long id);
	public List<T> getAll();

}
