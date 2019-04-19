package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import edu.autocar.base.util.Resource;

public class ConnectionProvider {
	
	private static Connection conn;
	
	static {
		try {
			Properties props = Resource.getProperties("/database.properties");
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void close() {
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
