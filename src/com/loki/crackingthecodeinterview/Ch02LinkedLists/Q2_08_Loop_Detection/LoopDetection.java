package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_08_Loop_Detection;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

public class LoopDetection {
    public static void main(String[] args) {
        LinkedList list = LinkedList.getPopulatedLinkedList(1, 2, 3, 4, 5);
        //create loop
        list.getHead().next.next.next.next.next = list.getHead().next.next;
        System.out.println(findLoopBeginning(list).data);
    }

    private static Node findLoopBeginning(LinkedList list) {
        if (list.getHead() == null) return null;
        Node slow = list.getHead(), fast = list.getHead();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // collision point
            }
        }
        if (fast == null || fast.next == null) {
            return null; // loop does not exist
        }
        slow = list.getHead();
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
