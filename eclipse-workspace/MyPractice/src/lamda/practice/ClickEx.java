package lamda.practice;

public class ClickEx {
	
	public static void main(String[] args) {
		ClickInterface ci;
		
		ci = () -> {
			String str = "sns전송";
			System.out.println(str);
		};
		ci.click();
		
		Runnable runnable;
		runnable = ()-> {
			String str = "email전송";
			System.out.println(str);
		};
		runnable.run();
		
	}

}
