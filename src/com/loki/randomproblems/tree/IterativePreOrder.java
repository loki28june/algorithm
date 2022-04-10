package com.loki.randomproblems.tree;

import java.util.Stack;

import com.loki.randomproblems.tree.InorderWithoutRecursion.Node;

public class IterativePreOrder {
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

	public static void preorder(Node root) {
		if (root == null) {
			return;
		}

		Node currentNode = root;
		Stack<Node> s = new Stack<>();
		s.push(root);

		/*while (currentNode != null) {
			s.push(currentNode);
			currentNode = currentNode.left;
		}*/

		while (s.isEmpty() == false) {

			Node popped = s.pop();
			System.out.println(popped.data + " ");
			
			if (popped.right != null) {
				s.push(popped.right);
			}
			
            if(popped.left != null){
			 s.push(popped.left);	
			}


		}
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		preorder(root);

	}

}
