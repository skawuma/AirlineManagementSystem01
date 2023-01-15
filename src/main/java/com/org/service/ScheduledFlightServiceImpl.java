package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.entity.Schedule;
import com.org.entity.ScheduledFlight;
import com.org.exceptions.RecordNotFoundException;
import com.org.exceptions.ScheduledFlightNotFoundExceptions;
import com.org.repo.ScheduleRepo;
import com.org.repo.ScheduledFlightRepo;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	ScheduledFlightRepo sfrepo;
	ScheduleRepo  schedulerepo;
	//BookingService bookingservice;
	
	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		return sfrepo.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
		ScheduledFlight updateScheduleFlight = sfrepo.findById(scheduleFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = schedulerepo.findById(scheduleFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		updateSchedule.setOrigAirport(scheduleFlight.getSchedule().getOrigAirport());
		updateSchedule.setDstnAirport(scheduleFlight.getSchedule().getDstnAirport());
		updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
		sfrepo.save(updateScheduleFlight);
		return scheduleFlight;
	}

	@Override
	public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = sfrepo.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			
			sfrepo.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is not found";
	}

	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights() {
		// TODO Auto-generated method stub
		return sfrepo.findAll();
	}

	@Override
	public ScheduledFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundExceptions {
		if (flightId == null)
			throw new ScheduledFlightNotFoundExceptions("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = sfrepo.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundExceptions("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}

}
