package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_01_Remove_Dups;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.Node;

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
            if (trackDuplicate.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                trackDuplicate.add(current.getData());
                previous = current;
            }
            current = current.getNext();
        }
        return head;
    }

    // With No extra space/buffer O(n) time and O(1) space
    private static Node removeDuplicatesWithNoSpace(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.getNext() != null) {
                if (current.getData() == runner.getNext().getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        return head;
    }
}
