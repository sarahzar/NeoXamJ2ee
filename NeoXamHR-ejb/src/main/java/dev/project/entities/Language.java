package dev.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Language implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String langue;
	private int niveauEcrit;
	private int niveauParle;
	
	@ManyToOne
	//@JsonBackReference
	private User user;
	
	public Language() {
		// TODO Auto-generated constructor stub
	}
	
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public int getNiveauEcrit() {
		return niveauEcrit;
	}
	public void setNiveauEcrit(int niveauEcrit) {
		this.niveauEcrit = niveauEcrit;
	}
	public int getNiveauParle() {
		return niveauParle;
	}
	public void setNiveauParle(int niveauParle) {
		this.niveauParle = niveauParle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
