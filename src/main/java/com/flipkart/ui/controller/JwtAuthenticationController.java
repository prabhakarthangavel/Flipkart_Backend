package com.flipkart.ui.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.flipkart.service.impl.JwtUserDetailsService;
import com.flipkart.shared.dto.AccountRegDto;
import com.flipkart.shared.dto.RoleDto;
import com.flipkart.config.JwtTokenUtil;
import com.flipkart.io.entity.AccountRegEntity;
import com.flipkart.io.entity.UserRoles;
import com.flipkart.ui.model.request.AccountRegRequest;
import com.flipkart.ui.model.request.JwtRequest;
import com.flipkart.ui.model.response.AccountRegResponse;
import com.flipkart.ui.model.response.ClothResponse;
import com.flipkart.ui.model.response.JwtResponse;
import com.flipkart.ui.model.response.UserRole;
import com.flipkart.repo.UserRolesRepo;
@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private UserRolesRepo rolesRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("userDetails"+userDetails.getAuthorities()+userDetails.getAuthorities().size());
		final String token = jwtTokenUtil.generateToken(userDetails);
		AccountRegDto dto = userDetailsService.findUser(userDetails.getUsername());
		ModelMapper mapper = new ModelMapper();
		AccountRegResponse response = mapper.map(dto, AccountRegResponse.class);
		response.setJwttoken(token);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AccountRegResponse> saveUser(@RequestBody AccountRegRequest user) throws Exception {
		AccountRegDto dto = new AccountRegDto();
		BeanUtils.copyProperties(user, dto);
		AccountRegDto returnDto = userDetailsService.save(dto);
		AccountRegResponse response = new AccountRegResponse();
		BeanUtils.copyProperties(returnDto,response);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user")
	public ResponseEntity<AccountRegResponse> getUser(){
		AccountRegDto returnDto = userDetailsService.findUser("prabhas3");
		AccountRegResponse response = new AccountRegResponse();
		//This mapper is used to map this list of object into another list
		ModelMapper mapper = new ModelMapper();
		java.lang.reflect.Type targetListType = new TypeToken<List<UserRole>>() {
		}.getType();
		List<UserRole> roleResponse = mapper.map(returnDto.getRole(), targetListType);
		response.setUsername(returnDto.getUsername());
		response.setRole(roleResponse);
		return ResponseEntity.ok(response);
	}
	
//	@GetMapping(value = "/user")
	public boolean update() {

		AccountRegEntity users = new AccountRegEntity();
		UserRoles roles = new UserRoles();
		roles.setRole("users");

		users.setUsername("prabhas3");
		users.setPassword("password");

		roles.setUserENtity(users);
		// persist
		if (rolesRepo.save(roles) != null) {
			return true;
		}
		return false;
		// getall
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
