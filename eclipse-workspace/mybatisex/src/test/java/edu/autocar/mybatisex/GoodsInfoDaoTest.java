package edu.autocar.mybatisex;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.autocar.mybatisex.dao.GoodsInfoDao;
import edu.autocar.mybatisex.dao.GoodsInfoDaoImpl;
import edu.autocar.mybatisex.domain.GoodsInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsInfoDaoTest {
	GoodsInfoDao dao = new GoodsInfoDaoImpl();
	
	@Test
	public void test1GetCountTest() throws Exception {
		int count = dao.getCount();
		assert count == 5 : "행의 개수가 다르다";
	}
	
	@Test
	public void test2GetPageTest() throws Exception {
		List<GoodsInfo> list = dao.getPage(1, 3);
		assert list.size() > 0 : "페이지 네이션 실패";
	}
	
	@Test
	public void test3Selectlist() throws Exception {
		int count = dao.getCount();
		List<GoodsInfo> list = dao.selectlist();
		assert list.size() == count : "전체목록얻기실패";
	}

}
