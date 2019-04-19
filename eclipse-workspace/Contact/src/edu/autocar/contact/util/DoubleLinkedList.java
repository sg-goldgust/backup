package edu.autocar.contact.util;

import edu.autocar.contact.model.Contact;

public class DoubleLinkedList {
	Node head;
	int size;
	
	public DoubleLinkedList() {
		clear();
	}
	
	private class Node {
		Contact value;
		Node	prev;
		Node	next;
		
		Node(Contact c) {
			value = c;
		}
	}
	
	public void clear() {
		head = new Node(null);
		head.prev = head;
		head.next = head;
		size = 0;
	}
	
	
	public void add(Contact c) {
		Node node = new Node(c);
		
		node.prev = head.prev;	// head.prev : 리스트의 마지막 노드
		node.next = head;		
		
		head.prev.next = node;	
		head.prev = node;
		
		size++;
	}
	
	public void add(int ix, Contact c) {
		Node node = new Node(c);
		Node t = getNode(ix);
		
		node.prev = t.prev;	
		node.next = t;		
		
		t.prev.next = node;	
		t.prev = node;
		size++;
	}
	
	public Contact remove(int ix) {
		Node node = getNode(ix);

		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		size--;
		return node.value;
	}
	
	private Node getNode(int ix) {
		Node t = head.next;
		for(int i=0; i<ix; i++) {
			t = t.next;
		}
		return t;
	}
	
	public int getSize() {
		return size;
	}
	
	public Contact get(int ix) {
		Node node = getNode(ix);
		return node.value;
	}
	
	
	public void print() {
		Node t = head.next;
		while(t.next !=head) {
			System.out.println(t.value);
			t = t.next;
		}
		System.out.println();
	}
	
}
