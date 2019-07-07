package dev.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Employee;

@Stateless
public class EmployeeServiceImpl implements EmployeesServiceInterface{
	
	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	@Override
	public void add(Employee t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id) {
		Employee e=em.find(Employee.class, id);
		em.merge(e);
	}

	@Override
	public void delete(long id) {
		Employee e=em.find(Employee.class, id);
		em.remove(e);		
	}

	@Override
	public List<Employee> getAll() {		
		return em.createQuery("from Employee e",Employee.class).getResultList();
	}

	@Override
	public Employee findById(long id) {	
		return em.find(Employee.class, id);
	}

}
