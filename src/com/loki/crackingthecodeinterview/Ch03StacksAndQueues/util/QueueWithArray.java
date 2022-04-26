package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

public class QueueWithArray {
    public static final int MAX = 10;
    private int[] queue = new int[MAX];
    int front = -1, rear = -1;

    public boolean isEmpty() {
        return front == -1 || rear == -1;
    }

    public boolean isFull() {
        return rear == MAX - 1;
    }

    public boolean enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full, Overflow");
            return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = data;
            return true;
        }
        queue[++rear] = data;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, Underflow");
            return 0;
        }
        if (front == rear) {
            int dequeued = queue[front];
            front = -1;
            rear = -1;
            return dequeued;
        }
        return queue[front++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return 0;
        }
        return queue[front];
    }

    public void print() {
        if (front == -1 || rear == -1) {
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(" " + queue[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray();
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(6);
        queue.print();
        System.out.print(queue.dequeue() + " dequeued ");
        System.out.print(queue.dequeue() + " dequeued ");
        System.out.print(queue.peek() + " peeked ");
        System.out.println();
        queue.print();
    }
}
