package com.org.controller;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.org.service.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import com.org.entity.JwtRequest;
import com.org.entity.RegisterRequest;
import com.org.entity.JwtResponse;
import com.org.entity.Role;

import com.org.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import com.org.entity.Users;
import com.org.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
@RestController
 @CrossOrigin
 //@RequiredArgsConstructor
//@RequestMapping("/jwt")
public class JwtController { 
    
    @Autowired
    private JwtUtil jwtUtil;
      
     @Autowired
   private  JwtService jwtService;

    @Autowired
    private  UserRepo userRepo;

    // private Users users;
    @Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

	// @PostMapping("/authenticate")
    // public String authenticateAndGetToken(@RequestBody JwtRequest authRequest) {
    //     Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
    //     if (authentication.isAuthenticated()) {
    //         return jwtUtil.generateToken(authRequest.getUserName());
    //     } else {
    //         throw new UsernameNotFoundException("invalid user request !");
    //     }
    // }

    public String getEncodedPassword( String password){
		return passwordEncoder.encode(password);

	}
    @PostMapping({"/signup"})
        public JwtResponse register(@RequestBody RegisterRequest request) throws Exception {
           
             
        //     Users user = new Users();

        //     user.setUserName(user.getUsername());
        //     user.setUserPassword(passwordEncoder.encode(user.getPassword())); 
        //     user.setUserPhone(user.getUserPhone());
        //     user.setUserEmail(user.getUserEmail());
        //     user.setRole(user.getRole());
        //     user.setUserType(user.getUserType());


        //   userRepo.save(user);
        //     authenticate(user.getUsername(), user.getPassword());

            // String userName = jwtRequest.getUserName();
            // String userPassword = jwtRequest.getUserPassword();
            // BigInteger userPhone = jwtRequest.getUserPhone();
            // String userEmail = jwtRequest.getUserEmail();
            Set<Role> role = new HashSet<>();
            var user =Users.builder()
            .userName(request.getUserName())
            .UserPassword (passwordEncoder.encode(request.getUserPassword()))
            .userPhone(request.getUserPhone())
            .userEmail(request.getUserEmail())
            .role(role)
            .build();
            userRepo.save(user);

            
         //UserDetails userDetails = jwtService.loadUserByUsername(user.getUserName());
            String newGeneratedToken = jwtUtil.generateToken1(user);
    
        return new JwtResponse(user, newGeneratedToken);
        }
 

        @PostMapping({"/authenticate"})
        public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
            String userName = jwtRequest.getUserName();
            String userPassword = jwtRequest.getUserPassword();
            authenticate(userName, userPassword);
    
            UserDetails userDetails = jwtService.loadUserByUsername(userName);
            String newGeneratedToken = jwtUtil.generateToken1(userDetails);
    
            Users user = userRepo.findByUserName(userName).get();
            return new JwtResponse(user, newGeneratedToken);
        }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    }
      

	

 
    
    
    

