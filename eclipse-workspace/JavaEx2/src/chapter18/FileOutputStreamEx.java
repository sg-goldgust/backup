package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		String originalFileName = "C:/temp/house.jpg";
		String targetFileName = "C:/Temp/house_copy.jpg";

		try(
			FileInputStream fis = new FileInputStream(originalFileName);
			FileOutputStream fos = new FileOutputStream(targetFileName);
		){
			int readByteNo;
			byte[] readBytes = new byte[100];
			while( (readByteNo = fis.read(readBytes)) != -1 ) {
				fos.write(readBytes, 0, readByteNo);
			}
			fos.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
