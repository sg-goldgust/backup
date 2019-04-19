package chapter04;

public class IfElse {

	public static void main(String[] args) {
		int num = 234;
		
		if(num%2 == 0 ) {
			System.out.println(num + "은 짝수입니다.");
		} else {
			System.out.println(num + "은 홀수입니다.");
		}


		if( (num%2 == 0) && (num%3==0) ) {
			System.out.println(num + "은 2, 3의 공배수입니다.");
		} else {
			System.out.println(num + "은 2, 3의 공배수가 아닙니다.");
		}
	
	
	
	}

}
