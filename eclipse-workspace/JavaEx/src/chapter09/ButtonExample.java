package chapter09;

import chapter09.Button.OnClickListener;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();
		
		btn.setOnClickListener(new MessageListener());
		btn.touch();
		
		// 익명 구현 객체로 어플리케이션을 종료하세요.
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		});
		btn.touch();	
				
		
		// 익명 구현 객체로 팩스를 보내세요.
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("팩스를 보냅니다.");				
			}
		});
		btn.touch();
		

	}

}

