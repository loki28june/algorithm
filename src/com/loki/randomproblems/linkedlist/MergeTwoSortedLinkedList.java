package com.loki.randomproblems.linkedlist;

public class MergeTwoSortedLinkedList {
	Node head;
	Node head2;

	public void push(int n) {
		if (head == null) {
			head = new Node(n);
		}

		Node temp = new Node(n);
		temp.next = head;
		head = temp;

	}

	public void deleteNode(int key) {
		Node temp = head, prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;
		prev.next = temp.next;
	}

	public void deleteAtPosition(int pos) {
		Node temp = head, prev = null;
		int count = 1;
		if (temp != null && pos == 1) {
			head = temp.next;
			return;
		}

		while (temp != null && count != pos) {
			prev = temp;
			temp = temp.next;
			count++;
		}
		// If position is more than number of ndoes
		if (temp == null || temp.next == null)
			return;
		prev.next = temp.next;
	}

	public void insertAfter(Node prev, int n) {
		if (head == null && prev == null)
			return;

		Node temp = new Node(n);
		temp.next = prev.next;
		prev.next = temp;
	}

	public void append(int n) {
		if (head == null) {
			head = new Node(n);
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node(n);
	}
	
	public void append2(int n) {
		if (head2 == null) {
			head2 = new Node(n);
		}

		Node current = head2;
		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node(n);
	}

	public void print(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();

	}

	public int nthNode(int n) {
		Node ref = head, main = head;
		int count = 0;

		while (ref != null && count < n) {
			ref = ref.next;
			count++;
		}

		if (ref == null) {
			System.out.println("n is greater than length");
			return -1;
		}

		while (ref != null) {
			ref = ref.next;
			main = main.next;

		}

		return main.data;

	}

	public int nthNodeMethod1(int n) {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		int count = 1;
		while (count < (length - n + 1) && temp != null) {
			temp = temp.next;
			count++;

		}
		return temp.data;
	}

	public Node merge2Lists(Node l1, Node l2) {
		Node mergeHead = null;
		Node list1 = l1, list2 = l2;
		if (list1.data < list2.data) {
			mergeHead = list1;
			list1 = list1.next;
		} else {
			mergeHead = list2;
			list2 = list2.next;

		}
		Node result = mergeHead;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				result.next = list1;
				result = result.next;
				list1 = list1.next;
			} else {
				result.next = list2;
				result = result.next;
				list2 = list2.next;
			}

		}

		if (list1 == null) {
			while (list2 != null) {
				result.next = list2;
				list2 = list2.next;
				result = result.next;
			}
		}

		if (list2 == null) {

			while (list1 != null) {
				result.next = list1;
				list1 = list1.next;
				result = result.next;
			}

		}
		return mergeHead;
	}

	public static void main(String[] args) {
		MergeTwoSortedLinkedList ll = new MergeTwoSortedLinkedList();
		ll.head = new Node(1);
		ll.append(3);
		ll.append(5);
		ll.append(7);
		ll.append(9);
		ll.print(ll.head);
		
		ll.head2 = new Node(2);
		ll.append2(4);
		ll.append2(6);
		ll.append2(8);
		ll.append2(10);
		ll.print(ll.head2);
		
		Node headMerged = ll.merge2Lists(ll.head, ll.head2);
		ll.print(headMerged);
		

	}

}
