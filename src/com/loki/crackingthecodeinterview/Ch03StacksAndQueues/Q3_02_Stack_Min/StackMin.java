package com.loki.crackingthecodeinterview.Ch03StacksAndQueues.Q3_02_Stack_Min;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

public class StackMin {
    Node top = null, minimum = null;

    public void push(int data) {
        Node n = new Node(data);
        if (top == null) {
            top = n;
            minimum = n;
            return;
        }
        n.next = top;
        top = n;
        if (n.data < minimum.data) {
            n.next = minimum;
            minimum = n;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Underflow condition");
            return Integer.MIN_VALUE;
        }
        int popped = top.data;
        top = top.next;
        if (popped == minimum.data) {
            minimum = minimum.next;
        }
        return popped;
    }

    public int min() {
        return (minimum != null) ? minimum.data : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(10);
        stackMin.push(12);
        stackMin.push(3);
        stackMin.push(6);
        stackMin.push(8);
        System.out.println(String.format("Current minimum element %s", stackMin.min()));
        stackMin.pop();
        stackMin.pop();
        stackMin.pop();
        System.out.println(String.format("Current minimum element %s", stackMin.min()));
    }
}
