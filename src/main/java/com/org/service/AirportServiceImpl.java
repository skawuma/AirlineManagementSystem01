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
	public void airportCreator(){

	Airport airport  = new Airport();

	airport.setAirportCode("AAA01");
    airport.setAirportLocation("Atlanta");
	airport.setAirportName("Hartsfield-jackson");
	airportRepo.save(airport);


	Airport airport1 = new Airport();

	airport1.setAirportCode("BBB01");
    airport1.setAirportLocation("Boston");
	airport1.setAirportName("Logan-International");
	airportRepo.save(airport1);


	Airport airport2 = new Airport();

	airport2.setAirportCode("CCC01");
    airport2.setAirportLocation("Chicago");
	airport2.setAirportName("Chicago-Midaway");
	airportRepo.save(airport2);

	}



}
