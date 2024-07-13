package com.loki.basic.dsa.linkedlist;

public class PairWiseSwap {
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

	public void printList() {
	
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void swapElements() {
		Node temp = head;
		while (temp != null && temp.next != null) {
			int t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;

			temp = temp.next.next;
		}
	}

	public static void main(String[] args) {
		PairWiseSwap ps = new PairWiseSwap();
		ps.insert(3);
		ps.insert(6);
		ps.insert(1);
		ps.insert(7);
		ps.insert(2);
		ps.insert(9);
		ps.printList();
		ps.swapElements();
		ps.printList();

	}

}
