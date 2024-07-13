package com.loki.basic.dsa.tree;

public class LCA {
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

	public static Node lca(Node r,int n1, int n2) {
		// boolean isIdentical = false;
		if (r == null) {
			return null;
		}
		
		if(r.data > n1 && r.data > n2){
			return lca(r.left, n1, n2);
		}
		
		if(r.data < n1 && r.data < n2){
			return lca(r.right, n1, n2);
		}
		
		return r;

	}
	
	public static Node lca2(Node root, int n1, int n2) {
		while (root != null) {
			if (root.data > n1 && root.data > n2) {
				root = root.left;
			} else if (root.data < n1 && root.data < n2) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
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
		r = new Node(20);
		r.left = new Node(8);
		r.right = new Node(22);
		r.left.left = new Node(4);
		r.left.right = new Node(12);
		r.left.right.left = new Node(10);
		r.left.right.right = new Node(14);
		
		Node ans = lca2(r, 10, 14);
		Node a = lca(r, 10, 22);
		System.out.println(ans.data+" "+ a.data);

	}

}
