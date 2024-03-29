package dev.project.dao;

import java.util.List;

import javax.ejb.Local;

import dev.project.entities.Employee;
import dev.project.entities.Project;
@Local
public interface EmployeeDaoInterface extends GenericCRUD<Employee> {
	
	 public void affecterEmpProj(long empId,long projId);	
	 public List<Employee> getEmployeByDepartement(Long id);
	 public List<Employee> getEmployeesByProject(long idProj);
}
