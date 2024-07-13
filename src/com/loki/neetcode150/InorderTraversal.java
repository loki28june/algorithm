package com.loki.neetcode150;

public class InorderTraversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode rootOne = new TreeNode(1);
        rootOne.left = new TreeNode(2);
        rootOne.right = new TreeNode(2);
        rootOne.left.left = new TreeNode(3);
        rootOne.left.right = new TreeNode(4);
        rootOne.right.left = new TreeNode(4);
        rootOne.right.right = new TreeNode(3);
        TreeNode inverted = invertTree(rootOne);
        System.out.println(isSameTree(rootOne,inverted));
    }

    private static boolean isSameTree(TreeNode rootOne, TreeNode inverted) {
        if(rootOne == null && inverted == null){
            return true;
        }
        if(rootOne == null || inverted == null){
            return false;
        }
        if(rootOne.val != inverted.val){
            return false;
        }
        return isSameTree(rootOne.left,inverted.left) && isSameTree(rootOne.right,inverted.right);
    }

    private static TreeNode invertTree(TreeNode rootOne) {
        if(rootOne == null){
            return null;
        }
        if(rootOne.left != null || rootOne.right != null){
            TreeNode temp = rootOne.left;
            rootOne.left = rootOne.right;
            rootOne.right = temp;
        }
        invertTree(rootOne.left);
        invertTree(rootOne.right);
        return rootOne;
    }


    private static void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left); // left
        System.out.print(root.val+" "); // node
        inorderTraversal(root.right); // right
    }
}
