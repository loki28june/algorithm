package com.loki.basic.dsa.linkedlist;

public class ReverseLinkedList {
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
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(data);
	}

	public int middleElement() {
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

	public void print(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();

	}

	public Node reverse(Node head) {
		if (head == null) {
			return null;
		}

		Node prev = null, curr = head, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		return prev;

	}

	public static void main(String[] args) {
		ReverseLinkedList lm = new ReverseLinkedList();
		lm.insert(3);
		lm.insert(6);
		lm.insert(1);
		lm.insert(7);
		lm.insert(2);
		lm.print(lm.head);
		Node head = lm.reverse(lm.head);
		lm.print(head);
		

	}

}
