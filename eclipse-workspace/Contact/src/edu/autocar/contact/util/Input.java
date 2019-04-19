package edu.autocar.contact.util;

import java.util.Scanner;

public class Input {
	
	public static String getString(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextLine();
	}	
}
