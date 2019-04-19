package chapter04;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in);	// Scanner 객체 생성 
		String inputString;

		do {
			System.out.print(">");
			inputString = scanner.nextLine();		// 키보드 입력 문자열 얻기
			System.out.println(inputString);
		} while (!inputString.equals("q"));		// 문자열 비교

		System.out.println();
		System.out.println("프로그램 종료");
	}

}
