package edu.autocar.mybatisex;

import java.util.List;

import edu.autocar.base.sec.SHA256Util;
import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class UpdatePasswordEx {
	
	public static void main(String[] args) {
		
		MemberDao dao = new MemberDaoImpl();
		
		try {
			List<Member> list = dao.selectlist();
			for(Member m : list) {
				String salt = SHA256Util.generateSalt();
				m.setSalt(salt);
				
				String encPassword = SHA256Util.getEncrypt(m.getPassword(), salt);
				m.setPassword(encPassword);
				
				dao.updatePassword(m);
			}
			ConnectionProvider.getSqlSession().commit();
			System.out.println("수정완료");
		} catch (Exception e) {
			ConnectionProvider.getSqlSession().rollback();
			e.printStackTrace();
		}
	}

}
