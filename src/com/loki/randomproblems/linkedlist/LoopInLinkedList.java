
package com.loki.randomproblems.linkedlist;

public class LoopInLinkedList {
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

	public void print() {
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

	public boolean isLoopExists() {
		if (head == null) {
			return false;
		}

		Node slow = head, fast = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) {
				break;
			}
			fast = fast.next;
			if (slow == fast)
				return true;
		}
		return false;

	}

	public void startOfLoop() {
		if (head == null) {
			return;
		}
		boolean isLoop = false;
		Node slow = head, fast = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast == null) {
				break;
			}
			fast = fast.next;
			if (slow == fast)
				isLoop = true;
				break;
		}

		if (isLoop) {
			slow = head;
			while (true) {
				fast = fast.next;
				slow = slow.next;
				if (slow == fast) {
					System.out.println("loop starts from " + slow.data);
					break;
					
				}

			}

		}

	}

	public static void main(String[] args) {
		LoopInLinkedList ll = new LoopInLinkedList();
		ll.head = new Node(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.print();
		ll.head.next.next.next.next.next = ll.head.next;
		System.out.println(ll.isLoopExists());
		ll.startOfLoop();
		// ll.print();

		/*
		 * System.out.println(ll.nthNode(2));
		 * System.out.println(ll.nthNodeMethod1(2));
		 */

	}

}
