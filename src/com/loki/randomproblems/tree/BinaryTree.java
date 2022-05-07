package com.loki.randomproblems.tree;

import java.util.Stack;

public class BinaryTree {
    public static class TreeNode {
        private int data;
        private TreeNode left = null;
        private TreeNode right = null;

        public int getData() {
            return data;
        }

        public TreeNode getLeft() {
            return left;
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
        TreeNode node1 = new TreeNode(25);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(20);
        TreeNode node6 = new TreeNode(28);
        TreeNode node7 = new TreeNode(35);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
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
