package dev.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date dateDeb;
	private Date DateFin;
	private int avancement;
	private String designation;
	
	
	@ManyToMany(mappedBy="projetsParticipation")
    @JsonIgnore
	private List<Employee> employeeAparticiper;
	
	@ManyToOne
	private Employee chefDeProjet;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(Date dateDeb, Date dateFin, int avancement, String designation) {
		super();
		this.dateDeb = dateDeb;
		DateFin = dateFin;
		this.avancement = avancement;
		this.designation = designation;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public int getAvancement() {
		return avancement;
	}
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public List<Employee> getEmployeeAparticiper() {
		return employeeAparticiper;
	}



	public void setEmployeeAparticiper(List<Employee> employeeAparticiper) {
		this.employeeAparticiper = employeeAparticiper;
	}



	public Employee getChefDeProjet() {
		return chefDeProjet;
	}



	public void setChefDeProjet(Employee chefDeProjet) {
		this.chefDeProjet = chefDeProjet;
	}
	
	
	
	
	

}
