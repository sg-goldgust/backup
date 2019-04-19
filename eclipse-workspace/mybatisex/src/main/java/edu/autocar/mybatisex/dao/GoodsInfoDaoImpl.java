package edu.autocar.mybatisex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.GoodsInfo;
import edu.autocar.mybatisex.domain.Member;

public class GoodsInfoDaoImpl implements GoodsInfoDao {
	
	static final String namespace = "edu.autocar.mybatisex.dao.GoodsInfoDao.";
	
	
	SqlSession sqlSession;
	
	public GoodsInfoDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}

	@Override
	public int getCount() throws Exception {
		return sqlSession.selectOne(namespace+"getCount");
	}
	
	@Override
	public List<GoodsInfo> selectlist() throws Exception {
		return sqlSession.selectList(namespace+"selectList");
	}
	
	@Override
	public List<GoodsInfo> getPage(int start, int end) throws Exception {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace+"getPage",map);
		
	}
	

	@Override
	public GoodsInfo selectOne(String code) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", code);
	}
	
	@Override
	public int insert(GoodsInfo member) throws Exception {
		return sqlSession.insert(namespace+"insert",member);
	}
	
	@Override
	public int update(GoodsInfo member) throws Exception {
		return sqlSession.update(namespace+"update",member);
	}
	
	@Override
	public int delete(String code) throws Exception {
		return sqlSession.delete(namespace+"delete",code);
	}

}
