package edu.autocar.datastructure.list;

public class DoubleLinkedListEx {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.add(0, 300);
		list.print();
		list.add(7);
		list.print();
		list.add(5);
		list.print();
		list.add(4);
		list.print();
		
		list.add(2, 100);
		list.print();
		
		
	}

}
