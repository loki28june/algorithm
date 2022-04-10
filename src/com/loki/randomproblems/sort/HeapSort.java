package com.loki.randomproblems.sort;

public class HeapSort {
	int[] arr = { 34, 12, 54, 23, 56, 32, 12, 90, 10 };
	int len = arr.length;

	public void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void quickSort(int low, int high) {
		int i = low, j = high;
		int pivot = arr[low + (high - low) / 2];
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (pivot < arr[j]) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (i < high) {
			quickSort(i, high);
		}

		if (low < j) {
			quickSort(low, j);
		}
	}

	public static void main(String[] args) {
		HeapSort qs = new HeapSort();
		qs.print();
		qs.quickSort(0, qs.len - 1);
		qs.print();

	}

}
