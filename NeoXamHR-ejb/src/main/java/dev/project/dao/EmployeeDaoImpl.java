package dev.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Address;
import dev.project.entities.Employee;
import dev.project.entities.Project;
@Stateless
@LocalBean
public class EmployeeDaoImpl implements EmployeeDaoInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;
	
	@EJB
	ProjetDaoInterface daoProj;

	@Override
	public void add(Employee t) {
		em.persist(t);
		
	}

	@Override
	public void update(long id,Employee e) {
		Employee emp=em.find(Employee.class, id);
		Address a=new Address();
		a.setCodePostale(e.getAdresse().getCodePostale());
		a.setNumero(e.getAdresse().getNumero());
		a.setPays(e.getAdresse().getPays());
		a.setRue(e.getAdresse().getRue());
		a.setVille(e.getAdresse().getVille());
		emp.setAdresse(a);
		emp.setCompleted(e.isCompleted());
		emp.setEmail(e.getEmail());
		emp.setDateEmbauche(e.getDateEmbauche());
		emp.setNom(e.getNom());
		emp.setNumTel(e.getNumTel());
		emp.setPassword(e.getPassword());
		emp.setPrenom(e.getPrenom());
		emp.setPoste(e.getPoste());
		emp.setSalaire(e.getSalaire());
		emp.setRole(e.getRole());
		emp.setDep(e.getDep());
//		emp.setListdepAgerer(e.getListdepAgerer());
		emp.setRegisterDate(e.getRegisterDate());
		
		em.merge(emp);
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

	@Override
	public void affecterEmpProj(long empId,long projId) {
		Employee emp=em.find(Employee.class, empId);
		Project proj=em.find(Project.class, projId);
		proj.getEmployeeAparticiper().add(emp);
		daoProj.update(projId, proj);
	}
	public List<Employee> getEmployeByDepartement(Long id) {
		List<Employee> myList = new ArrayList<Employee>();
		for (Employee e:em.createQuery("from Employee e",Employee.class).getResultList()){
			if(e.getId()==id)
				myList.add(e);
		}
		System.out.println(myList.get(0).getNom());
		return myList;	
	}

	@Override
	public List<Employee> getEmployeesByProject(long idProj) {
		Project proj=em.find(Project.class, idProj);
		List<Employee> employeesByProj=new ArrayList<>();
		employeesByProj.addAll(proj!=null?proj.getEmployeeAparticiper():null);
		return employeesByProj;
	}
}
