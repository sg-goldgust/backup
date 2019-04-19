package multichat;

import java.net.Socket;
import java.util.Scanner;

import multichat.ReceiverThread;
import multichat.SenderThread;

public class MultiChattingClient {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("user name >");
		String userName = s.nextLine();
		
		try {
			Socket socket = new Socket("70.12.112.130",9002);
			Thread thread1 = new SenderThread(socket,userName);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
