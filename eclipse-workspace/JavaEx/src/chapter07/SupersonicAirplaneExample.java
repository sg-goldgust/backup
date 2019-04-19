package chapter07;

public class SupersonicAirplaneExample {
	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();

		sa.setFlyMode(FlyMode.SUPERSONIC);
		sa.fly();

		sa.setFlyMode(FlyMode.NORMAL);
		sa.fly();

		sa.land();
	}

}
