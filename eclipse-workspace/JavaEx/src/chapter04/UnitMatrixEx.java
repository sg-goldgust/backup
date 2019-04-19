package chapter04;

public class UnitMatrixEx {
	public static void main(String[] args) {
		int n = 5;
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
//				if(x==y) {
//					System.out.print("1 ");
//				} else {
//					System.out.print("0 ");
//				}
				
				String str = (x==y) ? "1 " : "0 ";
				System.out.print(str);
				
			}	
			System.out.println();
		}
		
	}
}
