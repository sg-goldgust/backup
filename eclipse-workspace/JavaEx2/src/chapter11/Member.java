package chapter11;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {			// 매개값이 Member 타입인지 확인
			Member member = (Member) obj;		// 타입변환후
			if (id.equals(member.id)) {		// id 필드 동일 여부 확인
				return true;
			}
		}
		return false;
	}

}
