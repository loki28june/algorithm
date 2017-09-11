package com.loki.tree;

import com.loki.tree.IterativePreOrder.Node;

public class DeleteTree {
	static Node root = null;



	public static void deleteTree(Node root) {
		if (root == null) {
			return;
		}
		
		
		deleteTree(root.left);
		
		deleteTree(root.right);
		
		root = null;

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		;
		deleteTree(root);
	}

}
