package chapter14.three;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
//		fi = new MyFunctionalInterface() {
//			
//			@Override
//			public int method(int x, int y) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
		
		fi = (a,b)-> {return a+b;};
		fi = (a,b)->a+b;
		
		fi=(a,b) -> sum(a,b);
	}
	
	public static int sum(int a, int b) {
		return a+b;
	}

}
