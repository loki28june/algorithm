package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_04_Queue_via_Two_Stacks;


import java.util.Stack;

public class MyQueue<T> {
    private Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        this.stackNewest = new Stack<T>();
        this.stackOldest = new Stack<T>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void enqueue(T data) {
        stackNewest.push(data);
    }

    public T dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public void printValues() {
        if (stackNewest.isEmpty() && stackOldest.isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        stackNewest.stream().forEach(System.out::println);
        stackOldest.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.printValues();
    }
}
