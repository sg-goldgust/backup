package chapter05;

import util.UArray;

public class ArrayInArrayExample {

	public static void main(String[] args) {
		int[][] mathScores = new int[2][3];
		UArray.print(mathScores);
		System.out.println();
		
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		UArray.print(englishScores);
		System.out.println();
		

	}

}
