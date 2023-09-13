package com.tqbank.dao;

import java.sql.SQLException;

import com.tqbank.pojo.Account;

public interface AccountDAO {
	
	int deposit(int acc_no, int amt)throws SQLException;
	int withdraw(int acc_no,int amt)throws SQLException;
	void view_balance(int acc_no)throws SQLException;
	void money_transfer()throws SQLException;
	void add_payee()throws SQLException;
	void remove_payee()throws SQLException;
	Account showAccountDetails(String email) throws SQLException;
	public String getStatus(String email) throws SQLException;

}
