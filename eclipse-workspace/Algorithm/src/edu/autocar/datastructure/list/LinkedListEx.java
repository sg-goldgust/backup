package edu.autocar.datastructure.list;

public class LinkedListEx {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add(10);
		list.print();
		list.add(20);
		list.print();
		list.add(5);
		list.print();
		list.add(3);
		list.print();
		
		list.add(0, 11);
		list.print();
		
		list.add(1, 100);
		list.print();
		
		int value = list.remove(3);
		System.out.println("삭제값 : " + value);
		list.print();
		
		int index = 2;
		value = list.get(index);
		System.out.println(index + " 인덱스 값 : " + value);
		
		int sum =0;
		// 리스트의 순회
		for(int i=0; i<list.getSize(); i++) {
			sum += list.get(i);
		}
		
		System.out.println("합계 : " +  sum);
		System.out.println("평균 : " +  (double)sum/list.getSize());
	}

}






