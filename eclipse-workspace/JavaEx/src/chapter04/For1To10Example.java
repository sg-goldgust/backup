package chapter04;

public class For1To10Example {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 100) + 1;
		int evenSum= 0;	// 짝수의 합
		int oddSum=0;	// 홀수의 합
		int sum=0;
		
		for (int i = 1; i <= num; i++) {
			if(i%2 == 0) {
				evenSum += i;
			} else {
				oddSum +=i;
			}
			sum += i;
		}

		System.out.println("1 ~ " + num + "까지의 짝수의 합 : "
							+ evenSum);
		System.out.println("1 ~ " + num + "까지의 홀수의 합 : "
							+ oddSum);
		System.out.println("1 ~ " + num + "까지의 합 : "
				+ sum);

	}

}
