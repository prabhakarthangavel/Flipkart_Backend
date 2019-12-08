package com.flipkart.shared.dto;

import java.io.Serializable;
import java.util.List;

public class AccountRegDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -919784361243595499L;
	public String password;
	public String username;
	public String status;
	public String confirm_password;
	public List<RoleDto> role;
	
	
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	public List<RoleDto> getRole() {
		return role;
	}
	public void setRole(List<RoleDto> role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
