package com.flipkart.ui.model.response;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	private String username;
	private RoleResponse role;
	
//	public JwtResponse(String jwttoken) {
//		this.jwttoken = jwttoken;
//	}
//	
//	public JwtResponse(username,jwttoken,role) {
//		this.username = username;
//		this.jwttoken = token;
//		this.role = role;
//	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RoleResponse getRole() {
		return role;
	}

	public void setRole(RoleResponse role) {
		this.role = role;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	
}
