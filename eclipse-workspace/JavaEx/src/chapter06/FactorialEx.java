package chapter06;

public class FactorialEx {

	public static int factorial(int n) {
		if(n==1) return 1;

		return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		int result = factorial(n);
		System.out.println(result);

	}

}
