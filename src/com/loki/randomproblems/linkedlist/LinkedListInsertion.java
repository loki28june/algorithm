package com.loki.randomproblems.linkedlist;

public class LinkedListInsertion {
	Node head;

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
	
	public void deleteAtPosition(int pos){
		Node temp = head, prev = null;
		int count = 1;
		if (temp != null && pos == 1) {
			head = temp.next;
			return;
		}

		while (temp != null && count != pos) {
			prev = temp;
			temp = temp.next;
			count ++;
		}
		// If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;
		prev.next = temp.next;
	}

	public void insertAfter(Node prev,int n) {
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

	public static void main(String[] args) {
		LinkedListInsertion ll = new LinkedListInsertion();
		ll.head = new Node(10);
		ll.push(12);
		ll.insertAfter(ll.head,20);
		ll.append(28);
		//ll.deleteNode(10);
		ll.deleteAtPosition(3);
		ll.print();

	}

}
