package exercise3;

public class Boomb implements Boombable{

	@Override
	public void boomb(WarField field, int x, int y) {
		field.mark(x-1, y);
		field.mark(x+1, y);
		field.mark(x, y-1);
		field.mark(x, y+1);
		
		field.mark(x, y, 'B');		
	}
}
