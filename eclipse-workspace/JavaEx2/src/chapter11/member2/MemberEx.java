package chapter11.member2;

public class MemberEx {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("blue", "홍길동", "12345", 
									25, true);

		// 복제 객체를 얻은 후에 패스워드 변경
		Member cloned = original.getMember();
		cloned.password = "67890";

		System.out.println("[복제 객체의 필드값]");
		System.out.println(cloned);
		System.out.println();

		System.out.println("[원본 객체의 필드값]");
		System.out.println(original);
	}

}
