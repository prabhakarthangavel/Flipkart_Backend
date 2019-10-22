package com.flipkart.shared.dto;

import java.io.Serializable;

public class AccountRegDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -919784361243595499L;
	public String password;
	public String confirm_password;
	public String email;
	public String status;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
