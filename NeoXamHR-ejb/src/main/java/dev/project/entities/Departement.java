package dev.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {
	@Id
    private String code;
    private String libelle;
    
    @OneToMany(mappedBy="dep") 
    private List<Employee> equipe;
    
    @ManyToOne
    private Employee directeur;
    
    
    public Departement() {
		// TODO Auto-generated constructor stub
	}
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public List<Employee> getEquipe() {
		return equipe;
	}


	public void setEquipe(List<Employee> equipe) {
		this.equipe = equipe;
	}


	public Employee getDirecteur() {
		return directeur;
	}


	public void setDirecteur(Employee directeur) {
		this.directeur = directeur;
	}
	
	
}
