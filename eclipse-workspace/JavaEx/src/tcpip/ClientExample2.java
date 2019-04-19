package tcpip;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientExample2 {
	
	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1",11000)){
			BufferedReader r = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			
			Scanner s = new Scanner(System.in);
			System.out.println("문자열 입력 >");
			String line = s.nextLine();
			
			w.println(line);
			w.flush();
			
			String receiveLine;
			receiveLine = r.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
