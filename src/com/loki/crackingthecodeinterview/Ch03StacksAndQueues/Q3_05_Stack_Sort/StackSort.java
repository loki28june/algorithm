package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_05_Stack_Sort;

import java.util.Stack;

public class StackSort extends Stack<Integer> {

    public void sort(Stack<Integer> stack) {
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }

    public static void main(String[] args) {
        StackSort stackSort = new StackSort();
        stackSort.push(10);
        stackSort.push(5);
        stackSort.push(3);
        stackSort.push(8);
        stackSort.push(12);
        stackSort.push(1);
        stackSort.stream().forEach(System.out::println);
        stackSort.sort(stackSort);
        System.out.println("================");
        stackSort.stream().forEach(System.out::println);
    }
}
