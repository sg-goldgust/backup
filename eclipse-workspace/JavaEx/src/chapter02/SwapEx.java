package chapter02;

public class SwapEx {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println("[교환전]");
		System.out.println("a의 값 : " + a);
		System.out.println("b의 값 : " + b);
		System.out.println();
		
		int t = a;
		a = b;
		b = t;
		
		System.out.println("[교환후]");
		System.out.println("a의 값 : " + a);
		System.out.println("b의 값 : " + b);
	}

}
