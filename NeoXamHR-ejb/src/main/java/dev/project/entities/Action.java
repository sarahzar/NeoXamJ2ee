package dev.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Action implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 937773213808441123L;
	@Id
	private String code;
	private Date date;
	private String Label;
	
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
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}


}
