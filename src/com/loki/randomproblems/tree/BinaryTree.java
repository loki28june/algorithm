package com.loki.randomproblems.tree;

import java.util.Stack;

public class BinaryTree {

	public static class TreeNode{
		
		private int data;
		private TreeNode left = null;
		private TreeNode right = null;
		public int getData() {
			return data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public TreeNode(int data) {
			this.data = data;
		}
	}

	// creating binary tree
	public TreeNode createBinaryTree(){
		TreeNode root = new TreeNode(10);
		TreeNode node20 = new TreeNode(20);
		TreeNode node30 = new TreeNode(30);
		TreeNode node40 = new TreeNode(40);
		TreeNode node50 = new TreeNode(50);
		root.left = node20;
		root.right = node30;
		node20.left = node40;
		node30.right = node50;
		return root;
	}

	public void preOrder(TreeNode root ){
		if(root != null){
			System.out.print(" "+ root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrderIterative(TreeNode root){
		if(root == null){
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root); // pushing the root node into the stack

		while(!stack.isEmpty()){
			// print the root node data 
			TreeNode n = stack.pop();
			System.out.print(" "+ n.data);

			if(n.right != null){
				stack.push(n.right);
			}
			if(n.left != null){
				stack.push(n.left);
			}
		}

	}

	public void inOrder(TreeNode root ){
		if(root != null){
			inOrder(root.left);
			System.out.print(" "+ root.data);
			inOrder(root.right);
		}
	}

	public void postOrder(TreeNode root ){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(" "+ root.data);
		}

	}

	public static void main(String[] args) {
		// creating a tree and traversing it 
		BinaryTree t = new BinaryTree();
		TreeNode root = t.createBinaryTree();
		t.preOrderIterative(root);
		System.out.println();
		t.inOrder(root);
		System.out.println();
		t.postOrder(root);
		System.out.println();
	}

}
