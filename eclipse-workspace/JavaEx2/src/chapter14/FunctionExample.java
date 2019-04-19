package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	 private static List<Student2> list = Arrays.asList(
			 new Student2("홍길동",90,96),
			 new Student2("신용권",95,93));
//	 list.
	 
//	 public static void printString(Function<Student2,String> function) {
//		 for (Student2 s:list) {
//			 System.out.println(function.apply(s)+ " ");
//		 }
//		 System.out.println();
//	 }
	 
	 public static void print(Function<Student2,?> function) {
//		 for (Student2 s:list) {
//			 System.out.println(function.apply(s)+ " ");
//		 }
		 list.forEach(e->System.out.println(function.apply(e)));
		 System.out.println();
	 }
	 
	 public static void main(String[] args) {
		System.out.println("학생이름");
		print(t->t.getName());
		
		print(t->t.getEnglishScore());
		
		
	}
}
