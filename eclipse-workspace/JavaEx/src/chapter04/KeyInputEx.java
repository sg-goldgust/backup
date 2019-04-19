package chapter04;

import java.io.IOException;

public class KeyInputEx {

	public static void main(String[] args) throws IOException {
		
		System.out.print("입력:");
		int ch = System.in.read();
		System.out.println(ch);
		System.out.println((char)ch);
		
		ch = System.in.read();
		System.out.println(ch);
		System.out.println((char)ch);
		
		ch = System.in.read();
		System.out.println(ch);
		System.out.println((char)ch);
	
		ch = System.in.read();
		System.out.println(ch);
		System.out.println((char)ch);
		
		
	}

}
