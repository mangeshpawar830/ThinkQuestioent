package com.tqbank.pojo;


public class Account {
	private int acc_no;
	private String acc_type;
	private double balance;
	private int user_id;
	private String status;
	
	public Account() {
		super();
	}

	public Account(int acc_no, String acc_type, double balance, int user_id, String status) {
		super();
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.balance = balance;
		this.user_id = user_id;
		this.status = status;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", acc_type=" + acc_type + ", balance=" + balance + ", user_id=" + user_id
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	

}
