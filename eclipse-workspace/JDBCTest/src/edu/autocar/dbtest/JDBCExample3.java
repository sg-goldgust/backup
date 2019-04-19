package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.util.Input;

public class JDBCExample3 {
	public static void main(String[] args) {
		
		
		List<GoodsInfo> list1 = new ArrayList<>();
		// string sql
		
		
		String name = Input.getString("상품명: ");
		String sql = "select code, name, price, maker from goodsinfo " +
					"where name like '%"+name+"%' " +
					"order by price";
		
		Connection conn = ConnectionProvider.getConnection();
		
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
		){
			List<GoodsInfo> list = new ArrayList<GoodsInfo>();
			while(rs.next()) {
				GoodsInfo gi;
				gi = map(rs);
				list.add(gi);
			}
			print(list);
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		ConnectionProvider.close();
	}
		
		
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		try (Connection conn = (Connection) DriverManager.getConnection(url, "autocar" , "1234");
//			Statement stmt = (Statement) conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//				)
//		{
//			System.out.println("상품코드");
//			System.out.println("-----------");
//			while(rs.next()) {
//				GoodsInfo gi;
//				
//					gi = map(rs);
//					list1.add(gi);
//				
//				
//			}
//			print(list1);
//			
//			
//		} catch (SQLException se) {
//			System.out.println(se.getMessage());
//		}
//	}
	
	public static GoodsInfo map(ResultSet rs) throws SQLException{
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");
		
		return new GoodsInfo(code, name, price, maker);
		
	}
	
	public static void print(List<GoodsInfo> list) {
		for (GoodsInfo gi : list) {
			System.out.printf("%8s %s \t%12d %s%n",gi.getCode(),gi.getName(),gi.getPrice(),gi.getMaker());
		}
	}

}
