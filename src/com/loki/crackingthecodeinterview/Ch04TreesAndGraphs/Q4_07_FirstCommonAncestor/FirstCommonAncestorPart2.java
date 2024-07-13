package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_07_FirstCommonAncestor;

import com.loki.basic.dsa.tree.BinaryTree;
import com.loki.basic.dsa.tree.BinaryTree.TreeNode;

public class FirstCommonAncestorPart2 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree();
        TreeNode ancestor = findCommonAncestor(root, root.getLeft().getLeft(), root.getRight().getRight());
        System.out.println(ancestor.getData());
    }

    private static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // move up to the p's level and try to find the q in sibling's subtree if found return parent
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        TreeNode parent = p.getParent();
        TreeNode sibling = getSibling(p);
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.getParent();
        }
        return parent;
    }

    private static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }

    private static TreeNode getSibling(TreeNode p) {
        if (p == null || p.getParent() == null) {
            return null;
        }
        return p.getParent().getLeft() == p ? p.getParent().getRight() : p.getParent().getLeft();
    }
}
