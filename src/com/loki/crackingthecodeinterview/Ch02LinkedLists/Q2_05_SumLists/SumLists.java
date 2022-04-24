package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_05_SumLists;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.Node;

import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.getLinkedListLength;
import static com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.printList;

/**
 * This code calculate sum of two lists if digits are stored in reverse order as well as in forward order.
 */
public class SumLists {
    private static LinkedList getReverseOrderDigitsSum(Node head1, Node head2) {
        LinkedList result = new LinkedList();
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = head1.getData() + head2.getData();
            result.append(sum % 10 + carry);
            carry = (sum / 10 > 0) ? 1 : 0;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        if (head1 != null) {
            result.append(head1.getData() + carry);
        } else if (head2 != null) {
            result.append(head2.getData() + carry);
        } else if (carry != 0) {
            result.append(carry);
        }
        return result;
    }

    private static LinkedList getForwardOrderDigitsSum(LinkedList list1, LinkedList list2) {
        int count1 = getLinkedListLength(list1.getHead());
        int count2 = getLinkedListLength(list2.getHead());
        if (count1 > count2) {
            padListWithZeros(list2, count1 - count2);
        } else if (count2 > count1) {
            padListWithZeros(list1, count2 - count1);
        }
        Node head1 = LinkedList.reverse(list1.getHead());
        Node head2 = LinkedList.reverse(list2.getHead());
        LinkedList resultList = getReverseOrderDigitsSum(head1, head2);
        Node returnHead = LinkedList.reverse(resultList.getHead());
        return new LinkedList(returnHead);
    }

    private static void padListWithZeros(LinkedList list2, int padLength) {
        while (padLength > 0) {
            list2.prepend(0);
            padLength--;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = LinkedList.getPopulatedLinkedList(9, 7, 8);
        LinkedList list2 = LinkedList.getPopulatedLinkedList(6, 8, 5);
        LinkedList result1 = getReverseOrderDigitsSum(list1.getHead(), list2.getHead());
        printList(result1.getHead());

        LinkedList list3 = LinkedList.getPopulatedLinkedList(6, 1, 7, 0);
        LinkedList list4 = LinkedList.getPopulatedLinkedList(2, 9, 5);
        LinkedList result2 = getForwardOrderDigitsSum(list3, list4);
        printList(result2.getHead());
    }
}
