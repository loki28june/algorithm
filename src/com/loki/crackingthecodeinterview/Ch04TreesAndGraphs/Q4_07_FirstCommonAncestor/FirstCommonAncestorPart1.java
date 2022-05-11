package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_07_FirstCommonAncestor;

import com.loki.randomproblems.tree.BinaryTree;
import com.loki.randomproblems.tree.BinaryTree.TreeNode;

public class FirstCommonAncestorPart1 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.createBinaryTree();
        TreeNode ancestor = findCommonAncestor(treeNode.getLeft().getLeft(), treeNode.getRight().getRight());
        System.out.println(ancestor.getData());
    }

    private static TreeNode findCommonAncestor(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        TreeNode first = depth(p) - depth(q) > 0 ? q : p;
        TreeNode second = depth(p) - depth(q) > 0 ? p : q;
        second = goUpByDifference(second, Math.abs(depth(p) - depth(q)));
        while (first != second && first != null && second != null) {
            first = first.getParent();
            second = second.getParent();
        }
        if (first == null || second == null) {
            return null;
        }
        return first;
    }

    private static int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.getParent();
            depth++;
        }
        return depth;
    }

    private static TreeNode goUpByDifference(TreeNode p, int diff) {
        while (diff > 0 && p != null) {
            p = p.getParent();
            diff--;
        }
        return p;
    }


}
