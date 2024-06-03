package com.daystar.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daystar.security.Entity.SignInDetails;
import com.daystar.security.Repo.SignInDetialsRepo;

@Service   //logic to user to load from db
public class CustomUserDetials implements UserDetailsService{  
	
	@Autowired
	private SignInDetialsRepo signInDetials;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName = null;
		String password = null;
		List<GrantedAuthority> authorities = null;
		List<SignInDetails> details = signInDetials.findByEmailId(username);
		
		if(details.size()==0) {
			throw new UsernameNotFoundException("User Details not found for the user : " + username);
		}
		else {
			userName = details.get(0).getEmailId();
			password = details.get(0).getPassword();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(details.get(0).getRole()));
		}
		return new User(username, password,authorities);
	}

}
