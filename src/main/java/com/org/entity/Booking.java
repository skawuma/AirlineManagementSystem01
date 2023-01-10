package com.org.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	private long bookingId;
	private Date bookingDate;
	private int numPAssengers;
	
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
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
