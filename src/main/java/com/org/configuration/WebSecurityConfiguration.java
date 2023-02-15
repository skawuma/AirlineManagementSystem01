package com.org.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.org.service.JwtService;
import com.org.service.UsersService;
import com.org.service.UsersServiceImpl;
import com.org.entity.Users;

//import org.springframework.boot.actuate.autoconfigure.security.servlet.*;


@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
 public class WebSecurityConfiguration {
/** 
    // @Autowired
    // private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
**/
    @Autowired
    private JwtRequestFilter jwtRequestFilter;



   
    
@Bean

public UserDetailsService JwtService()
{

    return new JwtService();
}

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         
        authProvider.setUserDetailsService(JwtService());
        authProvider.setPasswordEncoder(passwordEncoder());
     
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @ConditionalOnClass
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


// @Bean
// public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
//      AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//      authenticationManagerBuilder
//            .userDetailsService(jwtService)
//            .passwordEncoder(passwordEncoder());
//      return authenticationManagerBuilder.build();
//  }



// @Bean
// public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UsersService usersService) 
//   throws Exception {
//     return http.getSharedObject(AuthenticationManagerBuilder.class)
//       .userDetailsService(jwtService)
//       .passwordEncoder(bCryptPasswordEncoder)
//       .and()
//       .build();
// }




@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 return  http
      .csrf()
      .disable()
      .authorizeHttpRequests()
      .requestMatchers("/jwt/authenticate","user/createUser/" )
      .permitAll() 
      .and()
      .authorizeHttpRequests().requestMatchers("/user/**")
      .authenticated()
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authenticationProvider(authenticationProvider())
      .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
.build();
}

     // httpSecurity.addFilterBefore(jwtRequestFilter ,UsernamePasswordAuthenticationFilter.class);
      // .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
      // .and()
      // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//           .requestMatchers("/, /login, /signup, /logout").permitAll()
   

  

   

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    //     authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
    // }



}
