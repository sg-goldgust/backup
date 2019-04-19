package chapter04;

public class PrimNumberEx {

	public static void main(String[] args) {
		int num = 323;
		boolean isPrime = true;
		
		int i;
		for(i=2; i<num; i++) {
			if(num %i == 0) {
				// isPrime = false;
				break;
			}
		}	
		
		if(i==num) {	// 루프 중에 break 한 적이 없음
			System.out.println("소수");
		} else {
			System.out.println("소수 아님");
		}
		
		// 판정		
		if(isPrime) {
			System.out.println(num + "은 소수 입니다.");
		} else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
	}

}
