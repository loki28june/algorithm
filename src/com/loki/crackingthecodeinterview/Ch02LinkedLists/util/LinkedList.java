package com.loki.crackingthecodeinterview.Ch02LinkedLists.util;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    public static class Node {
        int data;
        Node next;

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

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void printList(Node head){
        if(head == null) return;
        Node n = head;
        while(n !=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
}
