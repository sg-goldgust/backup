package chapter11;

import java.util.regex.Pattern;

public class RegularExpressionEx {

	public static void main(String[] args) {
		String pattern = ".*\\.mp3";
		boolean result = Pattern.matches(pattern, "song.mp3");
		if (result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}

		pattern = "http:.*";
		result = Pattern.matches(pattern, "https://google.com");
		if (result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
	}

}
