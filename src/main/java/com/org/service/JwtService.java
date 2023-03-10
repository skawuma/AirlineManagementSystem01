package com.org.service;

import java. util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.org.entity.JwtRequest;
import com.org.entity.JwtResponse;
import com.org.repo.UserRepo;
import com.org.entity.Users;
import com.org.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;



@Service
public class JwtService implements UserDetailsService {

  

    @Autowired
    private UserRepo userRepo;

    // @Autowired
    // private JwtUtil jwtUtil;

//    @Autowired
//     private AuthenticationManager authenticationManager;

   
//     public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
//         String userName = jwtRequest.getUserName();
//         String userPassword = jwtRequest.getUserPassword();
//         authenticate(userName, userPassword);

//         UserDetails userDetails = loadUserByUsername(userName);
//         String newGeneratedToken = jwtUtil.generateToken1(userDetails);

//         Users user = userRepo.findByUserName(userName).get();
//         return new JwtResponse(user, newGeneratedToken);
//     }

//     private void authenticate(String userName, String userPassword) throws Exception {
//         try {
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//         } catch (DisabledException e) {
//             throw new Exception("USER_DISABLED", e);
//         } catch (BadCredentialsException e) {
//             throw new Exception("INVALID_CREDENTIALS", e);
//         }
//     }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    // private void authenticate(String userName, String userPassword) throws Exception {
    //     try {
    //         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    //     } catch (DisabledException e) {
    //         throw new Exception("USER_DISABLED", e);
    //     } catch (BadCredentialsException e) {
    //         throw new Exception("INVALID_CREDENTIALS", e);
    //     }
 


    // }


    // public JwtResponse authenticate(JwtRequest request) {
    //     authenticationManager.authenticate(
    //         new UsernamePasswordAuthenticationToken(
    //             request.getUserName(),
    //             request.getUserPassword()
    //         )
    //     );
    //     var user = userRepo.findByUserName(request.getUserName())
    //         .orElseThrow();
    //     var jwtToken = jwtUtil.generateToken(user);
    //     return JwtResponse.builder()
    //     .jwtToken(jwtToken)
    //     .build();
    //   }


}
