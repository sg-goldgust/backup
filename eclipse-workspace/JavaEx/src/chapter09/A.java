package chapter09;

public class A {
	private int field1;

	void method1() {
		B b = new B();
		System.out.println(b.num);
	}

	static int field2;

	static void method2() {
		
	}

	private class B {	
		private int num = 10;
		void method() {		// 모든 멤버와 메서드에서 접근할 수 있다.
			field1 = 10;	// private 멤버 접근 가능	
			method1();

			field2 = 10;
			method2();
		}
	}
	
	static class C {
		void method() {		// 인스턴스 필드와 메서드는 접근할 수 없다.
			// field1 = 10;
			// method1();

			field2 = 10;
			method2();
		}
	}
}
