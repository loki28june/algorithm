package com.loki.Trees;

import java.util.Stack;

public class IterativePostOrder {
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

	public static void postorder(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> firstStack = new Stack<>();
		Stack<Node> secondStack = new Stack<>();
		firstStack.push(root);

		while (firstStack.isEmpty() == false) {

			Node popped = firstStack.pop();
			secondStack.push(popped);

			if (popped.left != null) {
				firstStack.push(popped.left);
			}

			if (popped.right != null) {
				firstStack.push(popped.right);
			}
		}

		while (!secondStack.isEmpty()) {
			System.out.print(secondStack.pop().data+" ");
		}

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		postorder(root);

	}

}
