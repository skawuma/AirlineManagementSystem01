package com.org.entity;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Users_tbr")
public class Users implements UserDetails{
	
	private String userType;
	@Id
	private  BigInteger userId;
	@Column(name="userName")
	private String userName;
	private String UserPassword;
	private BigInteger userPhone;
	private String userEmail;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
	private  Set<Role> role;

public Users(){
	super();
}
	
	public Users(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone,
			String userEmail, Set<Role> role) {
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		UserPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.role = role;
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



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Users [userType=" + userType + ", userId=" + userId + ", userName=" + userName + ", UserPassword="
				+ UserPassword + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", role=" + role + "]";
	}


		
// private List<GrantedAuthority> getAuthorities(final Set<Role> roles) {
//         if (CollectionUtils.isEmpty(roles)) {
//             return Collections.emptyList();
//         }
//         return roles.stream().map(role ->
//                 new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
//     }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		if (CollectionUtils.isEmpty(role)) {
            return Collections.emptyList();
        }
        return role.stream().map(role ->
                new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return UserPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	} 
	
	
	
	
	
	
	

}
