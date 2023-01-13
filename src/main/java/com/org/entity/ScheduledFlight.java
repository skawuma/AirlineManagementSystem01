package com.org.entity;

import java.math.BigInteger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name= "Scheduledflight_tbr")
public class ScheduledFlight {
	
    @Id
    @Column(name = "schedule_flight_id")
	private BigInteger scheduleFlightId;
	
    @OneToOne(fetch = FetchType.EAGER)
   @NotNull
	private  Flight flight;
    
    
    @Column(name = "available_seats")
    @NotNull
	private Integer availableSeats;
	
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
	private Schedule schedule;
	
	
	
	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ScheduledFlight(BigInteger scheduleFlightId, Flight flight, Integer availableSeats, Schedule schedule) {
		super();
		this.scheduleFlightId = scheduleFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}


	public BigInteger getScheduleFlightId() {
		return scheduleFlightId;
	}


	public void setScheduleFlightId(BigInteger scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	@Override
	public String toString() {
		return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", flight=" + flight + ", availableSeats="
				+ availableSeats + ", schedule=" + schedule + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((scheduleFlightId == null) ? 0 : scheduleFlightId.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		ScheduledFlight other = (ScheduledFlight) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (scheduleFlightId == null) {
			if (other.scheduleFlightId != null)
				return false;
		} else if (!scheduleFlightId.equals(other.scheduleFlightId))
			return false;
		return true;
	}
	
}
