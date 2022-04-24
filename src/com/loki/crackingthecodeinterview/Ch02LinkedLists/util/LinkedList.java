package com.loki.crackingthecodeinterview.Ch02LinkedLists.util;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
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

    public static LinkedList getPopulatedLinkedList(int... arr) {
        LinkedList ll = new LinkedList();
        for (int i : arr) {
            ll.append(i);
        }
        return ll;
    }

    public static void printList(Node head) {
        if (head == null) return;
        Node n = head;
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = n.getNext();
        }
        System.out.println("\n" + "=====================");
    }

    public static Node reverse(Node head) {
        Node prev = null, next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        return prev;
    }

    public static int getLinkedListLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }
}
