package com.flipkart.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.flipkart.io.entity.AccountRegEntity;
import com.flipkart.io.entity.CustomUserDetails;
import com.flipkart.io.entity.UserRoles;
import com.flipkart.repo.AccReg;
import com.flipkart.utils.Utilities;
import com.flipkart.shared.dto.AccountRegDto;
import com.flipkart.shared.dto.ClothDto;
import com.flipkart.shared.dto.RoleDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private Utilities utils;
	
	@Autowired
	private AccReg repo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountRegEntity user = repo.findByusername(username);
		CustomUserDetails role = new CustomUserDetails(user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
//		System.out.println(user.getUsername()+role.getAuthorities());
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public AccountRegDto findUser(String username) {
		AccountRegEntity entity = repo.findByusername(username);
		AccountRegDto dto = new AccountRegDto();
		ModelMapper mapper = new ModelMapper();
		
		//This mapper is used to map this list of object into another list
		java.lang.reflect.Type targetListType = new TypeToken<List<RoleDto>>() {
		}.getType();
		List<RoleDto> roleDto = mapper.map(entity.getRoles(), targetListType);
		dto.setUsername(entity.getUsername());
		dto.setRole(roleDto);
		return dto;
	}

	public AccountRegDto save(AccountRegDto user) {
		AccountRegEntity newUser = new AccountRegEntity();
		AccountRegDto dtoValue = new AccountRegDto();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		if (user.getUsername() == null) {
			dtoValue.setStatus("Username is mandatory");
		} else if (repo.findByusername(user.getUsername()) != null) {
			dtoValue.setStatus("Username already used");
		} else if (user.getPassword() == null) {
			dtoValue.setStatus("Password is Mandatory");
		} else if (utils.checkString(user.getPassword()) == false) {
			dtoValue.setStatus(
					"Password should contain at least an uppercase and a lowercase character, a number and a special character");
		} else if (user.getPassword().equalsIgnoreCase(user.getConfirm_password()) == false) {
			dtoValue.setStatus("Password and Confirm Password are not matching");
		}else if (repo.save(newUser) != null) {
			dtoValue.setUsername(user.getUsername());
			dtoValue.setStatus("Success");
		}
		return dtoValue;
	}

}
