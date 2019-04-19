package lamda.practice;

public class array {
	
	public static void main(String[] args) {
		
		A instance1 = new A();
		A instance2 = new A(instance1);
		
		A instance3 = instance1 ; //얕은 복사
		
	}
	
	 class A{
		
		int a;
		
		
		A() {}
			
		A(A a) {
			this.a = a.a;
		}
	}

}
