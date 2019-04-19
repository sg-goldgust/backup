package exercise;

public class BombField {
	public static void main(String[] args) {
		int height = 7;	// 높이
		int width = 7;	// 폭
		int count = 3;	// 폭탄 투하 회수
		char[] boomTypes = { 'A', 'B', 'C' };
		
		int[][] fields = new int[height][width];
		
		for(int i=0; i<count; i++) {
			int position = (int)(Math.random()* (height*width-1));
			int py = position / width;
			int px = position % width;
			bomb(boomTypes[i], fields, py, px);
		}
		print(fields);
	}
	
	public static void bomb(char type, int [][]fields, int py, int px) {
		// 폭탄의 피해지역 표시						
		int range = type - 'A' + 1;	// 피해 범위 결정
		for(int i=1; i<=range; i++ ) {
			mark(fields, py, px-i);
			mark(fields, py, px+i);
			mark(fields, py-i, px);
			mark(fields, py+i, px);
		}
		// 폭탄의 타입 표시 
		fields[py][px] = type;		
	}	
	
	
	public static void mark(int [][]fields, int py, int px) {
		// 영역 안 인지 검사
		if( ((py >= 0) && (py < fields.length)) && 
			((px >= 0) && (px < fields[0].length))) {
			if(fields[py][px] ==0) { // 
				fields[py][px] = 1;
			}
		}
	}
	
	public static void print(int [][]arr) {
		for(int y =0; y<arr.length; y++) {			
			for(int x=0; x<arr[0].length; x++) {
				int value = arr[y][x];
				if(value == 0 || value == 1 ) {
					System.out.print(value + " ");
				} else {
					System.out.print((char)value + " ");
				}
			}
			System.out.println();
		}
	}

}
