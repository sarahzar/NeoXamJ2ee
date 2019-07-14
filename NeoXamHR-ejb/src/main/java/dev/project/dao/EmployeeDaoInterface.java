package dev.project.dao;

import javax.ejb.Local;

import dev.project.entities.Employee;
@Local
public interface EmployeeDaoInterface extends GenericCRUD<Employee> {
	
	 public void affecterEmpProj(long empId,long projId);

}
