package chapter06;

import java.util.Scanner;

public class CalculatorEx2 {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 :");
		int num = scanner.nextInt();
		
		myCalc.clear();
		for(int i=1; i<=num; i++) {
			myCalc.plus(i);
		}

		System.out.println(myCalc.result);
		
		myCalc.powerOff();
	}

}
