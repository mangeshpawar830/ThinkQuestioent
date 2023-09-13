package com.tqbank.dao;

import java.sql.SQLException;
import java.util.List;

import com.tqbank.pojo.User;

public interface UserDAO {
	
	boolean registration(User r) throws SQLException;
    boolean login(String uname,String upass,String role)throws SQLException;
    boolean updateUser(User u)throws SQLException;
    boolean deleteUser(int user_id)throws SQLException;
    List<User> showAllUsers();
    List<User> showAllUsers(String role);
    User showUserByEmail(String email);
    User showUserById(int userid);

	 

}
