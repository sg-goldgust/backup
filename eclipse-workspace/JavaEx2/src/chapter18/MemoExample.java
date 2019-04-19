package chapter18;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import edu.autocar.base.util.Input;

public class MemoExample {
	public static void main(String[] args) {
		
		String content = Input.getMultiLine("내용 :");
		String fname = Input.getString("저장할 파일명 :");
		
		File file = new File("c:/temp", fname);
		
		try {
			save(file, content);
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void save(File file, String content)
				throws Exception{
		try(
			FileWriter fw = new FileWriter(file);
		){
			fw.write(content);
			fw.flush();
		}
	}
	
	public static String load(File file) throws Exception{
		StringBuilder sb = new StringBuilder();
		try(
			FileReader fr = new FileReader(file);
		){
			int readCharNo;
			char[] cbuf = new char[100];
			while ((readCharNo=fr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCharNo);
//				String data = new String(cbuf, 0, readCharNo);
//				sb.append(data);
			}	
		}
		return sb.toString();
	}
	
}
