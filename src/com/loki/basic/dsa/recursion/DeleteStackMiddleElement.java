package com.loki.basic.dsa.recursion;

import java.util.Stack;

public class DeleteStackMiddleElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peek());
        deleteMiddleElement(stack);
        System.out.println(stack.peek());
    }
    private static void deleteMiddleElement(Stack<Integer> stack) {

    }
}
