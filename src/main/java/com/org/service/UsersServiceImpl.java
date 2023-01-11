package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.entity.Users;

public class UsersServiceImpl implements UsersService {

	@Override
	public ResponseEntity<?> createUser(Users newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(BigInteger userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Users> displayAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findUserById(BigInteger userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findUserByEmail(String userEamil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findUserByPhone(BigInteger userPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
