package dev.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation implements Serializable {
	
	
	
	@EmbeddedId
	private EvaluationPK id;	
	
	@ManyToOne
	@JoinColumn(name="empId",nullable = false, insertable = false, updatable = false)
	private Employee emp;
	
	@ManyToOne
	@JoinColumn(name="risqueId",nullable = false, insertable = false, updatable = false)
	private Risk risque;
	
	private Date date;	
	private int risqueGlobal;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}
	
	public EvaluationPK getId() {
		return id;
	}

	public void setId(EvaluationPK id) {
		this.id = id;
	}


	public int getRisqueGlobal() {
		return risqueGlobal;
	}


	public void setRisqueGlobal(int risqueGlobal) {
		this.risqueGlobal = risqueGlobal;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}



	

}
