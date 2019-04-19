package edu.autocar.tourguide.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.TourGuide;

public class TourGuideDaoImpl implements TourGuideDao {
	
	static final String namespace = "edu.autocar.tourguide.dao.TourGuideDao.";
	
	SqlSession sqlSession;
	
	public TourGuideDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}

	@Override
	public List<TourGuide> selectlist() throws Exception {
		return sqlSession.selectList(namespace+"selectList");
	}

	@Override
	public TourGuide selectOne(String key) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", key);
	}
	
	@Override
	public TourGuide selectName(String key) throws Exception {
		return sqlSession.selectOne(namespace + "selectName", key);
	}
	
	@Override
	public List<String> showRegion() throws Exception {
		return sqlSession.selectList(namespace+"showRegion");
	}
	
	@Override
	public List<TourGuide> search(String city, String keyword) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		map.put("category", city);
		map.put("keyword", keyword);
		return sqlSession.selectList(namespace+"search" , map);
	}

	@Override
	public int insert(TourGuide t) throws Exception {
		return sqlSession.insert(namespace+"insert",t);
	}

	@Override
	public int update(TourGuide t) throws Exception {
		return sqlSession.update(namespace+"update",t);
	}

	@Override
	public int delete(String key) throws Exception {
		return sqlSession.delete(namespace+"delete",key);
	}

	@Override
	public int getCount() throws Exception {
		return sqlSession.selectOne(namespace+"getCount");
	}

	@Override
	public List<TourGuide> getPage(int start, int end) throws Exception {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace+"getPage",map);
	}

}
