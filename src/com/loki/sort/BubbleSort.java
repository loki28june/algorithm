package com.loki.sort;

public class BubbleSort {
	int[] arr = { 64, 25, 12, 22, 11 };
	int n = arr.length;

	public void selectionSort() {

		for (int i = 0; i < n -1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
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
		BubbleSort s = new BubbleSort();
		s.print();
		s.selectionSort();
		s.print();

	}

}
