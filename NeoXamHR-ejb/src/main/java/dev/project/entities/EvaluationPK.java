package dev.project.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvaluationPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long empId;
	private long risqueId;
	
	public EvaluationPK() {
		// TODO Auto-generated constructor stub
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getRisqueId() {
		return risqueId;
	}

	public void setRisqueId(long risqueId) {
		this.risqueId = risqueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (empId ^ (empId >>> 32));
		result = prime * result + (int) (risqueId ^ (risqueId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationPK other = (EvaluationPK) obj;
		if (empId != other.empId)
			return false;
		if (risqueId != other.risqueId)
			return false;
		return true;
	}

	

	

}
