package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (Exception e) {
			System.out.println("로드 실패" + e.getMessage());
		}
		
		try (Connection conn = (Connection) DriverManager.getConnection(url, "autocar", "1234");)
		{
			System.out.println("접속");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
	}

}
