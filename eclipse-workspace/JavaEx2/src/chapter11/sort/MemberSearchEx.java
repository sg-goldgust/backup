package chapter11.sort;

import java.util.Arrays;

public class MemberSearchEx {
	public static void main(String[] args) {
		// 기본 타입값 검색
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 100);
		System.out.println("찾은 인덱스: " + index);

		// 문자열 검색
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스: " + index);
		
		
		// 객체 검색
		Member m1 = new Member("홍길동", 10);
		Member m2 = new Member("박동수", 30);
		Member m3 = new Member("김민수", 20);
		Member[] members = { m1, m2, m3 };

		Arrays.sort(members);
		index = Arrays.binarySearch(members, new Member("김민수", 30));

		System.out.println("찾은 인덱스: " + index);


	}
}
