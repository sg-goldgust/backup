package chapter03;

public class UltraSonic {

	public static double getDistance(int duration) {
		return 0.017 * duration;
	}
	
	public static void main(String[] args) {
		int time = 150;
		
		double distance = getDistance(time);
		System.out.println(distance);

	}

}
