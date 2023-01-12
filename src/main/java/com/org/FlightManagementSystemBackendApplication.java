package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.org.model")
@ComponentScan("com.org.dao")
@ComponentScan("com.org.service")
@ComponentScan("com.org.controller")
public class FlightManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemBackendApplication.class, args);
	}

}
