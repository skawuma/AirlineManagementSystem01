package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.entity.Airport;
import com.org.entity.Booking;
import com.org.exceptions.RecordAlreadyPresentException;

public class BookingServiceImpl implements BookingService {

	@Override
	public ResponseEntity<?> createBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking updateBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBooking(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findBookingId(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}