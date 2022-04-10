package com.loki.randomproblems.array;

public class Fibonoacci {

	public static void main(String[] args) {
		// System.out.println("\nPrinting raw value " + print(10));
		printFibonacci(10);
		
		//printFibonacciValue(10);
	}

	public static void printFibonacci(int n) {
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print(fib(i, values) + " ");
		}

	}

	public static void printFibonacciValue(int n) {
		int[] values = new int[n];
		values[0] = 0;
		values[1] = 1;
		for (int i = 2; i < n; i++) {
			values[i] = values[i - 1] + values[i - 2];

		}
		System.out.println(values[n - 1]);
		;
	}

	public static int fib(int no, int[] values) {
		if (no == 0 || no == 1) {
			values[no] = no;
			return values[no];
		}
		values[no] = values[no - 1] + values[no - 2];
		return values[no];

	}

}
