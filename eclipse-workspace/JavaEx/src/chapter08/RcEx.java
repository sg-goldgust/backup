package chapter08;

public class RcEx {

	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			String name = "익명 리모콘";
			@Override
			public void turnOn() {
				System.out.println(name + " On");
			}
			
			@Override
			public void turnOff() {
				System.out.println(name + " Off");
			}
			
			@Override
			public void setVolume(int volume) {
				equalize(volume);
				System.out.println(volume + " 조정");
			}
			
			public void equalize(int volume) {
				System.out.println("클래식 모드");
			}
			
		};
		
		rc.turnOn();
		rc.setVolume(10);
		// rc.equalize(10);		//에러 
		rc.turnOn();
	}

}
