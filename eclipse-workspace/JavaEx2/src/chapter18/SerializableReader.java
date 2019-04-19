package chapter18;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class SerializableReader {
	public static void main(String[] args) throws Exception {
		try(FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);){
			List<ClassA> list = (List<ClassA>) ois.readObject();
			
			for(ClassA v : list) {
				System.out.println("field1: " + v.field1);
				System.out.println("field2.field1: " + v.field2.field1);
				System.out.println("field3: " + v.field3);
				System.out.println("field4: " + v.field4);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
