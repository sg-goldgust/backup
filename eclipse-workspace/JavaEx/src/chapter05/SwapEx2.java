package chapter05;

public class SwapEx2 {

	public static void swap(int[] arr) {
		int t = arr[0];
		arr[0] = arr[1];
		arr[1] = t;
	}	
	
	public static void main(String[] args) {
		int []arr = {10, 20};
		
		System.out.println("[교환전]");
		System.out.println("arr[0]의 값 : " + arr[0]);
		System.out.println("arr[1]의 값 : " + arr[1]);
		System.out.println();
		
		swap(arr);
		
		System.out.println("[교환후]");
		System.out.println("arr[0]의 값 : " + arr[0]);
		System.out.println("arr[1]의 값 : " + arr[1]);

	}
}
