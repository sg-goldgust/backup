package edu.autocar.contact.model;

import edu.autocar.contact.util.Input;

public class ContactEx {

	public static void main(String[] args) {
		Contact contact = createContact();
		System.out.println(contact);		
	}

	public static Contact createContact() {
		System.out.println("주소록 정보를 입력하세요.");
		
		String name = Input.getString("이름:");
		String email = Input.getString("email:");
		String phone = Input.getString("전화번호:");
		String address = Input.getString("주소:");

		Contact contact = new Contact(name, email, phone, address);
		return contact;
	}
	
}
