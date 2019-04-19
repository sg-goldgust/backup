package chapter14;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		
		Consumer<String> consumer = t->System.out.println(t);
		consumer.accept("hi");
		
		BiConsumer<String, String> biCon = (t,u)-> System.out.println(t+u);
		biCon.accept("hi", " world");
		
		ObjIntConsumer<String> objIntConsumer = (t,i)->System.out.println(t+i);
		objIntConsumer.accept("hello world ", 2);
	}

}
