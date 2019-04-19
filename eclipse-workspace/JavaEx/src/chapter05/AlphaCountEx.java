package chapter05;

public class AlphaCountEx {

	public static void main(String[] args) {
		int n = (int) (Math.random() * 50) + 50; // 배열의 크기 결정
		char[] arr = new char[n]; // 길이 n인 배열 생성

		for (int i = 0; i < arr.length; i++) {
			// 랜덤하게 글자 선택
			arr[i] = (char) ((int) (Math.random() * 26) + 'A');
		}

		int[] count = new int[26]; // 알파벳 문자수 만큼의 길이
		// 글자 수 카운트
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] - 'A'; // 글자를 인덱스로 해석
			count[index]++;
		}

		// 글자 수 출력
		for (int i = 0; i < count.length; i++) {
			char ch = (char) ('A' + i);
			System.out.println(ch + " : " + count[i]);
		}
	}

}









