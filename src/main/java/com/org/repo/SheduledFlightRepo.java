package com.org.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.ScheduledFlight;

@Repository
public interface SheduledFlightRepo extends JpaRepository<ScheduledFlight, BigInteger> {

}
