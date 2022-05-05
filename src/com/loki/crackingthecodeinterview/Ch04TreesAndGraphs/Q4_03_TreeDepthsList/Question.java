package com.loki.crackingthecodeinterview.Ch04TreesAndGraphs.Q4_03_TreeDepthsList;

import com.loki.randomproblems.tree.BinaryTree;
import com.loki.randomproblems.tree.BinaryTree.TreeNode;

import java.util.*;

public class Question {

    public void createLevelWiseLinkedListViaDfs(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        // level is seen first time
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelWiseLinkedListViaDfs(root.getLeft(), lists, level + 1);
        createLevelWiseLinkedListViaDfs(root.getRight(), lists, level + 1);
    }

    public List<LinkedList<TreeNode>> createLevelWiseLinkedListViaBfs(TreeNode root) {
        if (root == null) return null;
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.getLeft() != null) {
                    current.add(parent.getLeft());
                }
                if (parent.getRight() != null) {
                    current.add(parent.getRight());
                }
            }
        }
        return result;
    }

    public static void printResult(List<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                System.out.print(" " + ((TreeNode) i.next()).getData());
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = binaryTree.createBinaryTree();
        Question question = new Question();
        List<LinkedList<TreeNode>> result1 = new ArrayList<>();
        question.createLevelWiseLinkedListViaDfs(treeNode, result1, 0);
        printResult(result1);
        List<LinkedList<TreeNode>> result2 = question.createLevelWiseLinkedListViaBfs(treeNode);
        printResult(result2);
    }
}


