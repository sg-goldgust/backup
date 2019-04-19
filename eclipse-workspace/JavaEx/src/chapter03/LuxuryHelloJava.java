package chapter03;

public class LuxuryHelloJava {

	public static void main(String args[]) {
		printCharacter('$', 50);
		System.out.println("Hello, Java");
		printCharacter('$', 50);
	}

	static void printCharacter(char ch, int num) {
		for (int cnt = 0; cnt < num; cnt++)
			System.out.print(ch);
		System.out.println();
	}

}
