package com.loki.linkedlist;

public class LinkedListMiddle {
	private Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}

	public void insert(int data) {
		if (head == null)
			head = new Node(data);

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(data);
	}

	public int middleElement(Node head) {
		Node fast = head;
		Node slow = head;

		if (head == null)
			return -1;

		while (fast != null && fast.next != null) {
			fast = fast.next;
			fast = fast.next;

			slow = slow.next;
		}

		return slow.data;
	}

	public static void main(String[] args) {
		LinkedListMiddle lm = new LinkedListMiddle();
		lm.insert(3);
		lm.insert(6);
		lm.insert(1);
		lm.insert(7);
		lm.insert(2);
		
		System.out.println("middle of linkedlist=>" +lm.middleElement(lm.head));

	}

}
