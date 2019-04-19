package exercise2;

public abstract class Boomb {
	protected char type;
	protected int x;
	protected int y;
	
	public Boomb(char type, int x, int y) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
	}
	
	abstract void boomb(WarField field);

}
