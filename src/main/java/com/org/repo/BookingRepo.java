package com.org.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Booking;

@Repository
public interface BookingRepo  extends JpaRepository<Booking, BigInteger>{

}
