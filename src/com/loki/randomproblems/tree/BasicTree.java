package com.loki.randomproblems.tree;

public class BasicTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BasicTree(int key) {
        this.root = new Node(key);
    }
}

class Node {
    int key;
    Node left;
    Node right;

    public Node(int n) {
        this.key = n;
        left = null;
        right = null;
    }
}
