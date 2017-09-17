package com.loki.stack;

import java.util.LinkedList;
import java.util.Queue;;

public class StackUsingQueue {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	// Costly push
	public void push1(int n) {
		q2.add(n);
		while (q1.size() != 0) {
			q2.add(q1.remove());
		}

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	// Efficient pop
	public Integer pop1() {
		return q1.poll();

	}

	// Efficient push
	public void push2(int n) {
		q1.add(n);
	}

	// costly pop
	public Integer pop2() {
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
		stack1.push1(6);
		stack1.push1(34);
		stack1.push1(12);
		stack1.push1(45);
		stack1.push1(23);
		stack1.printStack();
		System.out.println("element popped from stack => " + stack1.pop1());
		System.out.println("element popped from stack => " + stack1.pop1());
		stack1.push1(28);
		stack1.printStack();

		StackUsingQueue stack2 = new StackUsingQueue();
		stack2.push2(6);
		stack2.push2(34);
		stack2.push2(12);
		stack2.push2(45);
		stack2.push2(23);
		stack2.printStack();
		System.out.println("element popped from stack => " + stack2.pop2());
		System.out.println("element popped from stack => " + stack2.pop2());
		stack2.push2(28);
		stack2.printStack();
	}

}
