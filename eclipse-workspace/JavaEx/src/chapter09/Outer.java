package chapter09;

public class Outer {
	int num;
	
	Inner inner = new Inner();
	
	class Inner {
		int num;
		public void test(int num) {
			this.num = num;
			Outer.this.num = num;
		}
	}
	
	public void test(int num) {
		inner.test(num);
	}

}
