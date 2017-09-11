package com.loki.tree;

public class MirrorImage {
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

	public static void mirror(Node r) {
		// boolean isIdentical = false;
		if (r == null) {
			return;
		}

		mirror(r.left);
		mirror(r.right);

		Node temp = r.left;
		r.left = r.right;
		r.right = temp;

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
		inorder(r);
		System.out.println();
		mirror(r);
		inorder(r);

	}

}
