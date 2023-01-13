package com.org.entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Users_tbr")
public class Users {
	
	private String userType;
	@Id
	private  BigInteger userId;
	private String userName;
	private String UserPassword;
	private BigInteger userPhone;
	private String userEmail;
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone,
			String userEmail) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		UserPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public BigInteger getUserId() {
		return userId;
	}


	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return UserPassword;
	}


	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}


	public BigInteger getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	@Override
	public String toString() {
		return "Users [userType=" + userType + ", userId=" + userId + ", userName=" + userName + ", UserPassword="
				+ UserPassword + ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}
	
	
	

}
