package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.entity.Airport;
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
		return null;
	}

	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport modifyAirport(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAirport(String airportCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
