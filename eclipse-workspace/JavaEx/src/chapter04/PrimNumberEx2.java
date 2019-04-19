package chapter04;

public class PrimNumberEx2 {
	public static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num %i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int count = 0;
		for(int num=2; num<=100; num++) {
			boolean result = isPrime(num);
			if(result) {	// 루프 중에 break 한 적이 없음
				count++;
				System.out.println(num);
			}
		}
		
		System.out.println("소수의총 개수는 " + count);
	}

}
