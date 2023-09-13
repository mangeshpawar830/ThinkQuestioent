package com.kb.pojo;

public class User {
	
	private int user_id;
	private String username;
	private String email;
	private String password;
	private String role;
	private String status;
	
	public User(String username, String email, String password, String role, String status) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	public User(int user_id, String username, String email, String password, String role, String status) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(int user_id, String username, String email, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(int user_id, String username,String email, String password, String role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email=email;
		this.password = password;
		this.role = role;
	}
	public User(String username,String email, String password, String role) {
		super();
		//this.user_id = user_id;
		this.username = username;
		this.email=email;
		this.password = password;
		this.role = role;
	}
	public User() {
		super();
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return  user_id + " "+ username + " " + email + " " + password
				+ " " + role;
	}
	

}
