package chapter05;

import java.util.Scanner;

import util.UArray;

public class ArrayTest04 {

	public static void main(String[] args) {
		System.out.println(args.length);
		
		int[] arr;
		
		arr = UArray.randomArray(10, 100, 1);
		UArray.selectionSort(arr, true);
		
		UArray.print(arr);
		System.out.print("숫자를 입력하세요: ");
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
				
		int ix = UArray.binarySearch(arr, value);
		if(ix!=-1) {
			System.out.println("인덱스 : " + ix);
		} else {
			System.out.println(value + "는 없습니다.");
		}
		

	}

}
