package com.flipkart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipkart.io.entity.AccountRegEntity;
import com.flipkart.io.entity.CustomUserDetails;
import com.flipkart.repo.AccReg;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	AccReg accRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<AccountRegEntity> optionalUsers = accRepo.findByemail(username);

	        optionalUsers
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	        return optionalUsers
	                .map(CustomUserDetails::new).get();
	}

}
