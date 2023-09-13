package com.kb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kb.Test.AccountTest;
import com.kb.Test.User_test;
import com.kb.Utility.DBConnection;
import com.kb.pojo.User;

public class LoginImopl implements login{

	
	Connection con=DBConnection.getConnection();;
	int flag=0;
	Scanner sc=new Scanner(System.in);
	String role="user";
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	int result;
	User u;
	
	
	public void check_user() throws SQLException  {
		String role="";
		int i=0;
		while(i<=2)
		{
		
		System.out.println("*****Enter user name  for login*********");
		
		String username=sc.next();
		
        System.out.println("*****Enter Email  for login*********");
		
		String email=sc.next();
		
		con=DBConnection.getConnection();
		st=con.createStatement();
		String sql="select * from user_details";
		 rs=st.executeQuery(sql);
		
		while(rs.next())
		{
		    String db_user= rs.getString(2);
		    String db_email=rs.getString(3);
		    if(db_user.equals(username) && db_email.equals(email))
		    {
		    	flag=1;
		    	 role=rs.getString(5);
		    	
		    	  
		    }
		  
		}
		
		
			 
			    	
		
		
		
		
		if(flag==1)
		{
			System.out.println("*** correct credentials");
			if(role.equals("admin"))
			{
				System.out.println("***** welcome admin****");
				User_test u=new User_test();
				u.showUserMenu();
			}
			else
				System.out.println("welcome user");
			AccountTest a=new AccountTest();
			a.showAccountsMenu();
			break;
			
		}
		else
			System.out.println("Incorrect pasword");
		
		
	
	
		i++;
		}
		
	

	
	if(i==2)
	{
		System.out.println("sorry you have attempt more than three times");

	}
	
	
	

}
	@Override
	public boolean addUser(User u) throws SQLException {
		
		System.out.println("inside user dao add user");
		String sql="insert into user_details (user_name,email,password,role)values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		//ps.setInt(1, u.getUser_id());
		ps.setString(1, u.getUsername());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPassword());
		ps.setString(4,u.getRole());
		System.out.println(ps);
		result=ps.executeUpdate();
		
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stubtry {
		try
		{
		String sql="update user_details set user_name=?, email=?,password=?,status=? where user_id=?";
				
		ps=con.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		ps.setString(4,u.getStatus());
		ps.setInt(5, u.getUser_id());
		System.out.println(ps);
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(result>0) {
		return true;
	}
	else {
		return false;
	}
		
	}
	@Override
	public boolean deleteUser(int user_id) {
		try
		{
		String sql="delete from user_details where user_id=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, user_id);
		
		result=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(result>0) {
		return true;
	}
	else {
		return false;		
	}
	}
	@Override
	public boolean activate() throws SQLException {
		String sql="select * from user_details";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			String s=rs.getString(5);
			if(s.equals("activate"))
				flag=1;
		}
		if(flag==1)
			return true;
		else
			return false;
	
		
	}
	@Override
	public  boolean deactivate() {
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> showAllUsers() {
		List<User> list=new ArrayList<User>();

		
		try {
			String sql="select * from user_details";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
			    u.setUsername(rs.getString(2));
			    u.setEmail(rs.getString(3));
			    u.setPassword(rs.getString(4));
			    u.setRole(rs.getString(5));
			    u.setStatus(rs.getString(6));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public boolean check_user(String uname, String upass,String role) throws SQLException {
		// TODO Auto-generated method stub
		try {
			String sql="select email,password,role from user_details where email=? and password=? and role=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, role);
			rs=ps.executeQuery();
			System.out.println(ps);
			if(rs.next()) {
				
				return true;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<User> showAllUsers(String role) {
		List<User> list=new ArrayList<User>();

		
		try {
			String sql="select * from user_details where role=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, role);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
			    u.setUsername(rs.getString(2));
			    u.setEmail(rs.getString(3));
			    u.setPassword(rs.getString(4));
			    u.setRole(rs.getString(5));
			    u.setStatus(rs.getString(6));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public User showUserByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			String sql="select * from user_details where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
			    u.setUsername(rs.getString(2));
			    u.setEmail(rs.getString(3));
			    u.setPassword(rs.getString(4));
			    u.setRole(rs.getString(5));
			    
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public User showUserById(int userid) {
		// TODO Auto-generated method stub
		try {
			String sql="select * from user_details where user_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
			    u.setUsername(rs.getString(2));
			    u.setEmail(rs.getString(3));
			    u.setPassword(rs.getString(4));
			    u.setRole(rs.getString(5));
			    u.setStatus(rs.getString(6));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getStatus(String email) {
		try {
			String sql="select status from user_details where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}


