package chapter04;

public class PrintStarEx {

	public static void main(String[] args) {
		int a = 10;
		
		for(int t=1; t<=10; t++) {
			for(int i=1; i<=t; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int t=10; t>=1; t--) {
			for(int i=1; i<=t; i++) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}

}
