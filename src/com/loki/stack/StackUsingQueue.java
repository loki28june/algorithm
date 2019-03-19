package com.loki.stack;

import java.util.LinkedList;
import java.util.Queue;;

public class StackUsingQueue {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void costlyPush(int n) {
		q2.add(n);
		while (q1.size() != 0) {
			q2.add(q1.remove());
		}

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public Integer efficientPop() {
		return q1.poll();
	}

	public void efficientPush(int n) {
		q1.add(n);
	}

	public Integer costlyPop() {
		while (q1.size() > 1) {
			q2.add(q1.poll());
		}

		int result = q1.poll();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;

		return result;
	}

	public void printStack() {
		for (Integer i : q1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingQueue stack1 = new StackUsingQueue();
		stack1.costlyPush(6);
		stack1.costlyPush(34);
		stack1.costlyPush(12);
		stack1.costlyPush(45);
		stack1.costlyPush(23);
		stack1.printStack();
		System.out.println("element popped from stack => " + stack1.efficientPop());
		System.out.println("element popped from stack => " + stack1.efficientPop());
		stack1.costlyPush(28);
		stack1.printStack();

		StackUsingQueue stack2 = new StackUsingQueue();
		stack2.efficientPush(6);
		stack2.efficientPush(34);
		stack2.efficientPush(12);
		stack2.efficientPush(45);
		stack2.efficientPush(23);
		stack2.printStack();
		System.out.println("element popped from stack => " + stack2.costlyPop());
		System.out.println("element popped from stack => " + stack2.costlyPop());
		stack2.efficientPush(28);
		stack2.printStack();
	}

}
