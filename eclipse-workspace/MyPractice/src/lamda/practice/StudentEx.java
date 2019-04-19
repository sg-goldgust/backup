package lamda.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StudentEx {

	static List<Vo> list = Arrays.asList(new Vo("홍길동", "남자", 90), new Vo("김순희", "여자", 90), new Vo("감자바", "남자", 95),
			new Vo("박한나", "여자", 92));

	static double avg(Predicate<Vo> predicate) {
		int count = 0;
		int sum = 0;
		for (Vo auto : list) {
			if (predicate.test(auto)) {
				count++;
				sum += auto.getScore();
			}
		}
		return (double)sum / count;
	}

	public static void main(String[] args) {
		// student의 필드는 이름 성적 성별
		// list초기화
		// list에서 선택적으로 평균구하기
		double maleAvg = avg((t) -> t.getSex().equals("남자"));
		double highAvg = avg((t) -> t.getScore() > 92);
		System.out.println(maleAvg);
		System.out.println(highAvg);
		
		list.forEach((t)->{System.out.println(t.getScore());});
		
		Consumer function;
		function = System.out::println;
		function.accept("hi");
		

	}
}
