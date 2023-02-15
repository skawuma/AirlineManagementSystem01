package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
@ComponentScan
//@EnableAutoConfiguration
public class FlightManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemBackendApplication.class, args);
	}

	//Here I have disabled the csrf token that doesn't matter enable/disable according to your requirement.


	//  @Bean
    //  public WebMvcConfigurer corsConfigurer() {
    //      return new WebMvcConfigurer() {
    //         @Override
    //      public void addCorsMappings(CorsRegistry registry) {
    //              registry.addMapping("/**").allowedOrigins("*");
    //          }
    //      };
    //  }

}
