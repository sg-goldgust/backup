package chapter15.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chapter15.Member;

public class TestService {
	private List<Member> list;
	
	private static TestService instance = new TestService();
	
	private TestService() {
		list = Member.getTestList();
	}
	
	public static TestService getInstance() {
		return instance;
	}
		
	public List<Member> getList() {
		return list;
	}
	
	
	public void open(String fpath) {
		// 파일을 열고 읽었다고 가정  --> list의 내용을 무작위로 썩음
		Collections.shuffle(list);
	}
	
	// 지역 목록 얻기
	// public List<String> getRegions() {
	public String[] getRegions() {
		Set<String> set = new HashSet<>();
		
		for(Member member: list) {
			set.add(member.getRegion());
		}
		return set.toArray(new String[set.size()]);
	}

	// 지역의 멤버 얻기
	// public List<Member> getMemberList(String region) {
	public Member[] getMemberList(String region) {
		List<Member> tlist = new ArrayList<>();
		for(Member member : list) {
			if(member.getRegion().equals(region)) {
				tlist.add(member);
			}
		}		
		return tlist.toArray(new Member[tlist.size()]);
	}
	
	public <T> T get(Class<T> cls) {
		try {			
			Object obj = cls.newInstance();
			return cls.cast(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
				
	}
}







