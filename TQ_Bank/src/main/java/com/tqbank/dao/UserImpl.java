package com.tqbank.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tqbank.db.DBConnection;
import com.tqbank.pojo.User;

public class UserImpl implements UserDAO{
	
	Connection con=DBConnection.getConnection();
	int flag=0;
	String role="user";
	PreparedStatement ps;
	java.sql.Statement st;
	ResultSet rs;
	int result;
	User u;
	

	@Override
	public boolean registration(User r) throws SQLException {
		ps=con.prepareStatement("insert into Customer_details(user_id,name,email,phone_number,role,password)values(?,?,?,?,?,?)");
		ps.setInt(1, r.getUser_id());
		ps.setString(2, r.getName());
		ps.setString(3, r.getEmail());
		ps.setString(4, r.getPhoneNo());
		ps.setString(5, r.getRole());
		ps.setString(6, r.getPassword());
		result=ps.executeUpdate();
		
		if(result>0) {
			return true;
		}else {
		
		return false;
		}
	}


	@Override
	public boolean login(String uname, String upass,String role) throws SQLException {
		ps=con.prepareStatement("select email,password,role from Customer_details where email=? and password=? and role=?");
		ps.setString(1, uname);
		ps.setString(2, upass);
		ps.setString(3, role);
		rs=ps.executeQuery();
		while(rs.next()) {
			return true;
		}
		return false;
		
	}


	


	@Override
	public boolean updateUser(User u) throws SQLException {
		ps=con.prepareStatement("update Customer_details set name=?,email=?,phone_number=?,password=? where user_id=?");
		ps.setNString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPhoneNo());
		ps.setString(4, u.getPassword());
		ps.setInt(5, u.getUser_id());
		
		result=ps.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean deleteUser(int user_id) throws SQLException {
		ps=con.prepareStatement("delete from Customer_details where user_id=?");
		ps.setInt(1, user_id);
		result=ps.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}


	


	@Override
	public List<User> showAllUsers(String role) {
		List<User>list=new ArrayList<User>();
		
		try {
			ps=con.prepareStatement("select * from Customer_details where role=?");
			ps.setString(1, role);
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhoneNo(rs.getString(4));
				u.setRole(rs.getString(5));
				u.setPassword(rs.getString(6));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public User showUserByEmail(String email) {
		try {
			ps=con.prepareStatement("select * from Customer_details where email=?");
			ps.setString(1, email);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhoneNo(rs.getString(4));
				u.setRole(rs.getString(5));
				u.setPassword(rs.getString(6));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public User showUserById(int userid) {
		try {
			ps=con.prepareStatement("select * from Customer_details where user_id=?");
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhoneNo(rs.getString(4));
				u.setRole(rs.getString(5));
				u.setPassword(rs.getString(6));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<User> showAllUsers() {
		List<User> list=new ArrayList<User>();
		
		try {
			ps=con.prepareStatement("select * from Customer_details");
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhoneNo(rs.getString(4));
				u.setRole(rs.getString(5));
				u.setPassword(rs.getString(6));
				list.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}




	

}
