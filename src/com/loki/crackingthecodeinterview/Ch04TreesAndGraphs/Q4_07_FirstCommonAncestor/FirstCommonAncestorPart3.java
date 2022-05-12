package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_07_FirstCommonAncestor;

import com.loki.randomproblems.tree.BinaryTree;
import com.loki.randomproblems.tree.BinaryTree.TreeNode;

public class FirstCommonAncestorPart3 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree();
        TreeNode ancestor = findCommonAncestor(root, root.getLeft().getLeft(), root.getRight().getRight());
        System.out.println(ancestor.getData());
    }

    private static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // check if both p and q are present in tree
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    private static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pIsInLeft = covers(root.getLeft(), p);
        boolean qIsInLeft = covers(root.getLeft(), q);
        if (pIsInLeft != qIsInLeft) {
            return root;
        }
        TreeNode childSide = pIsInLeft ? root.getLeft() : root.getRight();
        return ancestorHelper(childSide, p, q);
    }

    private static boolean covers(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }
}
