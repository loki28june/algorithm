package com.loki.basic.dsa.recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peek());
        sort(stack);
        System.out.println(stack.peek());
    }

    private static void sort(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    private static void insert(Stack<Integer> stack, int top) {
        if (stack.isEmpty() || top >= stack.peek()) {
            stack.push(top);
            return;
        }
        int currentTop = stack.pop();
        insert(stack, top);
        stack.push(currentTop);
    }
}
