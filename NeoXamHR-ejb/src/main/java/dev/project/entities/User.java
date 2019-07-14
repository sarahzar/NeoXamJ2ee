package dev.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected long id;
	protected String email;
	protected String nom;
	protected String photo;
	protected String prenom;
	protected String password;
	protected Date registerDate;
	protected String role;
	protected boolean isCompleted;
	
	
	@Embedded
	protected Address adresse;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Diploma> diplomes;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Language> langues;
	
	@OneToMany(fetch=FetchType.EAGER) 
	@JsonIgnore
	private Set<Experience> experiences;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Trainning> trainnings;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String email, String nom, String photo, String prenom, String password, Date registerDate, String role,
			boolean isCompleted, Address adresse) {
		
		this.email = email;
		this.nom = nom;
		this.photo = photo;
		this.prenom = prenom;
		this.password = password;
		this.registerDate = registerDate;
		this.role = role;
		this.isCompleted = isCompleted;
		this.adresse = adresse;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Address getAdresse() {
		return adresse;
	}
	public void setAdresse(Address adresse) {
		this.adresse = adresse;
	}






//	public List<Experience> getExperiences() {
//		return experiences;
//	}
//
//
//
//	public void setExperiences(List<Experience> experiences) {
//		this.experiences = experiences;
//	}






	public Set<Diploma> getDiplomes() {
		return diplomes;
	}



	public void setDiplomes(Set<Diploma> diplomes) {
		this.diplomes = diplomes;
	}



	public Set<Language> getLangues() {
		return langues;
	}



	public void setLangues(Set<Language> langues) {
		this.langues = langues;
	}



	public Set<Trainning> getTrainnings() {
		return trainnings;
	}



	public void setTrainnings(Set<Trainning> trainnings) {
		this.trainnings = trainnings;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Set<Experience> getExperiences() {
		return experiences;
	}



	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}
	
	

}
