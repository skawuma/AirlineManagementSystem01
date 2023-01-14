package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.entity.Airport;
import com.org.entity.Booking;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.repo.BookingRepo;

@Service

public class BookingServiceImpl implements BookingService {

	
	BookingRepo bookingRepo;
	
	
	@Override
	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingRepo.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				bookingRepo.save(newBooking);
				return new ResponseEntity<>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingRepo.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingRepo.save(changedBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}

	@Override
	public String deleteBooking(BigInteger bookingId) {

		Optional<Booking> findBookingById = bookingRepo.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingRepo.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	@Override
	public Iterable<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}

	@Override
	public ResponseEntity<?> findBookingId(BigInteger bookingId) {
		Optional<Booking> findById = bookingRepo.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	



}