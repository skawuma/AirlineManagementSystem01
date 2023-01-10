package com.org.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {
	@Id
	private String airportCode;
	private String  airportLocation;
	private String  airportName;
	
	@Override
	public int hashCode() {
		return Objects.hash(airportCode, airportLocation, airportName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Airport)) {
			return false;
		}
		Airport other = (Airport) obj;
		return Objects.equals(airportCode, other.airportCode) && Objects.equals(airportLocation, other.airportLocation)
				&& Objects.equals(airportName, other.airportName);
	}
	public Airport(String airportCode, String airportLocation, String airportName) {
		super();
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
		this.airportName = airportName;
		
	}
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportLocation=" + airportLocation + ", airportName="
				+ airportName + "]";
	}
	
	
	

}
