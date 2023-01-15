package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.org.entity.Users;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.repo.UserRepo;

public class UsersServiceImpl implements UsersService {


	UserRepo userRepo;
	@Override
	public ResponseEntity<?> createUser(Users newUser) {
		// TODO Auto-generated method stub
		Optional<Users> findUserById = userRepo.findById(newUser.getUserId());
		try {
			if (!findUserById.isPresent()) {
				userRepo.save(newUser);
				return new ResponseEntity<>(newUser, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"User with Id: " + newUser.getUserId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Users updateUser(Users updateUser) {
		// TODO Auto-generated method stub
		Optional<Users> findUserById = userRepo.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userRepo.save(updateUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + updateUser.getUserId() + " not exists!!");
		return updateUser;
	}

	@Override
	public String deleteUser(BigInteger UserId) {
		// TODO Auto-generated method stub
		Optional<Users> findBookingById = userRepo.findById(UserId);
		if (findBookingById.isPresent()) {
			userRepo.deleteById(UserId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<Users> displayAllUsers() {
		// TODO Auto-generated method stub
		return  userRepo.findAll();
		}

	@Override
	public ResponseEntity<?> findUserById(BigInteger userId) {
		// TODO Auto-generated method stub
		Optional<Users> findById = userRepo.findById(userId);
		try {
			if (findById.isPresent()) {
				Users findUser = findById.get();
				return new ResponseEntity<>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> findUserByEmail(String userEmail) {
		Optional<Users>findByEmail= userRepo.findByEmail(userEmail);
		try {
			if (findByEmail.isPresent()) {
				Users findUser = findByEmail.get();
				return new ResponseEntity<>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userEmail);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public ResponseEntity<?> findUserByPhone(BigInteger userPhone) {
		Optional<Users>findByPhone= userRepo.findByPhone(userPhone);
		try {
			if (findByPhone.isPresent()) {
				Users findUser = findByPhone.get();
				return new ResponseEntity<>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userPhone);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> findUserByUsername(String userName) {
		Optional<Users>findByUserName= userRepo.findByUserName(userName);
		try {
			if (findByUserName.isPresent()) {
				Users findUser = findByUserName.get();
				return new ResponseEntity<>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userName);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
