package chapter06;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();
		
		System.out.println(myCalc);
		if(!myCalc.state) {
			myCalc.powerOn();
		}

		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		myCalc.plus(10);
		System.out.println(myCalc);
		myCalc.plus(20);
		System.out.println(myCalc);
		
		
		System.out.println("result: " + myCalc.result);
		
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);

		myCalc.powerOff();
	}

}
