package chapter05;

import util.UArray;

public class ArrayTest02 {

	public static void main(String[] args) {
		int[] arr;
		
		arr = UArray.randomArray(10, 100, 1);
		UArray.print(arr);
		
		// UArray.bubbleSort(arr, false);
		UArray.selectionSort(arr, true);
		UArray.print(arr);
		
	}
}











//System.out.printf("평균 : %.2f\n", UArray.mean(arr));
//System.out.printf("분산 : %.2f\n", UArray.dispersion(arr));
//System.out.printf("표준편차 : %.2f\n" , UArray.standard(arr));



