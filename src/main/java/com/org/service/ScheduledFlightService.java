package com.org.service;

import java.math.BigInteger;

import com.org.entity.ScheduledFlight;

public interface ScheduledFlightService {
	
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);
	
	public   ScheduledFlight modifyScheduledFlight(ScheduledFlight sheduledFlight);
	
	public String removeScheduledFlight(BigInteger  id);

	public Iterable<ScheduledFlight> viewAllScheduledFlights();
	
	public ScheduledFlight viewScheduledFlight(BigInteger id);
}
