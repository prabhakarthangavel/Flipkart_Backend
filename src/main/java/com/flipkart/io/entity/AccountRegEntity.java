package com.flipkart.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AccountRegEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571910653187043361L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public int user_id;

	@Column(name="password")
	public String password;

	@Column(name="username")
	public String username;

	@OneToMany(	 cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private List<UserRoles> roles;

	public AccountRegEntity(AccountRegEntity users) {
		this.user_id = users.getUser_id();
		this.password = users.getPassword();
		this.username = users.getUsername();
	}
	
	public AccountRegEntity() {}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
