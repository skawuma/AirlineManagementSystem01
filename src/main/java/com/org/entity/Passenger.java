package com.org.entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
@Entity
public class Passenger {
	
	private long  psnNumber;
	private String psnName;
	private int psnAge;
	private BigInteger psnUIN;
	private Double luggage;
	public long getPsnNumber() {
		return psnNumber;
	}
	public void setPsnNumber(long psnNumber) {
		this.psnNumber = psnNumber;
	}
	public String getPsnName() {
		return psnName;
	}
	public void setPsnName(String psnName) {
		this.psnName = psnName;
	}
	public int getPsnAge() {
		return psnAge;
	}
	public void setPsnAge(int psnAge) {
		this.psnAge = psnAge;
	}
	public BigInteger getPsnUIN() {
		return psnUIN;
	}
	public void setPsnUIN(BigInteger psnUIN) {
		this.psnUIN = psnUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
	
	

}
