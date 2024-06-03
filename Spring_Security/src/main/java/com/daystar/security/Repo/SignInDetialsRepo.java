package com.daystar.security.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daystar.security.Entity.SignInDetails;

@Repository
public interface SignInDetialsRepo extends JpaRepository<SignInDetails, Long>{
	
	List<SignInDetails> findByEmailId(String emailId);

}
