package chapter11;

public class StringLengthExample {
	public static void main(String[] args) {

		String ssn = "7306241230123";
		int length = ssn.length();

		if (length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
		
		
		// 문자열 reverse
		String revSsn = "";
		for(int i=length-1; i>=0; i--) {
			revSsn += ssn.charAt(i);
		}
		
		System.out.println(revSsn);
	}
}





