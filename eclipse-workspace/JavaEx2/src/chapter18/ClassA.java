package chapter18;

import java.io.Serializable;

public class ClassA  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int field1;
	ClassB field2 = new ClassB();	
	static int field3;
	transient int field4;
	
	@Override
	public String toString() {
		return "ClassA [field1=" + field1 + ", field2=" + field2 + "]";
	}
	
	
}