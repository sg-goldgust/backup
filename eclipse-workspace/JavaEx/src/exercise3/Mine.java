package exercise3;

import java.util.Queue;

public class Mine implements Boombable {
	@Override
	public void boomb(WarField field, int x, int y) {
		field.mark(x-1, y-1);
		field.mark(x+1, y-1);
		
		field.mark(x-1, y+1);
		field.mark(x+1, y+1);		
		
		field.mark(x, y, 'M');

	}

}
