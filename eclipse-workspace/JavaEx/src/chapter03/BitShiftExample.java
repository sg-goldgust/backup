package chapter03;

public class BitShiftExample {
	public static void main(String[] args) {
		System.out.println("1 << 3 = " + (1 << 3));
		System.out.println("-8 >> 3 = " + (-8 >> 3));
		System.out.println("-8 >>> 3 = " + (-8 >>> 3));

		System.out.println(
				Binary.toBinaryString(1));
		System.out.println("<< 3");
		System.out.println(
				Binary.toBinaryString(1 << 3));
	}

}
