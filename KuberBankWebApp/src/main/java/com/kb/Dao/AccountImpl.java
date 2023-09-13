package com.kb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kb.Utility.DBConnection;
import com.kb.pojo.*;

public class AccountImpl  implements account {
	Connection con=DBConnection.getConnection();;
	int flag=0;
	Scanner sc=new Scanner(System.in);
	String role="user";
	PreparedStatement ps;
	Statement st;
	ResultSet rs,rs1;
	account a;
	String ans;
	ArrayList<Integer> al;
	int dep;
	int bal=0;
	String d_acc_no;
	@Override
	public int deposit(String acc_no,int amt) throws SQLException {
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from account");
		
		while(rs.next())
		{
			String d_acc_no=rs.getString(1);
			bal=rs.getInt(3);
			if(acc_no.equals(d_acc_no))
			{
				flag=1;
				//System.out.println("valid account number");
				//System.out.println("Enter the amount you want to deposit");
				//dep=sc.nextInt();
				bal=bal+amt;
				rs.updateInt(3, bal);
				rs.updateRow();
			
			}
		}
		return flag;
	}

	@Override
	public void withdraw(String acc_no) throws SQLException {

		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from account");
		int with;
		int bal=0;
		while(rs.next())
		{
			String d_acc_no=rs.getString(1);
			bal=rs.getInt(3);
			if(acc_no.equals(d_acc_no))
			{
				flag=1;
				System.out.println("valid account number");
				System.out.println("Enter the amount you want to withdraw");
				with=sc.nextInt();
				with=bal-with;
				rs.updateInt(3, with);
				rs.updateRow();
			
			}
		}
		if(flag==1)
		{
			
			
		}else
			System.out.println("Invalid account number");
		
		
	}

	@Override
	public void view_balance(String acc_no) throws SQLException {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from account");
		
		while(rs.next())
		{
			String d_acc_no=rs.getString(1);
			bal=rs.getInt(3);
			if(acc_no.equals(d_acc_no))
			{
				flag=1;
				System.out.println("Account_name="+rs.getString(2));
				System.out.println("Balance="+rs.getInt(3));
				System.out.println("User_id="+rs.getInt(6));
			
			}
		}
		if(flag==1)
		{
			
			
		}else
			System.out.println("Invalid account number");
		
		
		
	}

	@Override
	public void money_transfer() throws SQLException {
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from account");
		ResultSet rs1=st1.executeQuery("select * from account");
		
		System.out.println("Enter user account no");
		Scanner sc=new Scanner(System.in);
		String uacc_no=sc.next();
		int u_bal=0,p_bal=0,p_bal1=0;
		/*while(rs.next())
		{
			String d_acc_no=rs.getString(1);
			 u_bal=rs.getInt(3);
			if(uacc_no.equals(d_acc_no))
			{
		 
		System.out.println("Enter the payee id whom u want to transfer");
		int id=sc.nextInt();
		
		Iterator<Integer> it= al.iterator();
		while(it.hasNext())
		{
			Integer p_id=it.next();
			int balance,depos;
			if(p_id==id)
			{
				flag=1;
				break;
			}
		}
			}
		}*/
		System.out.println("Enter the payee id whom u want to transfer");
		int id=sc.nextInt();
		System.out.println("Enter the account no  of payee");
		String acc_no=sc.next();
		
				while(rs.next())
				{
					
							
				
					String p_acc_id=rs.getString(1);
					if(acc_no.equals(p_acc_id))
					{
						p_bal=rs.getInt(3);
						System.out.println("Enter the amount to transfer");
						dep=sc.nextInt();
					    p_bal1=p_bal+dep;
					    rs.updateInt(3, p_bal1);
					    rs.updateRow();
						System.out.println(p_bal1+" get credited to account");
						
					}
				}
				while(rs1.next())
				{
					String d_acc_no=rs1.getString(1);
				int bal1=	rs1.getInt(3);
					if(uacc_no.equals(d_acc_no))
					{
					int rem=bal1-dep;
						rs1.updateInt(3, rem);
					    rs1.updateRow();
					    System.out.println(rem+" get debited from account");
					}
				}
		
			
		
		}
		
	
			
		
	

	@Override
	public void add_payee() throws SQLException {
		al=new ArrayList<Integer>();
		do
		{
		 st=con.createStatement();
		 rs=st.executeQuery("select * from user_details");
		int dep;
		int bal=0;
	
		 
		 
			 
			Scanner sc=new Scanner (System.in);
			System.out.println("Enter the user id you want to add as payee");
			int id=sc.nextInt();
			int flag1=0;
		while(rs.next())
		{
			
			String status=rs.getString(6);
			int user_id=rs.getInt(1);
			
		
		    if(status.equals("activate") && user_id==id )
		    {
		 al.add(id);
		 
		 flag1=1;
		 
		 
		    }
		
		
		}
		if(flag1==1)
		{
			System.out.println("Payee add successfully");
		}
		else
		{
			System.out.println("You cannot add payee");
		}
		System.out.println("Do you want to add more payees");
		ans=sc.next();
		}while(ans.equals("yes"));
		 
		 System.out.println(al);
	
		 
		
		
		
	}

	@Override
	public void remove_payee() throws SQLException {
	/*	System.out.println("Enter the payee id you want to remove");
		String name=sc.next();
	Iterator<String> it=	al.iterator();
	while(it.hasNext())
	{
		String s=it.next();
		
		if(s.equals(name))
		{
			it.remove();
			System.out.println("payee removed successfully");
		}
	}*/
		do
		{
	st=con.createStatement();
	 rs=st.executeQuery("select * from user_details");
	int dep;
	int bal=0;

	
	 
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the user id you want to remove");
		int id=sc.nextInt();
		int flag1=0;
	while(rs.next())
	{
		
		String status=rs.getString(6);
		Integer user_id=rs.getInt(1);
		
	
	    if(status.equals("activate") && user_id==id )
	    {
	al.remove(user_id);
	 
	 flag1=1;
	 
	 
	    }
	
	
	}
	if(flag1==1)
	{
		System.out.println("Payee remove successfully");
	}
	
	System.out.println("Do you want to  remove more payees");
	ans=sc.next();
	}while(ans.equals("yes"));
	 
	 System.out.println(al);

	
		
		
	}

	@Override
	public Account showAccountDetails(String email) throws SQLException {
		// TODO Auto-generated method stub

		try {
			String sql="select u.user_id,acc_no,acc_type,balance from user_details u join account a on u.user_id=a.user_id where email=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			Account a=new Account();
			if(rs.next()) {
				
				a.setUser_id(rs.getInt(1));
				a.setAcc_no(rs.getString(2));
				a.setAcc_name(rs.getString(3));
				a.setBalance(rs.getInt(4));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
