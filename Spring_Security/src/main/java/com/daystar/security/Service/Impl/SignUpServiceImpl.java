package com.daystar.security.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daystar.security.Entity.SignInDetails;
import com.daystar.security.Repo.SignInDetialsRepo;
import com.daystar.security.Service.UserService;
import com.daystar.security.model.SignUpModel;

@Service
public  class SignUpServiceImpl implements UserService{
	
	@Autowired
	private SignInDetialsRepo signInRepo;
	
	@Override
	public String saveSignUpDetialsInTable(SignUpModel signUpModel){
		
		SignInDetails signUpDetails = new SignInDetails();
		
		signUpDetails.setId(signUpModel.getId());
		signUpDetails.setEmailId(signUpModel.getEmailId());
		signUpDetails.setPassword(signUpModel.getPassword());
		signUpDetails.setEmailId("user");
		
		signInRepo.save(signUpDetails);
		return "Successfully Created";
		
	}
	
	

}
