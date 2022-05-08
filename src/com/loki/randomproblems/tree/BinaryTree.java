package com.loki.randomproblems.tree;

import java.util.Stack;

public class BinaryTree {

    public static class TreeNode {
        private int data;
        private TreeNode left = null;
        private TreeNode right = null;
        private TreeNode parent = null;
        private boolean visited = false;

        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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
    public TreeNode createBinaryTree() {
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(17);
        TreeNode node7 = new TreeNode(25);
        TreeNode node8 = new TreeNode(6);
        TreeNode node9 = new TreeNode(11);
        TreeNode node10 = new TreeNode(16);
        TreeNode node11 = new TreeNode(27);
        node1.left = node2;
        node1.right = node3;
        node1.parent = null;
        node2.left = node4;
        node2.right = node5;
        node2.parent = node1;
        node3.left = node6;
        node3.right = node7;
        node3.parent = node1;
        node4.left = node8;
        node4.parent = node2;
        node5.left = node9;
        node5.parent = node2;
        node6.left = node10;
        node6.parent = node3;
        node7.right = node11;
        node7.parent = node3;
        node8.parent = node4;
        node9.parent = node5;
        node10.parent = node6;
        node11.parent = node7;
        return node1;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // pushing the root node into the stack

        while (!stack.isEmpty()) {
            // print the root node data
            TreeNode n = stack.pop();
            System.out.print(" " + n.data);

            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }

    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.data);
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
