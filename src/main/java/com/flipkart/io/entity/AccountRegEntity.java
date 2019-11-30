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
	public String username;
	
	@OneToMany(
	        mappedBy = "userENtity",
	        cascade = CascadeType.ALL)
	private List<UserRoles> roles;
	
	public AccountRegEntity(AccountRegEntity users) {
		this.id = users.getId();
		this.password = users.getPassword();
		this.username = users.getUsername();
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<UserRoles> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}
}
