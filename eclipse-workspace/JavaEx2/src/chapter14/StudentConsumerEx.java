package chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class StudentConsumerEx {
	
	static List<Student> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new Student("홍길동",70));
		list.add(new Student("고길동",80));
		list.add(new Student("둘리",90));
		list.add(new Student("마이콜",70));
		
		forEach((student,i)->System.out.println(i+". "+student));
		//
		forEach((student,i)->System.out.println(i+". "+student.name));
		
		list.forEach(hi->System.out.println(hi)); //point
	}
	
	public static void forEach(BiConsumer<Student,Integer> con) {
		
		for (int i=1 ; i<list.size() ; i++) {
			con.accept(list.get(i-1),i);
		}	
		//리스트를 순회하면서 어떤 작업을 실행하여야 한다.
		//어떤 작업을 실행할지는 매개변수로 전달된 코드로 실행한다.
	}
	
	

}
