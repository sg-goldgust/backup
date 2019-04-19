package chapter14;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class CalculatorEx {
	
	public static void main(String[] args) {
		BinaryOperator<Integer> operator;
		
		operator = (x,y)->Calculator.staticMethod(x, y);
		System.out.println("결과1: "+operator.apply(1, 2));
		
		operator = Calculator :: staticMethod;
		System.out.println("결과2: "+operator.apply(3, 4));
		
		Calculator obj = new Calculator();
		operator = obj :: instanceMethod;
		System.out.println(operator.apply(8, 9));
		
		Consumer<String> c = System.out :: println;
		c.accept("Hello World");
		
	}
}
