package chapter04;

public class SpaceEx {

	public static void main(String[] args) {
		int point = 14;
		
		int y = point / 4;
		int x = point % 4;
		
		System.out.println("14 -> (" + y + "," + x + ")");

		
		x = 1;
		y = 3;
		
		point = y*4 + x ;
		
		System.out.println("(" + x + "," + y + ") ->" +  point);
		
				
		
	}

}
