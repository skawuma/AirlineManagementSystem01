package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Airport;


@Repository
public interface AirportRepo  extends JpaRepository<Airport,String>{

}
