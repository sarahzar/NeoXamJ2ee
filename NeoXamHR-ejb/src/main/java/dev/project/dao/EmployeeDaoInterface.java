package dev.project.dao;

import java.util.List;

import javax.ejb.Local;

import dev.project.entities.Employee;
@Local
public interface EmployeeDaoInterface extends GenericCRUD<Employee> {
	
	 public void affecterEmpProj(long empId,long projId);

	
	List<Employee> getEmployeByDepartement(Long id);
}
