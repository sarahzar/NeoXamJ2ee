package dev.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Action {
	
	@Id
	private String code;
	private Date date;
	
	@OneToMany(mappedBy="actionPreventive")
	private List<Risk> risquesP;
	
	@OneToMany(mappedBy="actionConsecutive")
	private List<Risk> risquesC;
	
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


}