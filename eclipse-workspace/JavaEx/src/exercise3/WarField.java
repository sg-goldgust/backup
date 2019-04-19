package exercise3;

public class WarField {
	private int[][] field;
	
	public WarField(int width, int height) {
		field = new int[height][width];
	}
	
	public int width() {
		return field[0].length;
	}
	
	public int height() {
		return field.length;
	}
	
	public void underAttack(Boombable b, int x, int y) {
		b.boomb(this, x, y);
	}
	
	// 영역 안 인지 검사
	public boolean isIn(int x, int y) {
		if( ((y >= 0) && (y < field.length)) && 
			((x >= 0) && (x < field[0].length))) {
			return true;
		}
		return false;
	}
	
	public void mark(int x, int y) {
		// if(field[y][x] == 0 && isIn(x, y) ) {
		if(isIn(x, y) && field[y][x] == 0) {
			field[y][x] = 1;
		}		
	}
	
	public void mark(int x, int y, int type) {
		if(isIn(x, y)) {
			field[y][x] = type;
		}
	}
	
	public void print() {
		for(int y =0; y<field.length; y++) {			
			for(int x=0; x<field[0].length; x++) {
				int value = field[y][x];
				if(value == 0 || value == 1 ) {
					System.out.print(value + " ");
				} else {
					System.out.print((char)value + " ");
				}
			}
			System.out.println();
		}
	}

	public int getSafeZoneCount() {
		int count = 0;
		for(int y =0; y<field.length; y++) {			
			for(int x=0; x<field[0].length; x++) {
				if(field[y][x] == 0) count++;				
			}
		}
		return count;
	}
}
