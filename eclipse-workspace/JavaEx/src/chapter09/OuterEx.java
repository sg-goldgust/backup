package chapter09;

public class OuterEx {

	public static void main(String[] args) {
		Outer o1 = new Outer();
		Outer o2 = new Outer();
		
		
		o1.test(100);
		o2.test(200);
		
		System.out.println(o1.num);
		System.out.println(o2.num);
		
		o1.inner.test(1000);
		o2.inner.test(2000);
		System.out.println(o1.num);
		System.out.println(o2.num);	
		
		Outer.Inner inner = o2.new Inner();
		inner.test(10000);
		
		System.out.println(o1.num);
		System.out.println(o2.num);	
	}
}
