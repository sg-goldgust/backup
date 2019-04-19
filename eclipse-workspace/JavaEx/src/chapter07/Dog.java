package chapter07;

public class Dog extends Animal {

	public Dog() {
		this.kind = "포유류";
	}

	@Override
	public void sound() {	// 추상 메서드 재정의
		System.out.println("멍멍");
	}



}
