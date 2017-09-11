package com.loki.Trees;

public class BasicTree {
	private Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BasicTree() {
		root = null;
	}
	
	public BasicTree(int key){
		
		this.root = new Node(key);
	}
	
	
	
	public static void main(String[] args) {
		Node newNode = new Node(1);
		//BasicTree tree = new BasicTree(newNode);
		
		/*tree.root.left = new Node(2);
		tree.root.right = new Node(3);*/
		

	}
	
	
	public static void printTree(Node root){
		
		
	}
	
	
	

}

class Node{
	int key;
	Node left;
	Node right;
	
	public Node(int n){
		this.key = n;
		left = null;
		right = null;
		
	}
	
	
	
	
}
