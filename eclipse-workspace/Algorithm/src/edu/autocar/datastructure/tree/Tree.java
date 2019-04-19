package edu.autocar.datastructure.tree;

public class Tree<T> {
	private Node root;
	
	private class Node {
		T value;
		Node left;
		Node right;
		
		Node(T t) {
			value = t;
		}
	}
	
	public void add(T t) {
		Node node = new Node(t);
		if(root==null) {
			root = node;
		} else {
			Node temp = root;
			while(temp!=null) {
				
			}
		}
	}
	
	
	
	
}
