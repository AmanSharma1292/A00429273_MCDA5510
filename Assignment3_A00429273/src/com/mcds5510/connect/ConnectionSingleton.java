package com.mcds5510.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {

	private static Connection connection;

	private ConnectionSingleton() {
	}

	public static Connection getConnection() throws Exception {
		connection = null;
		if (connection == null) {
			try {
				// Driver Registration
				Class.forName("com.mysql.cj.jdbc.Driver");
				// establishing connection
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sharma?"
						+ "user=a_sharma&password=A00429273" + "&useSSL=false"
						+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
		return connection;
	}
}
