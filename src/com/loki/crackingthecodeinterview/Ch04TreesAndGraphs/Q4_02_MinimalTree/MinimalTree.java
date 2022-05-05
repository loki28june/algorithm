package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_02_MinimalTree;

import static com.loki.randomproblems.tree.BinaryTree.*;

public class MinimalTree {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.createBinarySearchTree(sortedArray, 0, sortedArray.length - 1);
        minimalTree.inOrderTraversal(root);
    }

    public TreeNode createBinarySearchTree(int[] array, int start, int end) {
        if (start == end) {
            return new TreeNode(array[start]);
        }
        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode(array[middle]);
        treeNode.setLeft(createBinarySearchTree(array, start, middle - 1));
        treeNode.setRight(createBinarySearchTree(array, middle + 1, end));
        return treeNode;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.println(node.getData());
        inOrderTraversal(node.getRight());
    }
}
