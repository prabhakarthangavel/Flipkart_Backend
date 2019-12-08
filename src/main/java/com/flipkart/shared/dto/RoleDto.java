package com.flipkart.shared.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class RoleDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int role_id;
    private String role;
    
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
