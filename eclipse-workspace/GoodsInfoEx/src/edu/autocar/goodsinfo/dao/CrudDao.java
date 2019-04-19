package edu.autocar.goodsinfo.dao;

import java.util.List;

public interface CrudDao<T, K> {
	
	List<T> selectlist() throws Exception;
	
	T selectOne(K k) throws Exception;
	
	int insert(T t) throws Exception;
	
	int update(T t) throws Exception;
	
	int delete(K k) throws Exception;

}
