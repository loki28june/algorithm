package com.loki.randomproblems.queue;

public class Queue {
	QNode front, rear;

	public Queue() {
		this.front = this.rear = null;

	}

	private class QNode {
		int data;
		QNode next;

		public QNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void enqueue(int n) {
		// Queue is empty
		if (rear == null) {
			rear = new QNode(n);
			front = rear;
			return;
		}

		rear.next = new QNode(n);
		rear = rear.next;
	}

	public QNode dequeue() {
		if (front == null) {
			return null;

		}
		QNode temp = front;
		front = front.next;
		if(front == null){
			rear = null;
		}
		return temp;
	}
	
	private void printQueue(){
		QNode temp = front;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(3);
		q.enqueue(7);
		q.enqueue(1);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(5);
		q.printQueue();
		System.out.println("Elements removed from queue is => "+ q.dequeue().data);
		q.printQueue();
		
	}

}
