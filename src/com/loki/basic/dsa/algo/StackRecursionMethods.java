package com.loki.basic.dsa.algo;


import java.util.Stack;

public class StackRecursionMethods {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(3);
        s.push(9);
        s.push(2);
        s.push(6);
        s.forEach(System.out::print);
        System.out.println();
        int k = s.size()/2 + 1; // middle element calculation
        deleteMiddleElement(s,k);
        s.forEach(System.out::print);
    }

    private static void sort(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return; // BC
        }
        int last = stack.pop(); //
        sort(stack); // hypothesis , removing last element and assuming it will work fine for lesser input
        insert(stack, last);
    }

    private static void insert(Stack<Integer> stack, int last) {
        if (stack.isEmpty() || stack.peek() <= last) {
            stack.push(last); // BC
            return;
        }
        int lastElement = stack.pop();
        insert(stack, last); // hypothesis
        stack.push(lastElement); // induction
    }

    private static void deleteMiddleElement(Stack<Integer> stack,int k){
        if(stack.empty()) return;
        if (k == 1) {
            stack.pop(); // BC
            return;
        }
        int lastElement = stack.pop();
        deleteMiddleElement(stack,k-1); // hypothesis
        stack.push(lastElement);
    }
}
