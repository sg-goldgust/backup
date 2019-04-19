package chapter18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {

	public static void main(String[] args) {
		
		try(
			FileOutputStream fos = new FileOutputStream(
										"C:/Temp/primitive.dat");
			DataOutputStream dos = new DataOutputStream(fos);
		){
			dos.writeUTF("홍길동");
			dos.writeDouble(95.5);
			dos.writeInt(1);
			
			dos.writeUTF("감자바");
			dos.writeDouble(90.3);
			dos.writeInt(2);
			
			dos.flush(); 			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(
			FileInputStream fis = new FileInputStream(
										"C:/Temp/primitive.dat");
			DataInputStream dis = new DataInputStream(fis);
		){
			for(int i=0; i<2; i++) {
				String name = dis.readUTF();
				int order = dis.readInt();
				double score = dis.readDouble();
				
				System.out.println(name + " : " + score + " : " + order);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
