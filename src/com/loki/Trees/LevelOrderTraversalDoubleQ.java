package com.loki.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalDoubleQ {

	private static void levelOrder(Node root) {
		int height = height(root);

		for (int i = 1; i <= height; i++) {
			printLevel(root, i);
		}

	}

	private static void printLevel(Node root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.println(root.key);
		}

		if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);

		}
	}

	private static int height(Node root) {

		if (root == null)
			return 0;

		else {

			int lh = height(root.left);
			int rh = height(root.right);

			if (lh > rh) {
				return lh + 1;
			} else {
				return rh + 1;
			}
		}
	}

	public static void main(String[] args) {

		BasicTree tree = new BasicTree(1);
		tree.getRoot().left = new Node(2);
		tree.getRoot().right = new Node(3);
		tree.getRoot().left.left = new Node(4);
		tree.getRoot().left.right = new Node(5);

		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		if (tree.getRoot() != null) {
			q1.add(tree.getRoot());
		} else {
			System.out.println("root is null");
		}

		while (!q1.isEmpty() || !q2.isEmpty()) {

			while (!q1.isEmpty()) {

				Node temp = q1.poll();

				if (temp.left != null) {
					q2.add(temp.left);

				}
				if (temp.right != null) {
					q2.add(temp.right);
				}

				System.out.print(temp.key + " ");

			}

			System.out.println();

			while (!q2.isEmpty()) {

				Node temp = q2.poll();
				if (temp.left != null) {
					q1.add(temp.left);

				}
				if (temp.right != null) {
					q1.add(temp.right);
				}
				System.out.print(temp.key + " ");
			}

			System.out.println();
		}

		// levelOrder(tree.getRoot());
	}

}
