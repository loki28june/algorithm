package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_05_CheckBST;

import com.loki.randomproblems.tree.BinaryTree;
import com.loki.randomproblems.tree.BinaryTree.TreeNode;

public class CheckBST {
    public static void main(String[] args) {
        TreeNode treeNode = new BinaryTree().createBinaryTree();
        System.out.println(checkBST(treeNode, null, null));
    }

    private static boolean checkBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.getData() <= min) // for right subtree
                || (max != null && node.getData() > max)) // for left subtree
        {
            return false;
        }
        if (!checkBST(node.getLeft(), min, node.getData())
                || !checkBST(node.getRight(), node.getData(), max)) {
            return false;
        }
        return true;
    }

    private static boolean checkBSTMyVersion(TreeNode treeNode, int min_range, int max_range) {
        if (treeNode == null) return true;
        boolean isLeftSubTreeBinarySearch = checkBSTMyVersion(treeNode.getLeft(), Integer.MIN_VALUE, treeNode.getData());
        boolean isRightSubTreeBinarySearch = checkBSTMyVersion(treeNode.getRight(),
                treeNode.getData() + 1, Integer.MAX_VALUE);

        if (isLeftSubTreeBinarySearch && isRightSubTreeBinarySearch) {
            if (treeNode.getLeft() != null && treeNode.getRight() != null) {
                return treeNode.getLeft().getData() >= min_range && treeNode.getLeft().getData() <= max_range
                        && treeNode.getRight().getData() >= min_range && treeNode.getRight().getData() <= max_range;
            }
            if (treeNode.getLeft() == null && treeNode.getRight() == null) {
                return true;
            }
            if (treeNode.getLeft() != null) {
                return treeNode.getLeft().getData() >= min_range && treeNode.getLeft().getData() <= max_range;
            }
            if (treeNode.getRight() != null) {
                return treeNode.getRight().getData() >= min_range && treeNode.getRight().getData() <= max_range;
            }
        }
        return false;
    }
}
