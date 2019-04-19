package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample2 {
	private static List<Student2> list = Arrays.asList(
			new Student2("홍길동",95,95),
			new Student2("이도훈",100,100));
	
	public static double avg(Function<Student2,Integer> function) {
		int sum=0;
		for (Student2 s : list) {
			sum += function.apply(s);
		}
		double avg = (double)sum/list.size();
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg(s->s.getEnglishScore());
		System.out.println(englishAvg);
	}

}
