package com.org.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.org.entity.Users;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.service.UsersService;


   @ComponentScan
   @RestController
   @CrossOrigin
   @RequestMapping("/user")
public class UsersController {
	
	@Autowired
	UsersService userService;

	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addUser(@RequestBody Users newUser) {

		userService.createUser(newUser);
	}

	@PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();  
    }

	@GetMapping("/readAllUsers")
   @PreAuthorize("hasRole('Admin')")
	public Iterable<Users> readAllUsers() {

		return userService.displayAllUsers();
	}

	@PutMapping("/updateUser")
	
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateUser(@RequestBody Users updateUser) {

		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {

		return userService.findUserById(userId);
	}
    @GetMapping("/getUser/{userName}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findUserByUsername(@PathVariable("userName") String userName) {

		return userService.findByUsername(userName);
    }


	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
	}
    @GetMapping({"/forAdmin"})
	public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

	@GetMapping({"/forUser"})
	public String forUser(){
        return "This URL is only accessible to the user";
    }

}
   