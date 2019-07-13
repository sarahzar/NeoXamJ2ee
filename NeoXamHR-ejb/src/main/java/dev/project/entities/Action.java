package dev.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Action implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	private Date date;
	private String Label;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Risk> risquesP;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Risk> risquesC;
	
	public Action() {
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public Set<Risk> getRisquesP() {
		return risquesP;
	}
	public void setRisquesP(Set<Risk> risquesP) {
		this.risquesP = risquesP;
	}
	public Set<Risk> getRisquesC() {
		return risquesC;
	}
	public void setRisquesC(Set<Risk> risquesC) {
		this.risquesC = risquesC;
	}
	


}
