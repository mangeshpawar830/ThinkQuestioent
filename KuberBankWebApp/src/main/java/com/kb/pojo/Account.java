package com.kb.pojo;

public class Account {
	private String acc_no;
	private String acc_name;
	private int balance;
	private String contact_name;
	private String address;
	private int user_id;
	public Account(String acc_no, String acc_name, int balance, String contact_name, String address, int user_id) {
		super();
		this.acc_no = acc_no;
		this.acc_name = acc_name;
		this.balance = balance;
		this.contact_name = contact_name;
		this.address = address;
		this.user_id = user_id;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return  acc_no + " " + acc_name + " " + balance + " "+ contact_name + " " + address +  " " + user_id ;
	}
	
}
