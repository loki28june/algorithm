package com.loki.crackingthecodeinterview.Ch02LinkedLists.util;

public class Node {
    private int data;
    private Node next;

    // Constructor
    Node(int d) {
        data = d;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
