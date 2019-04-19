package exercise2;

public class BoombC extends Boomb {

	public BoombC(int x, int y) {
		super('C', x, y);
	}

	@Override
	void boomb(WarField field) {
		field.mark(x-1, y-1);
		field.mark(x+1, y-1);
		
		field.mark(x-1, y+1);
		field.mark(x+1, y+1);		
		
		field.mark(x, y, type);

	}

}
