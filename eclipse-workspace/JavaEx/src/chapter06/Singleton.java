package chapter06;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}

	public int sum(int a, int b) {
		return a+b;
	}	
}
