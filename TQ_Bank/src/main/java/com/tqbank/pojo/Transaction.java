package com.tqbank.pojo;


public class Transaction {
	
	private String t_id;
	private String t_type;
	private int acc_no;
	private float amount;
	private String t_dateTime;
	
	public Transaction() {
		super();
	}

	public Transaction(String t_id, String t_type, int acc_no, float amount, String t_dateTime) {
		super();
		this.t_id = t_id;
		this.t_type = t_type;
		this.acc_no = acc_no;
		this.amount = amount;
		this.t_dateTime = t_dateTime;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_type() {
		return t_type;
	}

	public void setT_type(String t_type) {
		this.t_type = t_type;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getT_dateTime() {
		return t_dateTime;
	}

	public void setT_dateTime(String t_dateTime) {
		this.t_dateTime = t_dateTime;
	}

	@Override
	public String toString() {
		return "Transaction [t_id=" + t_id + ", t_type=" + t_type + ", acc_no=" + acc_no + ", amount=" + amount
				+ ", t_dateTime=" + t_dateTime + "]";
	}
	
	
	
	
	

}
