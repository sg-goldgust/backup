package chapter14.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentEx {

	private static List<Student> list = Arrays.asList(new Student("홍길동", "남자", 90), new Student("이도훈", "남자", 100),
			new Student("마동석", "여자", 40), new Student("사나없이사나마나", "여자", 90)); // 초기 리스트를 설정하는 방법

	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		for (Student s : list) {
			if (predicate.test(s)) {
				count++;
				sum += s.getScore();
			}
		}
		return (double) sum / count;
		// list.forEach();
	}

	public static void main(String[] args) {
		double scoreAvg = avg(s -> s.getSex().equals("남자"));
		System.out.println(scoreAvg);

		list.forEach(e -> System.out.println(e));

		System.out.println("--------------");
		List<Student> highlist = selectlist(e -> e.getScore() > 95);
		highlist.forEach(e -> System.out.println(e));

		System.out.println("--------------");
		highlist = selectlist(e -> e.getScore() > 95 && e.getSex().equals("남자"));
		highlist.forEach(e -> System.out.println(e));
	}

	static List<Student> selectlist(Predicate<Student> predicate) {

		List<Student> list2 = new ArrayList<Student>();
//		for (Student s : list) {
//			if (predicate.test(s)) {
//				list2.add(s);
//			}
//		}
		list.forEach(s -> {
			if (predicate.test(s)) {
				list2.add(s);
			}
		});

		return list2;
	}

}
