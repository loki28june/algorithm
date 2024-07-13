package com.loki.basic.dsa.tree;

public class LeftView {
	static Node r;

	static class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = null;
			right = null;
		}

	}
	
	

	public static void printLeftView(Node r) {
		if(r == null) return;
		
		if(r.left != null){
			System.out.print(r.left.data+" ");
		}
		
		printLeftView(r.left);
		printLeftView(r.right);
		
		
	
	}



	public static void main(String[] args) {
		r = new Node(1);
		r.left = new Node(2);
		r.right = new Node(3);
		r.left.left = new Node(4);
		r.left.right = new Node(5);
		r.right.left = new Node(6);
		System.out.print(r.data+" ");
		printLeftView(r);

	}

}
