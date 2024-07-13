package com.loki.neetcode150;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        int carry =0;
        while(l1 != null && l2!= null){
            int sum = l1.val + l2.val + carry;
            if(sum / 10 == 0){
                ListNode temp = new ListNode(sum);
                insertToList(l3,temp);
                carry = 0;
            }
            else{
                ListNode temp = new ListNode(sum%10);
                insertToList(l3,temp);
                carry = 1;
            }
            l1= l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            int sum = carry + l1.val;
            if(sum / 10 == 0){
                ListNode temp = new ListNode(sum);
                insertToList(l3,temp);
                carry = 0;
            }
            else{
                ListNode temp = new ListNode(sum%10);
                insertToList(l3,temp);
                carry = 1;
            }
            l1 = l1.next;
        }
        if(l2 != null){
            int sum = carry + l2.val;
            if(sum / 10 == 0){
                ListNode temp = new ListNode(sum);
                insertToList(l3,temp);
                carry = 0;
            }
            else{
                ListNode temp = new ListNode(sum%10);
                insertToList(l3,temp);
                carry = 1;
            }
            l2 = l2.next;
        }
        if(carry == 1){
            ListNode temp = new ListNode(1);
            insertToList(l3,temp);
        }
        return l3;
    }

    private void insertToList(ListNode l3, ListNode temp) {
        if (l3 == null) {
            l3 = temp;
        } else {
            ListNode tvs = l3;
            while (tvs.next != null) {
                tvs = tvs.next;
            }
            tvs.next = temp;
        }
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
