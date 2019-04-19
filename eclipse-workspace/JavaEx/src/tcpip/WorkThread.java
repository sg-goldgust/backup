package tcpip;

import java.io.*;

import java.net.Socket;

public class WorkThread extends Thread{
	
	private Socket socket;

	public WorkThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hi");
		try {
			BufferedReader r = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter w = new PrintWriter(socket.getOutputStream());
			
			String line = r.readLine();
			System.out.println("서버 수신메시지:"+line);
			
			w.println(line);
			w.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {socket.close();} catch(Exception e) {}
		}
	}
	
	
}
