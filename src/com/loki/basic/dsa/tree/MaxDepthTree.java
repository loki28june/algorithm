package com.loki.basic.dsa.tree;

public class MaxDepthTree {
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
	
	public static int getDepth(Node r1){
		//boolean isIdentical = false;
		if(r1 == null){
			return 0;
		}
	int lh = getDepth(r1.left);
	int rh = getDepth(r1.right);
	
	if(lh > rh){
		return lh + 1;
	}
	else{
		return rh + 1;
	}
		

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
		
		System.out.println("are trees are identical => "+getDepth(root1));
		
		

	}

}
