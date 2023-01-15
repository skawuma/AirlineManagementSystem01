package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Schedule;
import com.org.entity.ScheduledFlight;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.exceptions.ScheduledFlightNotFoundExceptions;
import com.org.service.AirportService;
import com.org.service.FlightService;
import com.org.service.ScheduledFlightService;

import java.math.BigInteger;
import java.sql.Date;
@RestController
@CrossOrigin
@RequestMapping("/api/scheduleFlight")
public class ScheduledFlightContoller {
	
	@Autowired
	ScheduledFlightService scheduleFlightService;

	@Autowired
	AirportService airportService;

	@Autowired
	FlightService flightService;

	/*
	 * Controller for adding Scheduled Flights
	 */
	@PostMapping("/add")
	
	public ResponseEntity<ScheduledFlight> addSF(@ModelAttribute ScheduledFlight scheduledFlight,
			@RequestParam(name = "OrigAirport") String source, @RequestParam(name = "dstnAirport") String destination,
			@RequestParam(name = "deptDateTime") Date departureTime, @RequestParam(name = "arrDateTime") Date arrivalTime) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
		try {
			schedule.setOrigAirport(airportService.viewAirport(source));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		try {
			schedule.setDstnAirport(airportService.viewAirport(destination));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);
		try {
			scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
		} catch (RecordNotFoundException e1) {
			return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
		}
		scheduledFlight.setSchedule(schedule);
		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
		try {
			return new ResponseEntity<>(scheduleFlightService.addScheduledFlight(scheduledFlight),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
		}
	}

	
	@PutMapping("/modify")
	public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
		ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (modifySFlight == null) {
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(modifySFlight, HttpStatus.OK);
		}

	}
	@DeleteMapping("/delete")
	public String deleteSF(@RequestParam BigInteger flightId) throws RecordNotFoundException {
		return scheduleFlightService.removeScheduledFlight(flightId);
	}
	
	@GetMapping("/search")
	@ExceptionHandler(ScheduledFlightNotFoundExceptions.class)
	public ResponseEntity<ScheduledFlight> viewSF(@RequestParam BigInteger flightId) throws ScheduledFlightNotFoundExceptions {
		ScheduledFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(searchSFlight, HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
}
