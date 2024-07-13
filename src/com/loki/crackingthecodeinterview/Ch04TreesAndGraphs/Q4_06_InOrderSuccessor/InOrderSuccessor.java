package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_06_InOrderSuccessor;

import com.loki.basic.dsa.tree.BinaryTree;
import com.loki.basic.dsa.tree.BinaryTree.TreeNode;

public class InOrderSuccessor {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.createBinaryTree();
        TreeNode inOrderSuccessor = findInOrderSuccessor(treeNode.getLeft().getRight());
        if (inOrderSuccessor == null) {
            System.out.println("right most node");
            return;
        }
        System.out.println(inOrderSuccessor.getData());
    }

    private static TreeNode findInOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return leftMostChild(node.getRight());
        }
        if (isParentVisitedInInOrder(node)) {
            while (isParentVisitedInInOrder(node)) {
                node = node.getParent();
            }
        }
        return node.getParent();
    }

    private static TreeNode leftMostChild(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private static boolean isParentVisitedInInOrder(TreeNode node) {
        if (node.getParent() != null && node == node.getParent().getRight()) {
            return true;
        }
        return false;
    }
}
