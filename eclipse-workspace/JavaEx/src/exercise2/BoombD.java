package exercise2;

public class BoombD extends Boomb {

	public BoombD(int x, int y) {
		super('D', x, y);
	}

	@Override
	void boomb(WarField field) {
		field.mark(x-1, y-1);
		field.mark(x-2, y-2);
		
		field.mark(x+1, y-1);
		field.mark(x+2, y-2);
		
		field.mark(x-1, y+1);
		field.mark(x-2, y+2);
		
		field.mark(x+1, y+1);		
		field.mark(x+2, y+2);
		
		field.mark(x, y, type);
	}

}
