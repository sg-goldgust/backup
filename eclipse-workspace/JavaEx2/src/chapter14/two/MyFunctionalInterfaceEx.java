package chapter14.two;

import chapter14.two.MyFunctionalInterface;

public class MyFunctionalInterfaceEx {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = x -> System.out.println("x*5");
		fi.method(2);
		
		doSomething(x->System.out.println(x));
		
	}
	
	public static void doSomething(MyFunctionalInterface fi) {
		int a=10;
		
		fi.method(10);
	}
}
