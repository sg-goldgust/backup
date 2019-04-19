package chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws Exception {
		
		try(FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			oos.writeObject(10);
			oos.writeObject(3.14);
			oos.writeObject(new int[] { 1, 2, 3 });
			oos.writeObject(new String("홍길동"));
			
			oos.flush();			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			int obj1 = (int) ois.readObject();
			double obj2 = (double) ois.readObject();
			int[] obj3 = (int[]) ois.readObject();
			String obj4 = (String) ois.readObject();
			
			System.out.println(obj1);
			System.out.println(obj2);
			System.out.println(obj3[0] + "," + obj3[1] + "," + obj3[2]);
			System.out.println(obj4);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

				
		
	}

}
