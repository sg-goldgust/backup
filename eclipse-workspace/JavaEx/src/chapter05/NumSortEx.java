package chapter05;

import util.UArray;

public class NumSortEx {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("데이터를 입력하세요");
			System.exit(0);
		}
		
		int [] arr = new int[args.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		
		UArray.selectionSort(arr, true);
		UArray.print(arr);
			
	}

}
