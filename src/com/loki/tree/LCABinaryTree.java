package com.loki.tree;

import java.util.ArrayList;
import java.util.List;



public class LCABinaryTree {
	static Node r;
	 private static List<Integer> path1 = new ArrayList<>();
	    private static List<Integer> path2 = new ArrayList<>();

	static class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = null;
			right = null;
		}

	}
	
	public static void print(int[] ints, int length){
		
		for(int i = 0; i< length; i++){
			System.out.print(ints[i]+" ");
		}
		System.out.println();
		
		
	}
	
	// this fn assumes n1 and n2 are present
	public static Node findLCA(Node root,int n1, int n2){
		if(root == null){
			return null;
		}
		
		if(root.data == n1 || root.data == n2){
			return root;
		}
		
		Node rootLeft = findLCA(root.left, n1, n2);
		Node rootRight = findLCA(root.right, n1, n2);
		
		if(rootLeft != null && rootRight !=null){
			return root;
		}
		
		return (rootRight != null) ? rootRight: rootLeft; 
		
	}

	public static int findLcaInternal(Node root,int n1, int n2) {
		if(!findPath(root,(ArrayList<Integer>) path1,n1) || !findPath(root, (ArrayList<Integer>) path2, n2)){
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
			
			System.out.println((path2.size() > 0) ? "n2 is present" : "n22 is missing");
			return -1;
		}
		
		 int i;
	        for (i = 0; i < path1.size() && i < path2.size(); i++) {
	          //  System.out.println(path1.get(i) + " " + path2.get(i));
	            if (!path1.get(i).equals(path2.get(i)))
	                break;
	        }
	 
	        return path1.get(i-1);
		
	}
	
	public static Node lca2(Node root, int n1, int n2) {
		while (root != null) {
			if (root.data > n1 && root.data > n2) {
				root = root.left;
			} else if (root.data < n1 && root.data < n2) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	 int findLCA(int n1, int n2) {
	        path1.clear();
	        path2.clear();
	        return findLcaInternal(r, n1, n2);
	    }
	
	public static boolean findPath(Node root,ArrayList<Integer> path,int n){
		if(root == null){
			return false;
		}
		
		path.add(root.data);
		
		if(root.data == n){
			return true;
		}
		
		if(root.left != null && findPath(root.left, path, n)){
			return true;
		}
		
		if(root.right != null && findPath(root.right, path, n)){
			return true;
		}
		
		path.remove(path.size() -1);
		
		return false;
	}

	public static void main(String[] args) {
		r = new Node(20);
		r.left = new Node(8);
		r.right = new Node(22);
		r.left.left = new Node(4);
		r.left.right = new Node(12);
		r.left.right.left = new Node(10);
		r.left.right.right = new Node(14);
		LCABinaryTree tree = new LCABinaryTree();
		System.out.println("LCA" + tree.findLCA(20,10));
		
		
		System.out.println("LCA" + tree.findLCA(r, 20, 10).data);
		

		
		
		/*Node ans = lca2(r, 10, 14);
		Node a = lca(r, 10, 22);
		System.out.println(ans.data+" "+ a.data);*/

	}

}
