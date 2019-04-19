package chapter14;

import java.lang.annotation.Annotation;

public class MyFunctionalInterfaceEx {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = () -> {
			String str = "method call";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> {
			String str = "method call2";
			System.out.println(str);
		};
		fi.method();
		
		doSomething(new MyFunctionalInterface() {
			
			@Override
			public void method() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		fi = ()->{System.out.println("method call3");};
		fi.method();
		
		doSomething(() -> System.out.println("method call4"));
	}
	
	public static void doSomething(MyFunctionalInterface fi) {
		System.out.println("---------------------");
		fi.method();
		System.out.println("---------------------");
	}
	
	public static void doSomething2(Runnable r) {
		r.run();
	}
	

}
