package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class AccountRegEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571910653187043361L;
	
	@Id
	@GeneratedValue
	public int id=102;
	
	@Column(nullable=false)
	public String password;
	
	@Column(nullable=false)
	public String confirm_password;
	
	@Column(nullable=false)
	public String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
}
