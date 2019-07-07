package dev.project.services;

import javax.ejb.Remote;

import dev.project.entities.Employee;

@Remote
public interface EmployeesServiceInterface extends GenericCRUD<Employee> {

}
