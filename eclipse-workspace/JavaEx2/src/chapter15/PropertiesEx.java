package chapter15;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

import edu.autocar.base.util.Resource;

public class PropertiesEx {

	public static void main(String[] args) throws Exception {
		Properties properties  = Resource.getProperties(
									"/resource/database.properties");
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password"); 
		
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
	
		
		try {
			Class.forName(driver);
			System.out.println("db 접속 준비 완료");
		} catch (Exception e) {
			System.out.println(driver + " 클래스가 준비되지 않았습니다.");
		}
		
		
	}


}
