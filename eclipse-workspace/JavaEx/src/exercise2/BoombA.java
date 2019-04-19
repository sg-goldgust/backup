package exercise2;

public class BoombA extends Boomb {

	public BoombA(int x, int y) {
		super('A', x, y);
	}

	@Override
	void boomb(WarField field) {
		field.mark(x-1, y);
		field.mark(x+1, y);
		field.mark(x, y-1);
		field.mark(x, y+1);
		
		field.mark(x, y, type);
	}
}
