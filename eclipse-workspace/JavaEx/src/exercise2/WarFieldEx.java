package exercise2;

public class WarFieldEx {
	public static void main(String[] args) {
		
		WarField field = new WarField(7, 7);
		Boomb[] boombs = new  Boomb[] {
				new BoombD(3, 3),
				new BoombA(4, 3),
				new BoombC(5, 5),
				new BoombB(6, 1),
		};
		
		for(int i=0; i<boombs.length; i++) {
			field.underAttack(boombs[i]);
		}
		
		field.print();
		System.out.println("안전 지역 수 : " + 
						field.getSafeZoneCount());
	}

}
