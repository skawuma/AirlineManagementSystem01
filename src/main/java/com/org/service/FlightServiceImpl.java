package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.entity.Flight;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.repo.FlightRepo;
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepo flightRepo;
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepo.findById(flight.getFlightNo());
		try {
		if (!findById.isPresent()) {
			flightRepo.save(flight);
			return new ResponseEntity<>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Iterable<Flight> viewAllFlight() {
		// TODO Auto-generated method stub
		return flightRepo.findAll();
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepo.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	    }
	
	
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightRepo.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightRepo.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		return flight;
	}

	@Override
	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepo.findById(flightNumber);
		if (findById.isPresent()) {
			flightRepo.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}

}
