package chapter18;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableWriter {
	public static void main(String[] args) throws Exception {
		try(FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			List<ClassA> list = new ArrayList<>();
			for(int i=0; i<100; i++) {
				ClassA classA = new ClassA();
				classA.field1 = i;
				classA.field2.field1 = i+1;
				classA.field3 = i+2;	// static
				classA.field4 = i+3;	// transient
				list.add(classA);
			}
			
			oos.writeObject(list);
			oos.flush();
			System.out.println("저장완료");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

}

