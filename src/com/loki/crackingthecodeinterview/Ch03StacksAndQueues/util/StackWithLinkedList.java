package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.util;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

public class StackWithLinkedList {
    private static Node top = null;

    boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public int pop() {
        int popped = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Stack underflow");
        }
        popped = top.data;
        top = top.next;
        return popped;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack overflow");
            return Integer.MIN_VALUE;
        }
        return top.data;
    }

    public void print() {
        LinkedList.printList(top);
    }

    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.print();
        System.out.println(stack.pop() + " popped ");
        System.out.println(stack.pop() + " popped ");
        System.out.println(stack.peek() + " peeked ");
        stack.print();
    }
}
