package chapter05;

import util.UArray;

public class ArrayLengthExample {
	

	
	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 };
		UArray.print(scores);
		
		int total = UArray.sum(scores);
		System.out.println("총합 : " + total);

		double avg = (double) total / scores.length;
		System.out.println("평균 : " + avg);
	}

}
