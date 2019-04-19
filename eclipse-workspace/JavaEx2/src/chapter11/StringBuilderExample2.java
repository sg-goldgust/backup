package chapter11;

import java.util.Scanner;

public class StringBuilderExample2 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문장을 입력하세요.[종료는 END]");
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("END")) break;
			
			sb.append(line + "\n");
		}

		System.out.println("결과------------------");
		String result = sb.toString();		
		System.out.println(result);
		
	}

}
