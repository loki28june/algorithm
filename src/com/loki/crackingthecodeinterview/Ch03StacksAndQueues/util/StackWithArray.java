package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

public class StackWithArray {
    public static final int MAX = 1000;
    private int top;
    private int[] stack = new int[MAX];

    StackWithArray() {
        top = -1;
    }

    boolean isEmpty() {
        return top < 0;
    }

    public boolean push(int data) {
        if (top >= MAX - 1) {
            System.out.println("Stack overflow");
            return false;
        }
        stack[++top] = data;
        System.out.println(data + " pushed into stack");
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top];
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(" " + stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithArray stack = new StackWithArray();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.print();
        System.out.print(stack.pop() + " popped ");
        System.out.print(stack.pop() + " popped ");
        System.out.print(stack.peek() + " peeked ");
        stack.print();
    }
}
