package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.entity.Airport;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.repo.AirportRepo;
@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepo airportRepo;
	
	
	@Override
	public Iterable<Airport> viewAllAirport() {
		// TODO Auto-generated method stub
		return airportRepo.findAll();
	}

	@Override
	public Airport viewAirport(String airportCode) {
		// TODO Auto-generated method stub
		
		 
		Optional <Airport>findById = airportRepo.findById(airportCode);
		if(findById.isPresent()) {
			return findById.get();
		}
		
		else 
		throw new RecordNotFoundException 	("Airport with airportcode: " + airportCode+ " deosent exists");
	
	}

	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportRepo.findById(airport.getAirportCode());
		try {
		if (!findById.isPresent()) {
			airportRepo.save(airport);
			return new ResponseEntity<>(airport,HttpStatus.OK);
		}
		else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(airport,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportRepo.findById(airport.getAirportCode());
		if (findById.isPresent()) {
			airportRepo.save(airport);
		}
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
		return airport;
	}

	@Override
	public String removeAirport(String airportCode) {
		Optional<Airport> findById = airportRepo.findById(airportCode);
		if (findById.isPresent()) {
			airportRepo.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}

}
