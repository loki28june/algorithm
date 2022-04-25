package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_04_Partition;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.printList;

public class Partition {
    public static void main(String[] args) {
        LinkedList ll = LinkedList.getPopulatedLinkedList(9, 3, 5, 8, 5, 10, 2, 1, 0);
        printList(ll.getHead());
        printList(partition(5, ll.getHead()));
    }

    public static Node partition(int pivot, Node head) {
        LinkedList leftList = new LinkedList();
        LinkedList rightList = new LinkedList();
        LinkedList finalList = new LinkedList();
        Node current = head;
        while (current != null) {
            if (current.data < pivot) {
                leftList.append(current.data);
            } else {
                rightList.append(current.data);
            }
            current = current.next;
        }
        Node currentLeft = leftList.getHead();
        while (currentLeft != null) {
            finalList.append(currentLeft.data);
            currentLeft = currentLeft.next;
        }
        Node currentRight = rightList.getHead();
        while (currentRight != null) {
            finalList.append(currentRight.data);
            currentRight = currentRight.next;
        }
        return finalList.getHead();
    }

}
