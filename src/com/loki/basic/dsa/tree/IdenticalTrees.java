package com.loki.basic.dsa.tree;



public class IdenticalTrees {
	static Node root1,root2;
	static class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = null;
			right = null;
		}

	}
	
	public static boolean isIdentical(Node r1, Node r2){
		//boolean isIdentical = false;
		if(r1 == null && r2 == null){
			return true;
		}
		
		if(r1 !=null  && r2 != null){
			return r1.data == r2.data && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
		}
		
		return false;
		

}

	public static void main(String[] args) {
		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		
		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		
		System.out.println("are trees are identical => "+isIdentical(root1, root2));
		
		

	}

}
