package com.flipkart.shared.dto;

import java.io.Serializable;

public class AccountRegDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -919784361243595499L;
	public String password;
	public String username;
	public String status;
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
