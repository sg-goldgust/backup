package chapter11.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MemberSortEx {

	public static void main(String[] args) {
		int[] scores = { 99, 97, 98 };

		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		System.out.println();

		String[] names = { "홍길동", "박동수", "김민수" };
		System.out.println(Arrays.toString(names));
		System.out.println();
		
//		Member m1 = new Member("홍길동");
//		Member m2 = new Member("박동수");
//		Member m3 = new Member("김민수");
//
//		Member[] members = { m1, m2, m3 };
		
		Member[] members = { 
				new Member("홍길동", 20),
				new Member("박동수", 30),
				new Member("김민수", 15)
		};
		
		Comparator<Member> comp= new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		};
		
		
		// Arrays.sort(members, comp);
		Arrays.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		});
		
		System.out.println(Arrays.toString(members));
		System.out.println();
	}


}
