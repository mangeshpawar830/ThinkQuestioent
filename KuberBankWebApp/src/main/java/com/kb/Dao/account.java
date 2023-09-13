package com.kb.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kb.pojo.Account;

public interface account {
	
	int deposit(String acc_no,int amt)throws SQLException;
	void withdraw(String acc_no)throws SQLException;
	void view_balance(String acc_no)throws SQLException;
	void money_transfer()throws SQLException;
	void add_payee()throws SQLException;
	void remove_payee()throws SQLException;
	Account showAccountDetails(String email)throws SQLException;

	

}
