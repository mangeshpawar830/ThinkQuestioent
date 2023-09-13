package com.tqbank.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection dbConnect;
	public static final String url="jdbc:mysql://localhost:3306/tq_bank?"+"autoReconnect=true&useSSL=false";
	public static final String user="root";
	public static final String password="1303";
		
		public static Connection getConnection() {
			
			
			try {
				String s="com.mysql.cj.jdbc.Driver";
				Class.forName(s);
				
				dbConnect=DriverManager.getConnection(url, user, password);
				System.out.println("connection established");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnect;
		
			
		
		}


}
