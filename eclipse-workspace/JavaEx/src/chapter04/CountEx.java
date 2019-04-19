package chapter04;

public class CountEx {

	public static void main(String[] args) {
		int totalCount = 10000;
		int rockCount = 0;
		int scissorsCount = 0;
		int paperCount = 0;
		
		for(int i=0; i<totalCount; i++) {
			int value = Game1Ex.select();
			switch(value) {
			case 0: rockCount++; break;
			case 1: scissorsCount++; break;
			case 2: paperCount++; break;			
			}			
		}	
		
		System.out.println("주먹의 비율 : " + 
							rockCount/(double)totalCount);
		System.out.println("가위의 비율 : " + 
							scissorsCount/(double)totalCount);
		System.out.println("보의 비율 : " + 
							paperCount/(double)totalCount);
		
	}

}
