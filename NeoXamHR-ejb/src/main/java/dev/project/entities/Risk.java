package dev.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Risk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String code;
	private String description;
	private String fait;
	
	@ManyToOne
	private Action actionPreventive;
	
	@ManyToOne
	private Action actionConsecutive;
	
	public Risk() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Risk(String code, String description, String fait) {
		super();
		this.code = code;
		this.description = description;
		this.fait = fait;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFait() {
		return fait;
	}
	public void setFait(String fait) {
		this.fait = fait;
	}


	public Action getActionPreventive() {
		return actionPreventive;
	}


	public void setActionPreventive(Action actionPreventive) {
		this.actionPreventive = actionPreventive;
	}


	public Action getActionConsecutive() {
		return actionConsecutive;
	}


	public void setActionConsecutive(Action actionConsecutive) {
		this.actionConsecutive = actionConsecutive;
	}
	
	
	
	
	

}
