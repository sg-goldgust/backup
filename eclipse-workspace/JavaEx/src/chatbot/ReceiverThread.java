package chatbot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {
	Socket socket;
	
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String str= reader.readLine();
				if(str == null) break;
				System.out.println("현호형 하위 :" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
}
