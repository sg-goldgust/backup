package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.util.Input;

public class JDBCExample7 {
	
	public static void main(String[] args) {
		
		System.out.println("---- list");
		List<GoodsInfo> list = selectList();
		print(list);
		System.out.println();
		
		
		System.out.println("---- selectOne");
		//사용자 정보 입력
		String code = Input.getString("상품코드 :");
		GoodsInfo g =selectOne(code);
		g = getGoodInfo(g);
		
		update(g);
		System.out.println();
		
		list = selectList();
		print(list);
		
		//삭제 코드 입력
		code = Input.getString("삭제할 상품코드 :");
		update(g);
		System.out.println();
		
		
		ConnectionProvider.close();
		
	}
	
	
	// 상품 목록 얻기
	public static List<GoodsInfo> selectList(){
		List<GoodsInfo> list = new ArrayList<>();
		Connection conn = ConnectionProvider.getConnection();
		String sql = "Select * from GoodsInfo ";
		
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				GoodsInfo gi;
				gi = JDBCExample3.map(rs);
				list.add(gi);
			}
					
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}	
		return list;
	}
	
	// 지정한 상품코드로 GoodsInfo 얻기
	public static GoodsInfo selectOne(String code) {
		GoodsInfo gi = null;
		Connection conn = ConnectionProvider.getConnection();
		String sql = "Select * from GoodsInfo Where Code = '" + code + "'" ;
		
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
		){
			
			if(rs.next()) {
				gi = JDBCExample3.map(rs);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return gi;
	}
	
	// 사용자로부터 입력 받은 정보로 
	// 수정데이터를 가지는 GoodsInfo 리턴
	public static GoodsInfo getGoodInfo(GoodsInfo g) {
		
		String msg;
		String code = g.getCode();
		
		msg = String.format("상품명(%s) : ", g.getName());
		String name = Input.getString(msg);
		if(name.equals("")) name = g.getName();
		
		msg = String.format("가격(%d) : ",g.getPrice());
		int price;
		String priceStr = Input.getString(msg);
		if(priceStr.contentEquals("")) {
			price = g.getPrice();
		} else {
			price = Integer.parseInt(priceStr);
		}
		
		msg = String.format("제조사(%s) : ",g.getMaker());
		String maker = Input.getString(msg);
		if(maker.contentEquals("")) maker = g.getMaker();
		
		return new GoodsInfo(code,name,price,maker);
	}
	
	// 전달한 정보로 업데이트 하기
	public static int update(GoodsInfo g) {
		String sql = "update goodsinfo set " +
					" name = ?, price = ?, maker = ?" +
					" where code = ?";
		
		Connection conn = ConnectionProvider.getConnection();
		
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setString(3, g.getMaker());
			pstmt.setString(4, g.getCode());
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
			
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return -1;
				
	}
	
	public static void print(List<GoodsInfo> list) {
		for (GoodsInfo gi : list) {
			System.out.printf("%8s %s \t%12d %s%n",gi.getCode(),gi.getName(),gi.getPrice(),gi.getMaker());
		}
	}
	
	public static int delete(String code) {
	String sql = "delete from goodsinfo where code = '"+code+"'";
	Connection conn = ConnectionProvider.getConnection();
	
	try (
			Statement stmt = conn.createStatement();
	){
		
		int result = stmt.executeUpdate(sql);
		conn.commit();
		return result;
			
	} catch (SQLException se) {
		System.out.println(se.getMessage());
	}
	return -1;
	}

}
