package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_Kth_To_Last;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.Node;

public class KthToLast {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(4);
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(1);
        ll.append(8);
        ll.append(6);
        ll.append(2);
        printList(ll.getHead());
        int result = printKthToLast(9, ll.getHead());
        System.out.println(result);
    }

    public static int printKthToLast(int k, Node head) {
        Node current = head, runner = head;
        while (k > 0) {
            runner = runner.getNext();
            k--;
        }
        while (runner != null) {
            current = current.getNext();
            runner = runner.getNext();
        }
        return current.getData();
    }

    public static void printList(Node head) {
        if (head == null) return;
        Node n = head;
        while (n != null) {
            System.out.print(n.getData() + " ");
            n = n.getNext();
        }
        System.out.println("\n" + "=====================");
    }
}
