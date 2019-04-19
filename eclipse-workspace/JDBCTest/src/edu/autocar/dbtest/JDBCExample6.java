package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample6 {
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Usage: java JDBCExample4 상품코드 상품명 가격 제조사");
			return;
			}
		
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String sql = "insert into goodsinfo (code, name, price, maker) " +
			"values(?,?,?,?) ";
			
			try (Connection conn = (Connection) DriverManager.getConnection(
					url, "autocar", "1234");		
					PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, args[0]);
			pstmt.setString(2, args[1]);
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, args[3]);
			
			int rowNum = pstmt.executeUpdate();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
	}

}
