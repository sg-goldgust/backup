package chapter18;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {
	public static void main(String[] args) {
		// File file = new File("C:/Temp/file.txt");
		// File file = new File("C:/Temp", "file.txt");
		File dir = new File("C:/Temp");
		File file = new File(dir, "file.txt");
		
		try(
			FileWriter fw = new FileWriter(file, true);
		){
			fw.write("FileWriter는 한글로된 " + "\r\n");
			fw.write("문자열을 바로 출력할 수 있다." + "\n");
			fw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다.");
	}

}