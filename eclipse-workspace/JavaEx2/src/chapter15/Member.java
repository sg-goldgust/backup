package chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Member implements Comparable<Member>{
	private String userId;
	private int age;
	private String region;
	
	// 테스트용 리스트를 생성하는 메서드
	public static List<Member> getTestList() {
		List<Member> list = new ArrayList<>();
		String []regions = { "서울", "부산", "대구", "수원"};
		Random random = new Random();
		
		for(int i=0; i<32; i++) {
			int regionIx = random.nextInt(regions.length);
			list.add(new Member("홍길동 " + i, 40 - i, regions[regionIx]));
		}
		return list;
	}
	
	public Member(String userId, int age, String region) {
		super();
		this.userId = userId;
		this.age = age;
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int compareTo(Member o) {
		int result =userId.compareTo(o.userId);
		if(result ==0) {	// userId가 동률이면
			result = age - o.age;	// 나이로 비교
		}
		return result;
	}
	
	
	
	
}
