package com.loki.randomproblems.tree;

import java.util.Stack;

public class InorderWithoutRecursion {
	static Node root = null;

	static class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = null;
			right = null;
		}

	}

	public static void inorder(Node root) {
		if (root == null) {
			return;
		}

		Node currentNode = root;
		Stack<Node> s = new Stack<>();

		while (currentNode != null) {
			s.push(currentNode);
			currentNode = currentNode.left;
		}

		while (s.size() > 0) {

			Node popped = s.pop();
			System.out.print(popped.data + " ");

			if (popped.right != null) {
				currentNode = popped.right;
			}

			while (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			}

		}
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		inorder(root);

	}

}
