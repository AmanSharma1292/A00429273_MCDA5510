package com.mcds5510.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	
	private static ConnectionSingleton connection = new ConnectionSingleton();
	
	private ConnectionSingleton() {
	}
//
//	public static Connection getConnection() throws Exception {
//		connection = null;
//		if (connection == null) {
//			try {
//				// Driver Registration
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				// establishing connection
//				System.out.println("Creating Connection");
//				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassignment2","root","1234");
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//
//			}
//		}
//		return connection;
//	}
	
	public static ConnectionSingleton getObject()
	{
		return connection;
	}
	public static Connection getConnection()
	{
		Connection myCon=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sharma?useSSL=false", "a_sharma", "A00429273");
			return myCon;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return myCon;
		
	}
	
}
