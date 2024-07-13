package com.loki.basic.dsa.sort;

public class MergeSort {
	/*
	 * int[] arr = {38, 27, 43, 3, 9, 82, 10}; int n = arr.length;
	 */

	public void merge(int[] arr, int l, int m, int r) {

		int lSize = m - l + 1;
		int rSize = r - m;

		int[] lArr = new int[lSize];
		int[] rArr = new int[rSize];

		for (int i = 0; i < lSize; i++) {
			lArr[i] = arr[l + i];
		}

		for (int i = 0; i < rSize; i++) {
			rArr[i] = arr[m + i + 1];
		}

		int i = 0, j = 0, k = l;

		while (i < lSize && j < rSize) {
			if (lArr[i] < rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}

		if (i != lSize) {
			while (i < lSize) {
				arr[k] = lArr[i];
				i++;
				k++;
			}
		}

		if (j != rSize) {
			while (j < rSize) {
				arr[k] = rArr[j];
				j++;
				k++;
			}
		}
	}

	public void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}

	}

	public void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSort s = new MergeSort();
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		int n = arr.length;
		s.print(arr);
		s.sort(arr, 0, n - 1);
		s.print(arr);

	}

}
