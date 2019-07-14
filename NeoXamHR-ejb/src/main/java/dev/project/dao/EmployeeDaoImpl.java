package dev.project.dao;

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
		emp.setDiplomes(e.getDiplomes());
		emp.setExperiences(e.getExperiences());
		emp.setLangues(e.getLangues());
		emp.setListdepAgerer(e.getListdepAgerer());
		emp.setProjetsAPiloter(e.getProjetsAPiloter());
		emp.setProjetsParticipation(e.getProjetsParticipation());
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
	public void affecterEmpProj(long empId, long projId) {
		Employee emp=em.find(Employee.class, empId);
		Project proj=em.find(Project.class, projId);
		emp.getProjetsParticipation().add(proj);
		proj.getEmployeeAparticiper().add(emp);
		this.update(empId, emp);
		daoProj.update(projId, proj);
		
	}
}
