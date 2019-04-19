package chapter05;

public class EnumWeekTest {

	public static void main(String[] args) {
		Week[] days = Week.values();
		System.out.println(days.length);
		
		for(Week day : days) {
			System.out.println(day);
		}
		
		int ix = Week.FRIDAY.ordinal();
		System.out.println(ix);
		System.out.println();
		
		// 랜덤하게 요일 선정하기
		ix = (int)(Math.random()*7);
		Week day = days[ix];
		System.out.println(day);
		
		
	}

}
