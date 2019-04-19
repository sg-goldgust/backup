package chapter08;

public class Car {
	private Tire[] tires;
	
	// 생성자 
	public Car(Tire[] tires) {
		this.tires = tires;
	}

	void run() {
		for (Tire tire : tires) {
			tire.roll();
		}
	}
	
	public void setTire(int ix, Tire tire) {
		tires[ix] = tire;
	}

}
