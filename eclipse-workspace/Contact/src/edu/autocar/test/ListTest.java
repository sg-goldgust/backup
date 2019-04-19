package edu.autocar.test;

import edu.autocar.contact.model.Contact;
import edu.autocar.contact.util.DoubleLinkedList;

public class ListTest {

	public static void main(String[] args) {
		Contact[] contacts = {
				new Contact("홍길동", "hong@naver.com", "010-1111-1111", "서울시 강남구" ),
				new Contact("고길동", "go@naver.com", "010-1111-2222", "서울시 서초구" ),
				new Contact("둘리", "dooli@naver.com", "010-1111-3333", "경기도 고양시" ),
		};
		
		DoubleLinkedList list = new DoubleLinkedList();
		
//		for(Contact c : contacts) {
//			list.add(c);
//		}

		list.add(contacts[0]);
		list.add(0, contacts[1]);
		list.add(1, contacts[2]);
		
		list.print();
		
		System.out.println();
		list.remove(2);
		list.print();
		
		System.out.println();
		
		
		list.add(contacts[2]);
		list.print();

	}

}
