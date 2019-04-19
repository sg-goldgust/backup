package chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedOutputStreamExample {

	public static void main(String[] args) {
		try(			
			FileInputStream fis = new FileInputStream(
								"c:/temp/Lighthouse.jpg");
			FileOutputStream fos = new FileOutputStream(
								"c:/temp/Lighthouse_out.jpg");
		){
			long time = copy(fis, fos);
			System.out.println("버퍼를 쓰지 않은 경우 : " + time);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(			
			FileInputStream fis = new FileInputStream(
										"c:/temp/Lighthouse.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis);				
			FileOutputStream fos = new FileOutputStream(
										"c:/temp/Lighthouse_out.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		){
			long time = copy(bis, bos);
			System.out.println("버퍼를 사용한 경우 : " + time);			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long copy(InputStream is, OutputStream os) 
			throws IOException {
		long start;
		long end;
		int data;		
		start = System.currentTimeMillis();
		while((data = is.read()) != -1) {
			os.write(data);
		}
		os.flush();
		end = System.currentTimeMillis();
		return end - start;
	}

}
