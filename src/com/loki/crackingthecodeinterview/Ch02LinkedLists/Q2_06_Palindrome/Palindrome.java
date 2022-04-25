package com.loki.crackingthecodeinterview.Ch02LinkedLists.Q2_06_Palindrome;

import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList;
import com.loki.crackingthecodeinterview.Ch02LinkedLists.util.LinkedList.Node;

public class Palindrome {
    private static final int[] listItems = {1, 2, 3, 2, 1};

    public static void main(String[] args) {
        LinkedList list = LinkedList.getPopulatedLinkedList(listItems);
        System.out.println(isPalindrome(list.getHead()));
    }

    private static boolean isPalindrome(Node originalHead) {
        Node reverseHead = LinkedList.reverseAndClone(originalHead);
        return isListsEqual(originalHead, reverseHead);
    }

    private static boolean isListsEqual(Node headOne, Node headTwo) {
        while (headOne != null && headTwo != null) {
            if (headOne.data != headTwo.data) {
                return false;
            }
            headOne = headOne.next;
            headTwo = headTwo.next;
        }
        return headOne == null && headTwo == null;
    }
}
