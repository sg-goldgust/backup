package edu.autocar.iotmonitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.iotmonitor.database.ConnectionProvider;
import edu.autocar.iotmonitor.domain.Sensor;

public class SensorDaoImpl implements SensorDao {
	
static final String namespace = "edu.autocar.iotmonitor.dao.SensorDao.";
	
	SqlSession sqlSession;
	
	private static SensorDao dao = new SensorDaoImpl();
	
	private SensorDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}
	
	public static SensorDao getDao() {
		return dao;
	}

	public List<Sensor> selectlist() throws Exception {
		return sqlSession.selectList(namespace+"selectList");
	}

	public Sensor selectOne(Long sensorId) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", sensorId);
	}

	public int insert(Sensor t) throws Exception {
		return sqlSession.insert(namespace+"insert",t);
	}

	public int update(Sensor t) throws Exception {
		return sqlSession.update(namespace+"update",t);
	}

	public int delete(Long sensorId) throws Exception {
		return sqlSession.delete(namespace+"delete",sensorId);
	}

}
