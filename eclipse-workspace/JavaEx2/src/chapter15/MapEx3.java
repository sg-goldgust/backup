package chapter15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.autocar.base.util.Input;

public class MapEx3 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		
		int i = 0;
		for(; i<3; i++) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			String id = Input.getString("아이디:");
			String password = Input.getString("비밀번호:");
			System.out.println();
			
			try {
				checkLogin(map, id, password);
				System.out.println("로그인 되었습니다.");
				break;
			} catch (LoginFailException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(i==3) {
			System.out.println("3회 연속으로 실패했습니다.");
			System.out.println("처음부터 다시하세요.");
		}
	}
	
	public static void checkLogin(Map<String, String> map, 
								String id, String password) 
						throws LoginFailException {
		if(!map.containsKey(id)) {
			throw new LoginFailException("입력하신 아이디가 존재하지 않습니다");
		}
			
		if(!map.get(id).equals(password)) {
			throw new LoginFailException("비밀번호가 일치하지 않습니다.");
		}
	}

}
