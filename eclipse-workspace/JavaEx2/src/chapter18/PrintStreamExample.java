package chapter18;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		try(
			FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
			PrintStream ps = new PrintStream(fos);
		){
			// 파일로 저장 
			print(ps);	
			
			// 화면 출력 
			print(System.out);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(PrintStream ps) {
		ps.println("[프린터 보조 스트림]");
		ps.print("마치 ");
		ps.println("프린터가 출력하는 것처럼 ");
		ps.println("데이터를 출력합니다.");
		ps.flush();
	}

}
