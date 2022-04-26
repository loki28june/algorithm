package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

public class QueueWithLinkedList {
    private static Node front = null, rear = null;

    boolean isEmpty() {
        return front == null || rear == null;
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (front == null && rear == null) {
            front = node;
            rear = node;
        }
        rear.next = node;
        rear = node;
    }

    public int dequeue() {
        int popped = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Underflow");
            return popped;
        }
        if (front == rear) {
            popped = front.data;
            front = null;
            rear = null;
            return popped;
        }
        popped = front.data;
        front = front.next;
        return popped;
    }

    public int peek() {
        int popped = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Underflow");
            return popped;
        }
        return front.data;
    }

    public void print() {
        LinkedList.printList(front);
    }

    public static void main(String[] args) {
        QueueWithLinkedList queue = new QueueWithLinkedList();
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(6);
        queue.print();
        System.out.println(queue.dequeue() + " popped ");
        System.out.println(queue.dequeue() + " popped ");
        System.out.println(queue.peek() + " peeked ");
        queue.print();
    }
}
