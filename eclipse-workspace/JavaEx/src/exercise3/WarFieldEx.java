package exercise3;

import java.util.Random;

public class WarFieldEx {
	static Class[] boombClass = {
			TimeBoomb.class,
			Boomb.class,
			Mine.class,
			Missile.class
	};
	
	public static void test(int widht, int height) {
		WarField field = new WarField(widht, height);
		Boombable [] boombs = new  Boombable[4];
		
		Random r = new Random();
		for(int i=0; i<boombs.length;i++) {
			int sel = r.nextInt(boombClass.length);			
			try {
				boombs[i] = (Boombable)boombClass[sel].newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		for(int i=0; i<boombs.length; i++) {
			int x = r.nextInt(field.width());
			int y = r.nextInt(field.height());
			
			field.underAttack(boombs[i], x, y);
		}
		
		field.print();
		System.out.println("안전 지역 수 : " + 
						field.getSafeZoneCount());
		System.out.println();
	}
	public static void main(String[] args) {
		test(7, 7);
		test(8, 8);
		test(10, 10);		
	}
}
