package chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEx {

	public static void main(String[] args) {
		List<Member> list = Member.getTestList();
		
		Set<String> set = new HashSet<>();
		
		for(Member member:list) {
			set.add(member.getRegion());
		}
		
		// 지역을 정렬해서 출력
		List<String> regionList = new ArrayList<>(set);
		Collections.sort(regionList);
		
		for(String region: regionList) {
			System.out.println(region);
		}
		
		
		
		
	}

}
