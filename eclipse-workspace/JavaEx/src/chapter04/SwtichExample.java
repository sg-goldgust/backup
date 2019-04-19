package chapter04;

public class SwtichExample {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 1;
		switch (num) {
		case 1:
			System.out.println("1이 나왔습니다.");
		case 3:
		case 5:
			System.out.println("홀수가 나왔습니다.");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("짝수가 나왔습니다.");
			break;
		}				

	}

}
