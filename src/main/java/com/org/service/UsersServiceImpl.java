package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import com.org.entity.Role;
import com.org.entity.Users;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.repo.RoleRepo;
import com.org.repo.UserRepo;


@Service
public class UsersServiceImpl implements UsersService {

@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public ResponseEntity<?> createUser(Users newUser) {
		// TODO Auto-generated method stub
		Optional<Users> findUserById = userRepo.findById(newUser.getUserId());
		try {
			if (!findUserById.isPresent()) {
			newUser.setUserPassword(newUser.getPassword());
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
	public ResponseEntity<?> findByUsername(String userName) {
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

	public void initRoleAndUser(){
	Role adminRole = new Role();
	adminRole.setRoleName("Admin");
	adminRole.setRoleDescription("Admin role");
	roleRepo.save(adminRole);

	Role userRole = new Role();
	userRole.setRoleName("User");
	userRole.setRoleDescription("Default role for newly created record");
	roleRepo.save(userRole);




	Users adminUser = new Users();
    adminUser.setUserId(BigInteger.valueOf(1111));
	adminUser.setUserName("admin123"); 
	//adminUser.setUserPassword("admin@pass");
	adminUser.setUserPassword(getEncodedPassword("admin@pass"));
	adminUser.setUserEmail("admin@gmail.com");
	adminUser.setUserPhone(BigInteger.valueOf(99999));
	adminUser.setUserType("TopSecret");
	Set<Role> adminRoles = new HashSet<>();
	adminRoles.add(adminRole);
	adminUser.setRole(adminRoles);
	userRepo.save(adminUser);


	Users user = new Users();
    user.setUserId(BigInteger.valueOf(1010));
	user.setUserName("ska"); 
	//user.setUserPassword("ska@pass");
	 user.setUserPassword(getEncodedPassword("ska@pass"));
	user.setUserEmail("ska@gmail.com");
	user.setUserPhone(BigInteger.valueOf(989898));
	user.setUserType("Standard");
	Set<Role> userRoles = new HashSet<>();
	userRoles.add(userRole);
	user.setRole(userRoles);
	userRepo.save(user); 

	}
	public String getEncodedPassword( String password){
		return passwordEncoder.encode(password);

	}

	public Users registerNewUser(Users newuser)  {
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        newuser.setRole(userRoles);
        newuser.setUserPassword(getEncodedPassword(newuser.getUserPassword()));
        return userRepo.save(newuser);

    }




}
