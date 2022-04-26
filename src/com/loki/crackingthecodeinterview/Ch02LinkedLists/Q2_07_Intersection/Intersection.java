package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_07_Intersection;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;


public class Intersection {
    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedList list1 = LinkedList.getPopulatedLinkedList(vals);
        Node head1 = list1.getHead();

        int[] vals2 = {12, 14, 15};
        LinkedList list2 = LinkedList.getPopulatedLinkedList(vals2);
        Node head2 = list2.getHead();

        head2.next.next = head1.next.next.next.next;
        LinkedList.printList(head1);
        LinkedList.printList(head2);
        Node intersectionNode = findIntersection(head1, head2);
        LinkedList.printList(intersectionNode);
    }

    private static Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        if (head1 == head2) return head1;
        int length1 = LinkedList.getLinkedListLength(head1);
        int length2 = LinkedList.getLinkedListLength(head2);
        if (length1 < length2) {
            head2 = getSamePositionNode(head2, length2 - length1);
        } else {
            head1 = getSamePositionNode(head1, length1 - length2);
        }
        while (head1.next != null && head2.next != null) {
            if (head1.next == head2.next) {
                return head1.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    private static Node getSamePositionNode(Node head2, int lengthDiff) {
        while (head2 != null && lengthDiff > 0) {
            head2 = head2.next;
            lengthDiff--;
        }
        return head2;
    }
}
