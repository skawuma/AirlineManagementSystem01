package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.entity.Users;

public interface UsersService {
	
	public ResponseEntity<?> createUser(Users newUser);
	
	public Users updateUser(Users newUser);
	
	public String deleteUser(BigInteger userId);
	
	public Iterable<Users> displayAllUsers();
	
	public ResponseEntity<?>  findUserById(BigInteger userId);
	
	public ResponseEntity<?>  findUserByEmail(String userEamil);
	
	public ResponseEntity<?>  findUserByPhone(BigInteger userPhone);
	
	public ResponseEntity<?>  findByUsername(String userName);
	public void initRoleAndUser();

}
