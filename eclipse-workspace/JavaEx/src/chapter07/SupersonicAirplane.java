package chapter07;

public class SupersonicAirplane extends Airplane {
//	public static final int NORMAL = 1;
//	public static final int SUPERSONIC = 2;

	private FlyMode flyMode = FlyMode.NORMAL;

	public FlyMode getFlyMode() {
		return flyMode;
	}

	public void setFlyMode(FlyMode flyMode) {
		this.flyMode = flyMode;
	}

	@Override
	public void fly() {
		if (flyMode == FlyMode.SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		} else {
			// Airplane 객체의 fly() 메소드 호출
			super.fly();
		}
	}

}
