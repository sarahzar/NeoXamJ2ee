package dev.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee extends User {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateEmbauche;
	private String poste;
	private int numTel;
	private int salaire;
	
	@ManyToOne
	private Departement dep;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JsonIgnore
//	private Set<Departement> ListdepAgerer;

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(String email, String nom, String photo, String prenom, String password, Date registerDate, String role,
			boolean isCompleted, Address adresse,Date dateEmbauche, String poste, int numTel, int salaire) {
		super(email, nom, photo, prenom, password, registerDate, role,
				 isCompleted, adresse);
		this.dateEmbauche = dateEmbauche;
		this.poste = poste;
		this.numTel = numTel;
		this.salaire = salaire;
	}







	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public Departement getDep() {
		return dep;
	}


	public void setDep(Departement dep) {
		this.dep = dep;
	}



//	public Set<Departement> getListdepAgerer() {
//		return ListdepAgerer;
//	}
//
//
//	public void setListdepAgerer(Set<Departement> listdepAgerer) {
//		ListdepAgerer = listdepAgerer;
//	}

//
//	public Set<Project> getProjetsAPiloter() {
//		return projetsAPiloter;
//	}
//
//
//	public void setProjetsAPiloter(Set<Project> projetsAPiloter) {
//		this.projetsAPiloter = projetsAPiloter;
//	}
//
//
//	public Set<Project> getProjetsParticipation() {
//		return projetsParticipation;
//	}
//
//
//	public void setProjetsParticipation(Set<Project> projetsParticipation) {
//		this.projetsParticipation = projetsParticipation;
//	}
//    


	

}
