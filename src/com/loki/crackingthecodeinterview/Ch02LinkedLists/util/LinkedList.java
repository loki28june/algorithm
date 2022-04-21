package com.loki.crackingthecodeinterview.Ch02LinkedLists.util;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(data));
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.setNext(head);
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData() == data) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }
}
