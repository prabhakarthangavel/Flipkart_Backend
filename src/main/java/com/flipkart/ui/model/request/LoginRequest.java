package com.flipkart.ui.model.request;

public class LoginRequest {
	String email;
	String password;

	public String getName() {
		return email;
	}

	public void setName(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
