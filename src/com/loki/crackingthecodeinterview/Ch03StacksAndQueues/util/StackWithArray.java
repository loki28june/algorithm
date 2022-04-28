package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

public class StackWithArray {
    public int min;
    public int max;
    private int top;
    private int[] stack;

    public StackWithArray(int arr[], int min, int max) {
        this.top = min-1;
        this.min = min;
        this.max = max;
        stack = arr;
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
        int[] arr = new int[10];
        StackWithArray stack = new StackWithArray(arr,0,9);
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
