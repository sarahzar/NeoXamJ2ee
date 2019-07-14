package dev.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Long code;
    private String libelle;
    
    @OneToMany(fetch=FetchType.EAGER) 
    @JsonIgnore
    private List<Employee> equipe;
    
    
    @ManyToOne
    @JsonIgnore
    private Employee directeur;
    
    
    public Departement() {
		// TODO Auto-generated constructor stub
	}
    
    
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



//	public List<Employee> getEquipe() {
//		return equipe;
//	}
//
//
//	public void setEquipe(List<Employee> equipe) {
//		this.equipe = equipe;
//	}


	public Employee getDirecteur() {
		return directeur;
	}


	public void setDirecteur(Employee directeur) {
		this.directeur = directeur;
	}
	
	
}
