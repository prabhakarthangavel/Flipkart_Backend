package com.flipkart.ui.model.response;

import javax.persistence.Column;

public class UserRole {

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
