package com.loki.randomproblems.linkedlist;

public class SwapNodes {
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

	public boolean search(int n) {
		Node temp = head;

		while (temp != null) {
			if (temp.data == n) {
				return true;
			}
			temp = temp.next;
		}

		return false;

	}

	public boolean searchRecursive(int n, Node head) {
		if (head == null)
			return false;

		if (head.data == n)
			return true;

		return searchRecursive(n, head.next);

	}

	public void swapNodes(int n1, int n2) {
		if (head == null)
			return;
		
		if(n1 == n2) return;

		Node curr1 = head, prev1 = null;
		while (curr1 != null && curr1.data != n1) {
			prev1 = curr1;
			curr1 = curr1.next;
		}

		Node curr2 = head, prev2 = null;
		while (curr2 != null && curr2.data != n2) {
			
			prev2 = curr2;
			curr2 = curr2.next;
		}

		if (curr1 == null || curr2 == null) {
			return;
		}

		if(prev1 != null){
			prev1.next = curr2;
		}
		else{
			head = curr2;
		}
		
		if(prev2 != null){
			prev2.next = curr1;
		}
		else{
			head = curr1;
		}
		
		Node temp = curr1.next;
		curr1.next = curr2.next;
		curr2.next = temp;

	}

	public static void main(String[] args) {
		SwapNodes ll = new SwapNodes();
		ll.head = new Node(10);
		ll.push(12);
		ll.insertAfter(ll.head, 20);
		ll.append(28);
		ll.print();
		/*
		 * System.out.println(ll.lengthIterative());
		 * System.out.println(ll.lengthRecursive(ll.head));
		 * System.out.println(ll.search(20));
		 * System.out.println(ll.searchRecursive(20, ll.head));
		 */

		ll.swapNodes(12, 10);
		ll.print();

	}

}
