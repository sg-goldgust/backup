package chapter15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {
		List<Member> list = Member.getTestList();
		Map<String, List<Member>> map = new HashMap<>();
		
		for(Member member : list) {
			String region = member.getRegion();
			List<Member> regionMemberList = map.get(region);
			if(regionMemberList == null) {	// 해당 지역이 처음 등장함
				// 리스트 생성후 키와 함께 맵에 저장
				regionMemberList = new ArrayList<>();
				map.put(region, regionMemberList);
			}
			// 멤버를 해당 지역 리스트에 추가 
			regionMemberList.add(member);
		}		
		
		//for(Map.Entry<String, List<Member>> entry : map.entrySet()) {
		//	String region = entry.getKey();
		//	List<Member> rlist = entry.getValue();		
		for(String region : map.keySet()) {	
			List<Member> rlist = map.get(region);
			System.out.printf("%s(%d)\n", region, rlist.size());
			for(Member m : rlist) {
				System.out.println("\t"+m.getUserId());
			}
		}
		
		
		
	}

}
