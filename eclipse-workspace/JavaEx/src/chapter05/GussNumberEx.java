package chapter05;

import java.util.Scanner;

public class GussNumberEx {

	public static void main(String[] args) {
		// 컴퓨터가 선정한 숫자
		int num = (int)(Math.random()*100) + 1;
		
		Scanner scanner = new Scanner(System.in);
		
		int i;
		for( i=0; i<5; i++) {
			System.out.print("입력 : ");
			int value = scanner.nextInt();
			if(value == num) {
				break;
			}			
			if(num > value) {
				System.out.println(value + " 보다는 큽니다. ");
			} else {
				System.out.println(value + " 보다는 작습니다. ");
			}
		}

		// 판정
		if(i==5) {
			System.out.println("틀렸습니다.");
			System.out.println("정답 : " + num);
		} else {
			System.out.println("맞았습니다.");
		}
 
		
		
	}

}
