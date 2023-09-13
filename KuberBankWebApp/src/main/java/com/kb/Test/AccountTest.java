package com.kb.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.kb.Dao.AccountImpl;
import com.kb.Dao.LoginImopl;
import com.kb.Dao.account;
import com.kb.Dao.login;
import com.kb.pojo.User;

public class AccountTest {
	
	public void showAccountsMenu() throws SQLException
	{
		account a=new AccountImpl();
		String role="user";
		boolean flag=false;
		int u_id;
		char ch;
		String u_name,email,pass,acc;
		
		Scanner scan=new Scanner(System.in);
		User u;
		int choice;
		do {
			System.out.println("--------Users Account Details----------");
			System.out.println("1.Deposit ");
			System.out.println("2.withdraw");
			System.out.println("3.view balance");
			System.out.println("4.Add payee");
			System.out.println("5.Remove payee");
			System.out.println("6.Transfer amount ");
			System.out.println("7.Exit");
			System.out.println("--------Enter Your Choice----------");
			choice=scan.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the account no");
				 acc=scan.next();
				
				
				try {
					a.deposit(acc, choice);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				break;
				
			case 2:
				System.out.println("Enter the account no");
				 acc=scan.next();
				
				
				try {
					a.withdraw(acc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
		
			case 3:
				System.out.println("Enter the account no");
				 acc=scan.next();
				
				
				try {
					a.view_balance(acc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			
				
				break;
				
			case 4:
				a.add_payee();
				break;
				
			case 5:
				a.remove_payee();
				break;
			case 6:
				a.money_transfer();
				break;
			case 7:
				System.exit(0);
				
				
				break;
			default:
				System.out.println("Wrong Choice Entered......");
			}
				
			System.out.println("Do You want to continue if yes the enter y");
			ch=scan.next().charAt(0);
		}while(ch=='y'|| ch=='Y');


}
}
