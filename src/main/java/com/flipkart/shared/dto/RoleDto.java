package com.flipkart.shared.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class RoleDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int id;
    private String role;
   
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
