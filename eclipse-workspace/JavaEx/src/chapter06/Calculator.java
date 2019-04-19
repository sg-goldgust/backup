package chapter06;

public class Calculator {
	double result;	// 계산 결과
	boolean state;	// 전원 on/off 상태
	
	// 메소드
	void powerOn() {
		state = true;
		System.out.println("전원을 켭니다.");
		
	}
	
	void powerOff() {
		state = false;
		System.out.println("전원을 끕니다");
	}
	
	void clear() {
		result = 0;
	}
	
	int plus(int x, int y) {
		result = x + y;
		return (int)result;
	}

	int plus(int x) {
		result += x;
		return (int)result;
		
	}
	
	double divide(int x, int y) {
		result = (double) x / (double) y;
		return result;
	}
	
	double divide(int x) {
		result /= x;
		return result;
	}

	@Override
	public String toString() {
		return "Calculator [state=" + state + ", result=" + result + "]";
	}	

	
}
