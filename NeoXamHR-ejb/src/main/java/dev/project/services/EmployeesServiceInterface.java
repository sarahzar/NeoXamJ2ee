package dev.project.services;

import javax.ejb.Local;
import javax.ejb.Remote;

import dev.project.dao.EmployeeDaoInterface;
import dev.project.dao.GenericCRUD;
import dev.project.entities.Employee;

@Local
public interface EmployeesServiceInterface  extends EmployeeDaoInterface {

}
