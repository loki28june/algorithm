package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_01_Remove_Dups;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;

import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.getPopulatedLinkedList;
import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.printList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList ll = getPopulatedLinkedList(4, 1, 3, 4, 5);
        printList(ll.getHead());
        Node head = removeDuplicatesWithBuffer(ll.getHead());
        printList(head);
        Node head2 = removeDuplicatesWithNoSpace(ll.getHead());
        printList(head2);
    }

    // With extra space/buffer O(n) time and space
    private static Node removeDuplicatesWithBuffer(Node head) {
        Node current = head;
        Node previous = null;
        Set<Integer> trackDuplicate = new HashSet<>();
        while (current != null) {
            if (trackDuplicate.contains(current.data)) {
                previous.next = current.next;
            } else {
                trackDuplicate.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    // With No extra space/buffer O(n) time and O(1) space
    private static Node removeDuplicatesWithNoSpace(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }
}
