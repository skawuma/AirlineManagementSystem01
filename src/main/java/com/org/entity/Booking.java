package com.org.entity;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Booking_tbr")
public class Booking {
	
	@Id
	private BigInteger bookingId;
	private Date bookingDate;
	private int numPAssengers;
	
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNumPAssengers() {
		return numPAssengers;
	}
	public void setNumPAssengers(int numPAssengers) {
		this.numPAssengers = numPAssengers;
	}

}
