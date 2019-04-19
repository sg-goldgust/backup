package exercise3;

public class TimeBoomb implements Boombable {

	@Override
	public void boomb(WarField field, int x, int y) {
		field.mark(x-1, y-1);
		field.mark(x-2, y-2);
		
		field.mark(x+1, y-1);
		field.mark(x+2, y-2);
		
		field.mark(x-1, y+1);
		field.mark(x-2, y+2);
		
		field.mark(x+1, y+1);		
		field.mark(x+2, y+2);
		
		field.mark(x, y, 'T');
	}

}
