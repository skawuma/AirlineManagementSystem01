package com.org.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {


    private String userName;
    private String UserPassword;
    private BigInteger userPhone;
	private String userEmail;
    
}
