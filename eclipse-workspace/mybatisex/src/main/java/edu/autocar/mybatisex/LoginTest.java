package edu.autocar.mybatisex;

import edu.autocar.base.sec.SHA256Util;
import edu.autocar.base.util.Input;
import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.domain.Member;

public class LoginTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		
		String userId = Input.getString("사용자id : ");
		String password = Input.getString("비밀번호 : ");
		
		try {
			Member m = dao.selectOne(userId);
			if(m == null ) {
				System.out.println("id가 존재하지 않습니다/");
				return;
			}
			String salt = m.getSalt();
			String encPassword = SHA256Util.getEncrypt(password, salt);
			if(encPassword.contentEquals(m.getPassword())) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
