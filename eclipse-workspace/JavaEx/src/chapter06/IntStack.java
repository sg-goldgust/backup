package chapter06;

public class IntStack {
	private int []datas;
	private int top;

	public IntStack() {
		this(10);
		// datas = new int[10];
	}
	
	public IntStack(int size) {
		datas = new int[size];
		top = -1;
	}
	
	
	public int getTop() {
		return top;
	}
	
	public void push(int value) {
		// FULL 여부 검사
		if(top == (datas.length-1)) {
			// 배열을 2배로 늘리기
			int []arr = new int[datas.length*2];
			System.arraycopy(datas, 0, arr, 0, datas.length);
			datas = arr;
		}
		
		top++;
		datas[top] = value;
	}
	
	public int pop() {
		
		if(top == -1) {	// 스택이 비어있으면,
			return Integer.MIN_VALUE;
		}
		
		
		int value = datas[top];
		top--;
		return value; 
		
	}
	
	public void clear() {
		top = -1;
	}
	
	public String toString() {
		String strData = "";	// 스택의 내용을 표현하는 문자열
		
		for(int i=0; i<= top; i++) {	
			strData += datas[i];
			if(i<top) {	// 마지막 요소가 아닌 경우에
				strData += ", ";
			}
		}	
		
		return "Capacity: " + datas.length + 
				", top : " + top + 
				", stack : [" + strData + "]";  
	}
}








