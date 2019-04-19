package edu.autocar.base.sec;

import edu.autocar.base.util.Input;

public class EncEx1 {
	
	public static void main(String[] args) {
		String password = "123456";
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(password,salt);
		
		System.out.println("salt :"+salt);
		System.out.println("암호화된 비밀번호 "+encPassword);
		System.out.println(
				"암호화된 비밀번호 길이: "+encPassword.length());
		
		String userPassword = Input.getString("비밀번호 입력: ");
		
		String encPassword2 = SHA256Util.getEncrypt(userPassword, salt);
		if(encPassword.equals(encPassword2)) {
			System.out.println("비밀번호가 일치합니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}

}
