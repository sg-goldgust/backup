package chapter04;

public class MatrixEx {
	public static void main(String[] args) {
		int m = 5;
		int n = 4;
		
		for(int y = 0; y < m; y++) {
			for(int x = 0; x < n; x++) {
				System.out.print("(" + x + "," + y + ")");
			}
			System.out.println();
		}
		
	}
}
