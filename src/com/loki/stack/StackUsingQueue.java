package com.loki.stack;

import java.util.LinkedList;
import java.util.Queue;;

public class StackUsingQueue {
	Node top;
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;

		}
	}
	
	public void push(int n){
		q2.add(n);
		while(q1.size() != 0){
			q2.add(q1.remove());
		}
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public Node pop(){
		return null;
	}
	

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		
		

	}

}
