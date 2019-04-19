package edu.autocar.datastructure.list;

public class StackEx {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		stack.print();
	
		System.out.println("pop : " + stack.pop());
		stack.print();
		System.out.println("pop : " + stack.pop());
		stack.print();
		System.out.println("pop : " + stack.pop());
		stack.print();
		System.out.println("pop : " + stack.pop());
		stack.print();
		
	}

}
