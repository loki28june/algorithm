package com.loki.stack;

import com.loki.queue.Queue;

public class StackUsingQueue {
	Node top;
	Queue q;
	
	public StackUsingQueue(){
		q = new Queue();
	}
	
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
			q.enqueue(n);
			//top = 
		}
		
	}
	
	

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		
		

	}

}
