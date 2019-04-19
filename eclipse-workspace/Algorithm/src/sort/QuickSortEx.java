package sort;

import util.UArray;

public class QuickSortEx {
	
	static void swap(int[] a, int pl, int pr) {
		int temp = a[pl];
		a[pl] = a[pr];
		a[pr] = temp;
			
	}
	
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = a[(left+right) / 2];
		
		do {
			while(a[pl] < pivot) pl++;
			while(pivot < a[pr]) pr--;
			
			if(pl <= pr) {
				swap(a,pl++,pr--);
			}
		} while(pl <= pr);
		
		
		
		if(left < pr)
			quickSort(a,left,pr);
		if(pl<right)
			quickSort(a,pl,right);
	}
	
	public static void main(String[] args) {
		int[] a = {1,8,7,3,5,2,6,3,9};	
		quickSort(a,0,a.length-1);
		
		for(int x : a) {
			System.out.print(x+ " ");
		}
	}
	
	
	//권역으로 보여주는 것
	//페이지네이션
	//이름으로 하나 보여주는 것
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static int partition(int[]data, int left, int right) {
//		int pivot = data[left];
//		
//		while(left < right) {
//			while(data[left] <= pivot) left++;
//			while(data[right] > pivot) right--;
//			
//			if(left < right) {
//				UArray.swap(data, left, right);
//			}
//		}
//		
//		return 0;
//	}
//	
//	
//	public static void main(String[] args) {
//		int[] data = { 10, 4, 3, 5, 20, 9, 15, 32 , 25, 12};
//		UArray.print(data);
//		partition(data, 0, data.length-1);
//		UArray.print(data);
//
//	}

}
