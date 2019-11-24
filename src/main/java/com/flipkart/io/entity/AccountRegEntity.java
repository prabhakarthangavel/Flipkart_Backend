package com.flipkart.io.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class AccountRegEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571910653187043361L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int id;
	
	@Column(nullable=false)
	public String password;
	
	@Column(nullable=false)
	public String confirm_password;
	
	@Column(nullable=false)
	public String email;
	
	@OneToMany(
	        mappedBy = "userENtity",
	        cascade = CascadeType.ALL)
	private List<UserRoles> roles;
	
	public AccountRegEntity(AccountRegEntity users) {
		this.id = users.getId();
		this.password = users.getPassword();
		this.confirm_password = users.getConfirm_password();
		this.email = users.getEmail();
	}
	public AccountRegEntity() {
		
	}
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
	public List<UserRoles> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}
}
