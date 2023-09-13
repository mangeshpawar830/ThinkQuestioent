package com.kb.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.kb.Dao.AccountImpl;
import com.kb.Dao.LoginImopl;
import com.kb.Dao.account;
import com.kb.Dao.login;
import com.kb.pojo.User;

public class User_test {
	
	
	public void showUserMenu() throws SQLException
	{
		login l=new LoginImopl();
		String role="user";
		boolean flag=false;
		int u_id;
		char ch;
		String u_name,email,pass;
		
		Scanner scan=new Scanner(System.in);
		User u;
		int choice;
		do {
			System.out.println("---------User----------");
			System.out.println("1. Add User");
			System.out.println("2. Update User");
			System.out.println("3. Delete user");
			System.out.println("4. Show all Users");
			System.out.println("5. Activate User");
			System.out.println("6. Deactivate User");
			System.out.println("7.Exit");
			System.out.println("--------Enter Your Choice----------");
			choice=scan.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter user id");
			     u_id=scan.nextInt();
				System.out.println("Enter user name");
				 u_name=scan.next();
				System.out.println("Enter user email");
				 email=scan.next();
				System.out.println("Enter password");
				 pass=scan.next();
				
				u=new User(u_id, u_name, email, pass,role);
				try {
					flag=l.addUser(u);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(flag==true) {
					System.out.println("User Added Successfully......");
				}
				else {
					System.out.println("User Not Added.........");
				}
				
				break;
				
			case 2:
				System.out.println("Enter user id");
				 u_id=scan.nextInt();
				System.out.println("Enter user name");
				 u_name=scan.next();
				System.out.println("Enter user email");
				 email=scan.next();
				System.out.println("Enter password");
				 pass=scan.next();
				
				u=new User(u_id, u_name, email, pass,role);
				try {
					flag=l.updateUser(u);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(flag==true) {
					System.out.println("User Updated Successfully......");
				}
				else {
					System.out.println("User Not Updated.........");
				}
				
				break;
				
		
			case 3:
	
			
				System.out.println("----------Delete User-----------");
				System.out.println("Enter User Id");
				u_id=scan.nextInt();
				
				flag=l.deleteUser(u_id);
				
				if(flag) {
					System.out.println("User Deleted Successfully.....");
				}
				else {
					System.out.println("User NOt Deleted......");
				}
				break;
				
			case 4:
				System.out.println("--------Show  Users----------");
				
				List<User> userList=l.showAllUsers();
				
				if(userList.isEmpty()) {
					System.out.println("Users List is Empty!!!!");
				}
				else {
					for(User u1:userList) {
						if(u1.getRole().equals("user"))
						{
						System.out.println(u1);
						}
					}
				}
				break;
			default:
				System.out.println("Wrong Choice Entered......");
			}
				
			System.out.println("Do You want to continue if yes the enter y");
			ch=scan.next().charAt(0);
		}while(ch=='y'|| ch=='Y');

	}
		
	

	
}
