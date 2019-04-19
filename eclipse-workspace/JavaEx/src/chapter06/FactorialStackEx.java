package chapter06;

public class FactorialStackEx {

	public static void main(String[] args) {
		int n = 10;
		IntStack stack = new IntStack();
		
		for(int i=n; i>=1; i--) {
			stack.push(i);
		}
		
		System.out.println(stack);
		
		// 팩토리얼 계산 		
		while(stack.getTop() > 0) {
			int a = stack.pop();
			int b = stack.pop();
			int r = a*b;
			stack.push(r);
		}
		
		// 결과 출력 
		System.out.println(n + "! : " + stack.pop());
	}

}
