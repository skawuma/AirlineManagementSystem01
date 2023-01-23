package com.org.repo;

import java.math.BigInteger;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.org.entity.Users;

@Repository
public interface  UserRepo extends JpaRepository<Users, BigInteger> {
	
	@Query(value = "SELECT * FROM Users u WHERE u.userEmail=1", nativeQuery=true)
	public Optional <Users> findByEmail(String userEmail);
	
	@Query(value = "SELECT * FROM Users u WHERE u.userPhone=1", nativeQuery=true)
	public Optional <Users> findByPhone(BigInteger userPhone);
	
	
	@Query(value = "SELECT * FROM AirlinesSystem.Users_tbr where userName = ?1", nativeQuery=true)
	public Optional <Users> findByUserName(String userName);

	
	/**
	@Query(value = "SELECT e FROM Employee e ORDER  BY name")
public List <Users> findALLSortedByName();
	
	
	@Query(value = "Select * from Employee order by id", nativeQuery=true)
	public  List <Users> findAllSortedById();
**/
}
