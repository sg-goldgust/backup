package chapter18;

import java.util.Date;

public class PrintfExample {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다\n", now, now, now);
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다\n", now);
		System.out.printf("현재 %1$tH시 %1$tM분 %1$tS초 입니다\n", now);

		String s = String.format("%1$tY-%1$tm-%1$td", now);
		System.out.println(s);
	}
}
