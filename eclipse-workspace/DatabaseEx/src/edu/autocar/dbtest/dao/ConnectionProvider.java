package edu.autocar.dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static Connection conn;
	
	static {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = (Connection) DriverManager.getConnection(
												url, "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static Connection  getConnection() {
		return conn;
	}

	
	public static void close() {
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
