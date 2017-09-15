package com.loki.stack;

public class Stack {
	private Node top;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

	}
	
	public void push(int n){
		if(top == null){
			top = new Node(n);
			return;
		}
		
		Node temp = new Node(n);
		temp.next = top;
		top = temp;
	}
	
	public Node pop(){
		if(top == null){
			return null;
		}
		
		Node temp = top;
		top = top.next;
		return temp;
	}
	
	public void printStack(){
		Node temp = top;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(7);
		s.push(3);
		s.push(9);
		s.push(2);
		s.push(6);
		s.printStack();
		System.out.println("Item popped out "+ s.pop().data);
		System.out.println("Item popped out "+ s.pop().data);
		s.push(28);
		s.printStack();

	}

}
