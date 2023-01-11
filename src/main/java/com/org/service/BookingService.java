package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.entity.Booking;

public interface BookingService {
	
	
	public ResponseEntity<?> createBooking (Booking newBooking);
	
	public Booking updateBooking (Booking newBooking);
	
	public String deleteBooking(BigInteger bookingId);
	
	public Iterable<Booking> displayAllBooking();
	
	public ResponseEntity <?> findBookingId(BigInteger bookingId);
	
	
}
