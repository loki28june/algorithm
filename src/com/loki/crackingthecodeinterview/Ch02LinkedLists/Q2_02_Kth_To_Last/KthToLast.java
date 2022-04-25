package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_02_Kth_To_Last;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.getPopulatedLinkedList;

public class KthToLast {
    public static void main(String[] args) {
        LinkedList ll = getPopulatedLinkedList(4, 1, 3, 4, 5, 1, 8, 6, 2);
        printList(ll.getHead());
        int result = printKthToLast(4, ll.getHead());
        System.out.println(result);
    }

    public static int printKthToLast(int k, Node head) {
        Node current = head, runner = head;
        while (k > 0) {
            if (null == runner) {
                return -1; // out of bound
            }
            runner = runner.next;
            k--;
        }
        while (runner != null) {
            current = current.next;
            runner = runner.next;
        }
        return current.data;
    }

    public static void printList(Node head) {
        if (head == null) return;
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println("\n" + "=====================");
    }
}
