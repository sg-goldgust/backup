package exercise2;



public class BoombB extends Boomb {
	
	public BoombB(int x, int y) {
		super('B', x, y);
	}

	@Override
	void boomb(WarField field) {
		field.mark(x-1, y);
		field.mark(x-2, y);
		field.mark(x+1, y);
		field.mark(x+2, y);
		field.mark(x, y-1);
		field.mark(x, y-2);
		field.mark(x, y+1);
		field.mark(x, y+2);
		field.mark(x, y, type);		
	}
}
