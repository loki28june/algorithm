package com.loki.basic.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalQAndS {

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

		Queue<Node> q = new LinkedList<>();
		
		Stack<Node> s = new Stack<>();

		if (tree.getRoot() != null) {
			q.add(tree.getRoot());
		}

		else {
			System.out.println("root is null");
		}

		while (!q.isEmpty()) {

			Node temp = q.poll();

			//System.out.print(temp.key + " ");
			
			s.push(temp);

			if (temp.right != null) {
				q.add(temp.right);
			}
			
			if (temp.left != null) {
				q.add(temp.left);

			}
			
			
			//System.out.println();

		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop().key);
		}

		// levelOrder(tree.getRoot());
	}

}
