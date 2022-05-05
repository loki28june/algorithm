package com.loki.randomproblems.tree;

public class LevelOrderTraversal {
    private static void levelOrder(Node root) {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
        }
    }

    private static void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.key);
        }
        if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh > rh) {
            return lh + 1;
        }
        return rh + 1;
    }

    public static void main(String[] args) {
        BasicTree tree = new BasicTree(1);
        tree.getRoot().left = new Node(2);
        tree.getRoot().right = new Node(3);
        tree.getRoot().left.left = new Node(4);
        tree.getRoot().left.right = new Node(5);
        levelOrder(tree.getRoot());
    }
}


