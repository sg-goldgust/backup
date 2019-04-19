package edu.autocar.mybatisex;

import java.util.List;

import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class MemberDaoTest {
	
	public static void main(String[] args) {
		selectListTest();
		
	}
	
	public static void getCountTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			int count = dao.getCount();
			System.out.println("전체 행의 수"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getPageTest() {
		MemberDao dao = new MemberDaoImpl();
		try {
			List<Member> list = dao.getPage(1, 10);
			for (Member mb : list) {
				System.out.println(mb);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectListTest() {
		MemberDao dao = new MemberDaoImpl();
		try {
			int count = dao.getCount();
			List<Member> list = dao.selectlist();
			
			assert count == list.size() : "전체 행의 개수가 틀립니다."; //예외를 던진다 거짓이면
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectOneTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			Member m = dao.selectOne("sking");
			assert m!= null : "sking이 없습니다.";
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			Member m = Member.builder()
							.userId("hong")
							.password("1234")
							.name("홍길동")
							.phone("010-1111-1111")
							.email("hong@namver.com")
							.address("")
							.build();
			int result = dao.insert(m);
			assert result == 1 : "insert 실패";
			
			ConnectionProvider.getSqlSession().commit();
			System.out.println("insert 성공");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void updateTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			Member m = dao.selectOne("hong");
			m.setAddress("서울시 강남구");
			int result = dao.update(m);
			assert result == 1 : "update 실패";
			
			ConnectionProvider.getSqlSession().commit();
			System.out.println("update 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			int result = dao.delete("hong");
			assert result ==1 : "delete 실패";
			ConnectionProvider.getSqlSession().commit();
			System.out.println("delete 성공");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
