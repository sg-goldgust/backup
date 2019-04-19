package chapter18;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {

		try(FileInputStream fis = new FileInputStream(
								"C:/temp/test.txt")) {
			int data;
			while ( (data = fis.read() ) != -1 ) {	// 1byte씩 읽고 콘솔에 출력
				System.out.write(data);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

}
