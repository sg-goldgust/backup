package chapter03;

public class UltraSonicTest {
	public static double getDistance(int duration) {
		return 0.0175 * duration;
	}
	
	
	public static void main(String[] args) {
		int time = 200;
		
		double distance = getDistance(200);
		System.out.println(distance);
		
		distance = UltraSonicTest.getDistance(200);
		System.out.println(distance);

	}

}
