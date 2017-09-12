package com.loki.linkedlist;

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
		if (head == null){
			head = new Node(data);
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(data);
	}
	
	public void printList(){
		if(head == null)
			return;
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public void swapElements(){
		if(head == null || head.next == null){
			return;
		}
		
		Node first = head;
		Node second = head.next;
		
		while(first != null && second != null){
			Node temp = first;
			first = second;
			second = first;
			
			if(first.next != null && first.next.next != null){
				first = first.next.next;
				
			}
			
			if(first.next != null && first.next.next != null){
				first = first.next.next;
				
			}
			
			
			
			
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

	}

}
