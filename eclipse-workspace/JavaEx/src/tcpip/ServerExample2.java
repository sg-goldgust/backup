package tcpip;

import java.io.*;
import java.net.*;

public class ServerExample2 {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try (ServerSocket server = new ServerSocket(9000)){
			while (true) {
				socket = server.accept();
				
				WorkThread work = new WorkThread(socket);
				work.start();
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

}
