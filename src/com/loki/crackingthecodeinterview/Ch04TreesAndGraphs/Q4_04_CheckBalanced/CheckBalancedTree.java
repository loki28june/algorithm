package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_04_CheckBalanced;

import com.loki.basic.dsa.tree.BinaryTree;
import com.loki.basic.dsa.tree.BinaryTree.TreeNode;

public class CheckBalancedTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree();
        CheckBalancedTree checkBalancedTree = new CheckBalancedTree();
        System.out.println(checkBalancedTree.isTreeBalanced(root));
    }

    private boolean isTreeBalanced(TreeNode treeNode) {
        return checkHeight(treeNode) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) {
            return -1; // base case
        }
        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // Propagate error to the stack calls
        }

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // Propagate error to the stack calls
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
