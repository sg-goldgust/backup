package edu.autocar.goodsinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.database.ConnectionProvider;
import edu.autocar.goodsinfo.domain.GoodsInfo;



public class GoodsInfoDao implements CrudDao<GoodsInfo, String> {
	
	private Connection conn = ConnectionProvider.getConnection();

	@Override
	public List<GoodsInfo> selectlist() throws Exception {
		List<GoodsInfo> list = new ArrayList<>();
		String sql = "Select * from GoodsInfo ";
		
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				GoodsInfo gi;
				gi = map(rs);
				list.add(gi);
			}
		} 
		return list;
	}
	
	@Override
	public GoodsInfo selectOne(String k) throws Exception {
		GoodsInfo gi = null;
		String sql = "Select * from GoodsInfo Where Code = '" + k + "'" ;
		
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
		){
			
			if(rs.next()) {
				gi = map(rs);
			}
		} 
		
		return gi;
	}
	
	private GoodsInfo map(ResultSet rs) throws SQLException{
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");
		
		return new GoodsInfo(code, name, price, maker);
		
	}
	
	
	
	@Override
	public int insert(GoodsInfo t) throws Exception {
		
		String sql = "insert into goodsinfo (code, name, price, maker) " +
				"values(?,?,?,?) ";
				
				try (	
						PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
				pstmt.setString(1, t.getCode());
				pstmt.setString(2, t.getName());
				pstmt.setInt(3, t.getPrice());
				pstmt.setString(4, t.getMaker());
				
				int result = pstmt.executeUpdate();
				conn.commit();
				return result;
				} 
		
	}
	
	@Override
	public int update(GoodsInfo t) throws Exception {
		String sql = "update goodsinfo set " +
				" name = ?, price = ?, maker = ?" +
				" where code = ?";
	
	Connection conn = ConnectionProvider.getConnection();
	
	try (
			PreparedStatement pstmt = conn.prepareStatement(sql);
	){
		pstmt.setString(1, t.getName());
		pstmt.setInt(2, t.getPrice());
		pstmt.setString(3, t.getMaker());
		pstmt.setString(4, t.getCode());
		int result = pstmt.executeUpdate();
		conn.commit();
		return result;
		
	} 
	}
	
	@Override
	public int delete(String k) throws Exception {
		
		String sql = "delete from goodsinfo where code = '"+k+"'";
		
		try (
				Statement stmt = conn.createStatement();
		){
			
			int result = stmt.executeUpdate(sql);
			conn.commit();
			return result;
				
		}
	}
}

