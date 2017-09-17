package com.loki.linkedlist;

public class LengthLinkedlistIterative {
	Node head;

	public void push(int n) {
		if (head == null) {
			head = new Node(n);
		}

		Node temp = new Node(n);
		temp.next = head;
		head = temp;

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

	public void print() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();

	}

	public int lengthIterative() {
		int len = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		return len;
	}

	public int lengthRecursive(Node head) {
		if (head == null)
			return 0;

		return (1 + lengthRecursive(head.next));
	}

	public static void main(String[] args) {
		LengthLinkedlistIterative ll = new LengthLinkedlistIterative();
		ll.head = new Node(10);
		ll.push(12);
		ll.insertAfter(ll.head, 20);
		ll.append(28);
		// ll.deleteNode(10);
		// ll.deleteAtPosition(3);
		ll.print();
		System.out.println(ll.lengthIterative());
		System.out.println(ll.lengthRecursive(ll.head));

	}

}
