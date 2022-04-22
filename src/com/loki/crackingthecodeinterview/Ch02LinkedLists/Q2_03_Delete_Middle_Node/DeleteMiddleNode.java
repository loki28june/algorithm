package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_03_Delete_Middle_Node;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.Node;

import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.getPopulatedLinkedList;
import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.printList;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList ll = getPopulatedLinkedList(4, 1, 3, 4, 5, 7);
        printList(ll.getHead());
        deleteMiddleNode(ll.getHead().getNext().getNext());
        printList(ll.getHead());
    }

    public static boolean deleteMiddleNode(Node middle) {
        if (middle == null || middle.getNext() == null) {
            return false; // failure
        }
        // override the data of current node which needs to be deleted with next node
        // and delete the next node
        Node nextNode = middle.getNext();
        middle.setData(nextNode.getData());
        middle.setNext(nextNode.getNext());
        return true;
    }
}
