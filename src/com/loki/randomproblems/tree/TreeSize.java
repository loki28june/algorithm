package com.loki.randomproblems.tree;

import com.loki.randomproblems.tree.IterativePreOrder.Node;

public class TreeSize {
	static Node root = null;



	public static int getSize(Node root) {
		if (root == null) {
			return 0;
		}
		return getSize(root.left) + getSize(root.right) + 1;

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		;
		System.out.println(getSize(root));
	}

}
