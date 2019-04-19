package chapter15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("홍길동", "신용권", "감자바");
		
		// list1.add("둘리");	// list1.remove(0);
		for(String name: list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
		list2.add(5);
		for(int value : list2) {
			System.out.println(value);
		}
		
	}

}
