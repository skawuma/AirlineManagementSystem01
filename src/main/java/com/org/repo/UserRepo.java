package com.org.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Users;

@Repository
public interface  UserRepo extends JpaRepository<Users, BigInteger> {

}
