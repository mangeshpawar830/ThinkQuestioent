package com.tqbank.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.tqbank.db.DBConnection;
import com.tqbank.pojo.Account;

public class AccountImpl implements AccountDAO{
	Connection con=DBConnection.getConnection();
	int flag=0;
	Scanner sc=new Scanner(System.in);
	String role="user";
	PreparedStatement ps;
	Statement st;
	ResultSet rs,rs1;
	Account a;
	String ans;
	ArrayList<Integer>al;
	int dep;
	double bal=0;
	String d_acc_no;
	

	@Override
	public int deposit(int acc_no, int amt) throws SQLException {
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from account");
		
		while(rs.next()) {
			int d_acc_no=rs.getInt(1);
			bal=rs.getFloat(3);
			if(acc_no==d_acc_no) {
				flag=1;
				bal=bal+amt;
				rs.updateDouble(3, bal);
				rs.updateRow();
				
			}
		}
		return flag;
	}

	@Override
	public int withdraw(int acc_no, int amt) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void view_balance(int acc_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void money_transfer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add_payee() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove_payee() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account showAccountDetails(String email) throws SQLException {
		ps=con.prepareStatement("select u.user_id,account_no,account_type,balance from account a join customer_details u on u.user_id=a.user_id where email=?");
		ps.setString(1, email);
		rs=ps.executeQuery();
		Account a=new Account();
		if(rs.next()) {
			a.setUser_id(rs.getInt(1));
			a.setAcc_no(rs.getInt(2));
			a.setAcc_type(rs.getString(3));
			a.setBalance(rs.getDouble(4));
			return a;
		}
		return null;
	}

	@Override
	public String getStatus(String email) throws SQLException {
		ps=con.prepareStatement("select status from account a join customer_details c on  a.User_id=c.User_id where Email=?");
		ps.setString(1, email);
		rs=ps.executeQuery();
		
		if(rs.next()) {
			return rs.getString(1);
		}
		return null;
	}

}
