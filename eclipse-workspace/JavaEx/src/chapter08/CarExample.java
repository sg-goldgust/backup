package chapter08;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car(new Tire[] {
				new HankookTire(),
				new HankookTire(),
				new KumhoTire(),
				new KumhoTire()
		});
		
		myCar.run();
		
		Car yourCar = new Car(new Tire[] {
				new KumhoTire(),
				new KumhoTire(),
				new KumhoTire(),
				new KumhoTire()
		});
		yourCar.run();
		
		// yourCar.tires[0] = new KumhoTire();
		yourCar.setTire(0, new HankookTire());
		
		Tire t = new HankookTire();
		yourCar.setTire(1, t);
		
		yourCar.setTire(2, new Tire() {
			@Override
			public void roll() {
				System.out.println("사제 타이어가 굴러갑니다.");
			}
		});
		
		System.out.println();
		yourCar.run();
		
		
	}

}
