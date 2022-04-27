package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

public class StackWithArray {
    public int min;
    public int max;
    private int top;
    private int[] stack;

    public StackWithArray(int top, int min, int max) {
        this.top = top;
        this.min = min;
        this.max = max;
        stack = new int[max];
    }

    boolean isEmpty() {
        return top < min;
    }

    public boolean push(int data) {
        if (top >= max - 1) {
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
        for (int i = top; i >= min; i--) {
            System.out.print(" " + stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithArray stack = new StackWithArray(-1,0,9);
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
