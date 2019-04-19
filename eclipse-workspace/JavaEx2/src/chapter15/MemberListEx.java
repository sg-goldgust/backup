package chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MemberListEx {

	public static void main(String[] args) {
		List<Member> list = Member.getTestList();
		
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				String userId1 = o1.getUserId();
				String userId2 = o2.getUserId();
				return userId1.compareTo(userId2);
			}
		});

		for(Member m : list) {
			System.out.println(m);
		}
		
		System.out.println("----------------------");
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				Integer age1 = o1.getAge();
				Integer age2 = o2.getAge();
				return age1.compareTo(age2);
				// return o1.getAge() - o2.getAge();
			}
		});

		for(Member m : list) {
			System.out.println(m);
		}
		
		System.out.println("--------------------------------");
		// 디폴트 정렬
		Collections.sort(list);
		// Collections.reverse(list);
		for(Member m : list) {
			System.out.println(m);
		}		
		
		
	}

}
