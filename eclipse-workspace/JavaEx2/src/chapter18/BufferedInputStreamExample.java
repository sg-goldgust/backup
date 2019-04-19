package chapter18;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {

	public static void main(String[] args) {
		long start;
		long end;
		
		try(
			FileInputStream fis = new FileInputStream("c:/temp/Lighthouse.jpg");
		){
			monitoring(fis);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(
			FileInputStream fis = new FileInputStream("c:/temp/Lighthouse.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis);	
		){
			monitoring(bis);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void monitoring(InputStream is) throws IOException {
		long start;
		long end;
		start = System.currentTimeMillis();
		while(is.read()!=-1) {}
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}


