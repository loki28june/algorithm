package com.loki.Trees;



public class RootToLeafPath {
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
	
	public static void print(int[] ints, int length){
		
		for(int i = 0; i< length; i++){
			System.out.print(ints[i]+" ");
		}
		System.out.println();
	}

	public static void printPath(Node r,int[] path, int len) {
		// boolean isIdentical = false;
		if (r == null) {
			return;
		}
		
	
		path[len] = r.data;
		len++;
		
		if(r.left == null && r.right == null){
			
			print(path,len);
		}
		else{
			
			printPath(r.left,path,len);
			printPath(r.right,path,len);
		}

	}

	public static void inorder(Node root) {

		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	public static void main(String[] args) {
		r = new Node(1);
		r.left = new Node(2);
		r.right = new Node(3);
		r.left.left = new Node(4);
		r.left.right = new Node(5);
		int[] path = new int[1000];
		int len = 0;
		
		printPath(r,path,len);

	}

}
