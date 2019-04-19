package util;

import java.util.Scanner;

public class UArray {
	public static int sum(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		for(int y=0; y<arr.length; y++) {
			print(arr[y]);
//			for (int x = 0; x < arr[y].length; x++) {
//				System.out.print(arr[y][x] + " "); 
//			}
//			System.out.println();
		}
	}
	
	
	public static int[] randomArray(int size, int range, int start) {
		int [] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*range) +start;
		}
		return arr;
	}
	
	
	public static void swap(int[] arr, int ix1, int ix2) {
		int t = arr[ix1];
		arr[ix1] = arr[ix2];
		arr[ix2] = t;
	}
	

	public static void reverse(int[] arr) {
		int middle = arr.length/2;		
		int end = arr.length-1;
		
		for(int i=0; i<middle;i++) {
			swap(arr, i, end-i);
		}
	}
	
	
	public static void bubbleSort(int[] arr, boolean asc) {
		for (int x = 0; x < arr.length-1; x++) {
			for (int i = 0; i < (arr.length-1-x); i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
			print(arr);
		}
		
		if(!asc) {	
			reverse(arr);
		}
	}
	
	
	
	public static int findMax(int arr[], int start, int end) {
		int maxIndex = start;
		int max = arr[maxIndex];
		
		for(int i=maxIndex+1; i<=end; i++) {
			if(arr[i] > max) {
				max =arr[i];
				maxIndex = i;
			}
		}		
		return maxIndex;
	}
	
	
	public static void selectionSort(int arr[], boolean asc) {
		
		for (int end = arr.length-1; end > 0; end--) {
			int mIx = UArray.findMax(arr, 0, end);
			swap(arr, mIx, end);
		}
		
		if(!asc) {	
			reverse(arr);
		}
		
	}
	
	public static int search(int arr[], int value) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int arr[], int value) {

		int li = 0;					// 왼쪽 범위 인덱스
		int ri = arr.length-1;		// 오른쪽 범위 인덱스
		while(li<ri) {
			int mi = (li+ri)/2;		// 중간 인덱스
			if( value == arr[mi]) {
				return mi;
			}
			
			if(value < arr[mi]) {	// 찾는 값이 중간 값보다 작으면
				ri = mi-1;			// 우측 범위 인덱스 조정 
			} else {				// 찾는 값이 중간 값보다 크면
				li = mi+1;			// 우측 범위 인덱스 조정 
			}
		}			
	
		return -1;	
	}
	
	public static double mean(int arr[]) {
		int total = sum(arr);
		return (double)total/arr.length;
	}
	
	public static double dispersion(int arr[]) {
		double total = 0;
		double meanValue = mean(arr);
		
		for (int i = 0; i < arr.length; i++) {
			total += Math.pow(arr[i]-meanValue, 2);
		}
		return (double)total/arr.length;
	}
	
	public static double standard(int arr[]) {
		return Math.sqrt(dispersion(arr));
	}
	
	
	public static int[] clone(int[] arr) {
		int [] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}	
	

	

}
