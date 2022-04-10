package com.loki.randomproblems.sort;

public class InsertionSort {
	int[] arr = { 64, 25, 12, 22, 11 };
	int n = arr.length;

	public void insertionSort() {

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		InsertionSort s = new InsertionSort();
		s.print();
		s.insertionSort();
		s.print();

	}

}
