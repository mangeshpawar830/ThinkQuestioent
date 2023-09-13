package com.tqbank.pojo;

public class User {
	
	private int user_id;
	private String name;
	private String email;
	private String phoneNo;
	private String role;
	private String password;
	
	public User() {
		super();
	}

	public User(int user_id, String name, String email, String phoneNo,String role, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role=role;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", role="
				+ role + ", password=" + password + "]";
	}

	
	
	

}
