package com.kb.Dao;

import java.sql.SQLException;
import java.util.List;

import com.kb.pojo.User;

public interface login {
   boolean check_user(String uname,String upass,String role)throws SQLException;
   boolean addUser(User u)throws SQLException;
   boolean updateUser(User u)throws SQLException;
   boolean deleteUser(int user_id)throws SQLException;
   List<User> showAllUsers();
   List<User> showAllUsers(String role);
   User showUserByEmail(String email);
   User showUserById(int userid);
   boolean activate()throws SQLException;
   boolean deactivate();
   
}
