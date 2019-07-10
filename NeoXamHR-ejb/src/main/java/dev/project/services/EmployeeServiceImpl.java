package dev.project.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.dao.EmployeeDaoInterface;
import dev.project.entities.Address;
import dev.project.entities.Employee;

@Stateless
@LocalBean
public class EmployeeServiceImpl implements EmployeesServiceInterface{

	@EJB
	EmployeeDaoInterface dao;
	
	
	@Override
	public void add(Employee t) {
		dao.add(t);
		
	}

	@Override
	public void update(long id, Employee t) {
		dao.update(id, t);
		
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public Employee findById(long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return dao.getAll();
	}
	
	

}
