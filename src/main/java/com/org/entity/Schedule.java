package com.org.entity;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "schedule_tbr")
public class Schedule {
	@Id
	@Size(min = 3, max = 15)
	@Column(name = "schedule_Id")
	private BigInteger  scheduleId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport origAirport;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airport dstnAirport;
	
	@Column(name = "depature_date")
	
	private Date deptDateTime;
	
	@Column(name = "arrival_date")
	private  Date arrDateTime;
	
	
	
	
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", origAirport=" + origAirport + ", dstnAirport=" + dstnAirport
				+ ", deptDateTime=" + deptDateTime + ", arrDateTime=" + arrDateTime + "]";
	}




	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Schedule(BigInteger scheduleId, Airport origAirport, Airport dstnAirport, Date deptDateTime,
			Date arrDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.origAirport = origAirport;
		this.dstnAirport = dstnAirport;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}




	public BigInteger getScheduleId() {
		return scheduleId;
	}




	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}




	public Airport getOrigAirport() {
		return origAirport;
	}




	public void setOrigAirport(Airport origAirport) {
		this.origAirport = origAirport;
	}




	public Airport getDstnAirport() {
		return dstnAirport;
	}




	public void setDstnAirport(Airport dstnAirport) {
		this.dstnAirport = dstnAirport;
	}




	public Date getDeptDateTime() {
		return deptDateTime;
	}




	public void setDeptDateTime(Date deptDateTime) {
		this.deptDateTime = deptDateTime;
	}




	public Date getArrDateTime() {
		return arrDateTime;
	}




	public void setArrDateTime(Date arrDateTime) {
		this.arrDateTime = arrDateTime;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrDateTime == null) ? 0 : arrDateTime.hashCode());
		result = prime * result + ((deptDateTime == null) ? 0 : deptDateTime.hashCode());
		result = prime * result + ((dstnAirport == null) ? 0 : dstnAirport.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((origAirport== null) ? 0 : origAirport.hashCode());
		return result;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Schedule other = (Schedule) obj;
		if (arrDateTime == null) {
			if (other.arrDateTime != null)
				return false;
		} else if (!arrDateTime.equals(other.arrDateTime))
			return false;
		if (deptDateTime == null) {
			if (other.deptDateTime != null)
				return false;
		} else if (!deptDateTime.equals(other.deptDateTime))
			return false;
		if (dstnAirport == null) {
			if (other.dstnAirport != null)
				return false;
		} else if (!dstnAirport.equals(other.dstnAirport))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (origAirport == null) {
			if (other.origAirport != null)
				return false;
		} else if (!origAirport.equals(other.origAirport))
			return false;
		return true;
	}

	
	
}
