package chapter05;

import util.UArray;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] arr;		
		arr = UArray.randomArray(10, 100, 1);
		
		UArray.print(arr);
		
		int mIx = UArray.findMax(arr, 0, arr.length-1);
		System.out.println(mIx + " : " + arr[mIx]);

		
	}
}











//System.out.printf("평균 : %.2f\n", UArray.mean(arr));
//System.out.printf("분산 : %.2f\n", UArray.dispersion(arr));
//System.out.printf("표준편차 : %.2f\n" , UArray.standard(arr));


//for (int i = 0; i < arr.length-1; i++) {
//if(arr[i] > arr[i+1]) {
//	UArray.swap(arr, i, i+1);
//}
//}
