package edu.autocar.contact;

import edu.autocar.contact.model.Contact;
import edu.autocar.contact.util.DoubleLinkedList;
import edu.autocar.contact.util.Input;

public class ContactEX {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.add(new Contact("홍길동", "hong@naver.com", "010-1111-1111", "서울시 강남구"));
		list.add(new Contact("고길동", "go@naver.com", "010-1111-2222", "서울시 마포구"));
		list.add(new Contact("둘리", "dooly@naver.com", "010-1111-3333", "경기도 안양시"));
		list.add(new Contact("마이콜", "micol@naver.com", "010-1111-4444", "경기도 수원시"));
		list.add(new Contact("도우너", "do@naver.com", "010-1111-5555", "서울시 강남구"));

		Contact c = find(list);
		if(c!=null) {	// 목록에 데이터가 있으면 
			// 세부 내용 출력
			System.out.println("이름 : " + c.getName());
			System.out.println("email: " + c.getEmail());
			System.out.println("전화번호 : " + c.getPhone());
			System.out.println("주소 : " + c.getAddress());
		} else {
			System.out.println("존재하지 않습니다.");
		}
	}

	public static Contact find(DoubleLinkedList list) {
		String name = Input.getString("이름 : ");
		for(int i=0; i<list.getSize(); i++) {
			Contact c = list.get(i);
			if(name.equals(c.getName())) {
				return c;
			}
		}
		// 목록에 해당 이름이 없으면 null 리턴
		return null;	
	}
	
	
}
