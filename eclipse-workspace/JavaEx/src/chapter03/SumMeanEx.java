package chapter03;

public class SumMeanEx {

	public static void main(String[] args) {
		int a = 21;
		int b = 30;
		
		// int sumValue = sum(a,b);
		System.out.println("합계 : " + sum(a,b));
		
		double meanValue = mean(a, b);
		System.out.println("평균 : " + meanValue);
	}
	
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static double mean(int a, int b) {
		// return (a+b)/2;
		return sum(a, b)/2.;
	}
	

}
