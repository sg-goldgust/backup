package chatbot;

import java.net.Socket;

public class ChattingClient {
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("70.12.112.135",9001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
}
