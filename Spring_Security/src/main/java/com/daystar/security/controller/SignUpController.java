package com.daystar.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.daystar.security.Service.UserService;
import com.daystar.security.model.SignUpModel;

public class SignUpController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String signUpDetails(@RequestBody SignUpModel signUpModel) {
		String hashPassword = passwordEncoder.encode(signUpModel.getPassword());
		signUpModel.setPassword(hashPassword);
		String message = userservice.saveSignUpDetialsInTable(signUpModel);
		return message;
		
	}

}
