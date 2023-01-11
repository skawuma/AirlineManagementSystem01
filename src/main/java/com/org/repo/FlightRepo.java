package com.org.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Flight;


@Repository
public interface FlightRepo extends JpaRepository<Flight,BigInteger>{

}
